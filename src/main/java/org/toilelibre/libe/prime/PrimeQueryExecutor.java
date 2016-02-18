package org.toilelibre.libe.prime;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.toilelibre.libe.prime.PrimeWhereSubExprFinder.SubExpression;
import org.toilelibre.libe.prime.primeParser.ArgsContext;
import org.toilelibre.libe.prime.primeParser.QueryContext;

class PrimeQueryExecutor {
    private static List<PrimeWhere> buildConditionsList (final primeParser.QueryContext query) {
        final List<PrimeWhere> conditions = new ArrayList<PrimeWhere> ();
        for (int i = 0 ; i < query.wherecriterias ().criterias ().criteria ().size () ; i++) {
            final primeParser.CriteriaContext criteria = query.wherecriterias ().criterias ().criteria ().get (i);
            final primeParser.ConjunctionContext conjunction = i > 0 ? query.wherecriterias ().criterias ().conjunction (i - 1) : null;
            final Object [] args = PrimeQueryExecutor.popArgs (criteria.expression ().args ());
            conditions
                    .add (new PrimeWhere (conjunction == null ? null : conjunction.getText (), (criteria.LPAREN () == null ? Collections.emptyList () : criteria.LPAREN ()).size (),
                            criteria.expression ().getText (), args, criteria.operator ().getText (), criteria.value ().getText ().replaceAll ("^'", "").replaceAll ("'$", ""),
                            (criteria.RPAREN () == null ? Collections.emptyList () : criteria.RPAREN ()).size ()));

        }
        return conditions;
    }

    public static <T> List<T> execute (final String request) {
        final primeParser parser = new primeParser (new CommonTokenStream (new primeLexer (new ANTLRInputStream (request))));

        List<T> result = null;
        for (final primeParser.CommandContext command : parser.primerequest ().command ()) {
            if (!command.query ().isEmpty ()) {
                result = PrimeQueryExecutor.executeQuery (command.query ());
            }
        }
        return result;
    }

    private static <T> List<T> executeDatabaseQuery (final Class<T> type, final List<PrimeWhere> conditions, final int limit) {
        return PrimeQueryExecutor.launchQuery (type, conditions, null, null, null, limit);
    }

    private static <T> List<T> executeObjectQuery (final Object container, final Method method, final Class<T> type, final List<PrimeWhere> conditions, final int limit) {
        return PrimeQueryExecutor.launchQuery (type, conditions, container, method, null, limit);
    }

    private static <T> List<T> executeQuery (final Class<T> type, final Method methodIfExists, final List<PrimeWhere> conditions, final String listId, final int limit) {
        final Object container = ReferenceRecorder.popCurrentThreadRecordedObject ();
        if ( (container == null) && (listId == null)) {
            return PrimeQueryExecutor.executeDatabaseQuery (type, conditions, limit);
        } else if (listId != null) {
            return PrimeQueryExecutor.executeSourceListQuery (type, conditions, listId, limit);
        }
        return PrimeQueryExecutor.executeObjectQuery (container, methodIfExists, type, conditions, limit);
    }

    private static <T> List<T> executeQuery (final primeParser.QueryContext query) {
        final String typeAsString = query.returnedType ().getText ();
        final Method method = PrimeQueryExecutor.getMethodIfApplicable (typeAsString);
        final String listId = PrimeQueryExecutor.getSourceListIdIfApplicable (query);
        Class<T> returnType = null;
        if (method != null) {
            returnType = PrimeQueryExecutor.getParameterizedReturnType (method);
        } else {
            returnType = PrimeQueryExecutor.getCorrectReturnType (typeAsString);
        }

        final List<PrimeWhere> conditions = PrimeQueryExecutor.buildConditionsList (query);
        final int limit = PrimeQueryExecutor.getLimitValue (query);
        final List<T> result = PrimeQueryExecutor.executeQuery (returnType, method, conditions, listId, limit);
        PrimeQueryExecutor.storeSaveAsResultList (query, returnType, result);
        return result;
    }

    private static <T> List<T> executeSourceListQuery (final Class<T> type, final List<PrimeWhere> conditions, final String listId, final int limit) {
        return PrimeQueryExecutor.launchQuery (type, conditions, null, null, listId, limit);
    }

