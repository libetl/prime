package org.toilelibre.libe.prime;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.toilelibre.libe.prime.PrimeWhereSubExprFinder.SubExpression;

class PrimeCommandReader {
    private static void resetSubExprs (final List<List<SubExpression>> subExprsModel, List<PrimeWhere> savedWhereList) {
    	for (int i = 0 ; i < savedWhereList.size () ; i++) {
    		subExprsModel.get(0).get(0).getExpressions().set(i, savedWhereList.get(i));
    	}
    }

    public static List<Object> execute (final String request) {
        final primeParser parser = new primeParser (new CommonTokenStream (new primeLexer (new ANTLRInputStream (request))));

        for (final primeParser.CommandContext command : parser.primerequest ().command ()) {
            if (!command.query ().isEmpty ()) {
                return PrimeCommandReader.executeQuery (command.query ());
            }
        }
        return null;
    }

    private static <T> List<T> executeDatabaseQuery (final Class<T> type, final List<PrimeWhere> conditions) {
        return PrimeCommandReader.launchQuery (type, conditions, null, null);
    }

    private static <T> List<T> executeObjectQuery (final Object container, final Method method, final Class<T> type, final List<PrimeWhere> conditions) {
        return PrimeCommandReader.launchQuery (type, conditions, container, method);
    }

    private static <T> List<T> executeQuery (final Class<T> type, final Method methodIfExists, final List<PrimeWhere> conditions) {
        final Object container = ReferenceRecorder.popCurrentThreadRecordedObject ();
        if (container == null) {
            return PrimeCommandReader.executeDatabaseQuery (type, conditions);
        }
        return PrimeCommandReader.executeObjectQuery (container, methodIfExists, type, conditions);
    }

    private static <T> List<T> executeQuery (final primeParser.QueryContext query) {
        final String typeAsString = query.returnedType ().getText ();
        final Method method = PrimeCommandReader.getMethodIfApplicable (typeAsString);
        Class<T> returnType = null;
        if (method != null) {
            returnType = PrimeCommandReader.getParameterizedReturnType (method);
        } else {
            returnType = PrimeCommandReader.getCorrectReturnType (typeAsString);
        }

        final List<PrimeWhere> conditions = new ArrayList<PrimeWhere> ();
        for (int i = 0 ; i < query.wherecriterias ().criterias ().criteria ().size () ; i++) {
            final primeParser.CriteriaContext criteria = query.wherecriterias ().criterias ().criteria ().get (i);
            final primeParser.ConjunctionContext conjunction = i > 0 ? query.wherecriterias ().criterias ().conjunction (i - 1) : null;
            conditions
                    .add (new PrimeWhere (conjunction == null ? null : conjunction.getText (), (criteria.LPAREN () == null ? Collections.emptyList () : criteria.LPAREN ()).size (),
                             criteria.expression ().getText (), criteria.operator ().getText (), criteria.value ().getText ().replaceAll ("^'", "").replaceAll ("'$", ""),
                            (criteria.RPAREN () == null ? Collections.emptyList () : criteria.RPAREN ()).size ()));

        }
        return PrimeCommandReader.executeQuery (returnType, method, conditions);
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

    private static Method getMethodIfApplicable (final String typeAsString) {
        try {
            return Class.forName (typeAsString.indexOf ('.') == -1 ? typeAsString : typeAsString.substring (0, typeAsString.lastIndexOf ('.'))).getMethod (typeAsString.substring (typeAsString.lastIndexOf ('.') + 1));
        } catch (NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            return null;
        }
    }

    private static <T> Class<T> getParameterizedReturnType (final Method m) {

        try {
            final Type type = m.getGenericReturnType ();
            if (type != null) {
                return PrimeCommandReader.findReturnTypeForParameterizedType ((ParameterizedType) type);
            }
            return null;
        } catch (final SecurityException e) {
            return null;

        }
    }

    @SuppressWarnings ("unchecked")
    private static <T> Collection<T> getTargetCollection (final Object container, final Method method) {
        try {
        	method.setAccessible(true);
            final Object o = method.invoke (container);
            if (o instanceof Map) {
                return (Collection<T>) ((Map<?, ?>) o).values ();
            }
            return (Collection<T>) o;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            return null;
        }
    }

    private static <T> List<T> launchQuery (final Class<T> type, final List<PrimeWhere> conditions, final Object container, final Method method) {
        final List<List<SubExpression>> subExprs = PrimeWhereSubExprFinder.findSubConditions (conditions);
        final List<PrimeWhere> savedWhereList = new LinkedList<PrimeWhere> (subExprs.get(0).get(0).getExpressions());
        @SuppressWarnings ("unchecked")
        final Collection<T> collection = (Collection<T>) ( (container != null) && (method != null) ? PrimeCommandReader.getTargetCollection (container, method)
                : Database.listType (type));
        final List<T> result = new ArrayList<T> ();
        for (final T element : collection) {
            PrimeCommandReader.resetSubExprs (subExprs, savedWhereList);
            if (PrimeWhereResolver.findTruth (PrimeWhereResolver.resolve (subExprs, element).get (0).get (0))) {
                result.add (element);
            }
        }
        return result;
    }
}