    @SuppressWarnings ("unchecked")
    private static <T> Class<T> findReturnTypeForParameterizedType (final ParameterizedType pt) {
        if (Map.class.isAssignableFrom ((Class<?>) pt.getRawType ())) {
            return (Class<T>) pt.getActualTypeArguments () [1];
        }
        if (Collection.class.isAssignableFrom ((Class<?>) pt.getRawType ())) {
            return (Class<T>) pt.getActualTypeArguments () [0];
        }
        return (Class<T>) pt.getRawType ();

    }

    @SuppressWarnings ("unchecked")
    private static <T> Class<T> getCorrectReturnType (final String typeAsString) {
        try {
            return (Class<T>) Class.forName (typeAsString);
        } catch (final ClassNotFoundException e1) {
            return null;
        }
    }

    private static int getLimitValue (final primeParser.QueryContext query) {
        final int limit = query.limit () == null ? -1 : Integer.parseInt (query.limit ().integer ().getText ());
        return limit;
    }

    private static Method getMethodIfApplicable (final String typeAsString) {
        try {
            return Class.forName (typeAsString.indexOf ('.') == -1 ? typeAsString : typeAsString.substring (0, typeAsString.lastIndexOf ('.')))
                    .getMethod (typeAsString.substring (typeAsString.lastIndexOf ('.') + 1));
        } catch (NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            return null;
        }
    }

    @SuppressWarnings ("unchecked")
    private static <T> Collection<T> getObjectTargetCollection (final Object container, final Method method) {
        try {
            method.setAccessible (true);
            final Object o = method.invoke (container);
            if (o instanceof Map) {
                return (Collection<T>) ((Map<?, ?>) o).values ();
            }
            return (Collection<T>) o;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            return null;
        }
    }

    private static <T> Class<T> getParameterizedReturnType (final Method m) {

        try {
            final Type type = m.getGenericReturnType ();
            if (type != null) {
                return PrimeQueryExecutor.findReturnTypeForParameterizedType ((ParameterizedType) type);
            }
            return null;
        } catch (final SecurityException e) {
            return null;

        }
    }

    private static String getSourceListIdIfApplicable (final QueryContext query) {
        return query.returnedType ().resultListType () != null ? query.returnedType ().resultListType ().field ().getText () : null;
    }

    @SuppressWarnings ("unchecked")
    private static <T> Collection<T> getTargetCollection (final Class<T> type, final Object container, final Method method, final String sourceListId) {
        return (Collection<T>) ( (container != null) && (method != null) ? PrimeQueryExecutor.getObjectTargetCollection (container, method)
                : sourceListId != null ? Database.getResultList (sourceListId) : Database.listType (type));
    }

    private static <T> List<T> launchQuery (final Class<T> type, final List<PrimeWhere> conditions, final Object container, final Method method, final String sourceListId,
            final int limit) {
        final List<List<SubExpression>> subExprs = PrimeWhereSubExprFinder.findSubConditions (conditions);
        final List<PrimeWhere> savedWhereList = new LinkedList<PrimeWhere> (subExprs.get (0).get (0).getExpressions ());

        final Collection<T> collection = PrimeQueryExecutor.getTargetCollection (type, container, method, sourceListId);
        final List<T> result = new ArrayList<T> ();
        final Iterator<T> iterator = collection.iterator ();
        int added = 0;
        while (iterator.hasNext () && ( (added < limit) || (limit < 0))) {
            final T element = iterator.next ();
            PrimeQueryExecutor.resetSubExprs (subExprs, savedWhereList);
            if (PrimeWhereResolver.findTruth (PrimeWhereResolver.resolve (subExprs, element).get (0).get (0))) {
                added++;
                result.add (element);
            }
        }
        return result;
    }

    private static Object [] popArgs (final ArgsContext args) {
        if ( (args != null) && (args.refArgs () != null)) {
            return ArgsStorage.popArgs (UUID.fromString (args.refArgs ().UUID ().getText ()));
        }
        return null;
    }

    private static void resetSubExprs (final List<List<SubExpression>> subExprsModel, final List<PrimeWhere> savedWhereList) {
        for (int i = 0 ; i < savedWhereList.size () ; i++) {
            subExprsModel.get (0).get (0).getExpressions ().set (i, savedWhereList.get (i));
        }
    }

    private static <T> void storeSaveAsResultList (final QueryContext query, final Class<T> resultListClass, final List<T> resultList) {
        if ( (query.saveAs () != null) && !"null".equals (query.saveAs ().field ().getText ())) {
            Database.saveResultList (query.saveAs ().field ().getText (), resultListClass, resultList);
        }
    }
}
