package org.toilelibre.libe.prime;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.toilelibre.libe.prime.PrimeWhereSubExprFinder.SubExpression;

public class ReadPrimeCommand {
    private static Map<Integer, List<SubExpression>> cloneSubExprs (final Map<Integer, List<SubExpression>> subExprsMap) {
        final Map<Integer, List<SubExpression>> result = new HashMap<Integer, List<SubExpression>> ();
        for (final Entry<Integer, List<SubExpression>> entry : subExprsMap.entrySet ()) {
            result.put (entry.getKey (), new ArrayList<SubExpression> ());
            for (final SubExpression subexpr : entry.getValue ()) {
                result.get (entry.getKey ()).add ((SubExpression) subexpr.clone ());
            }
        }
        return result;
    }

    public static List<Object> execute (final String request) {
        final primeParser parser = new primeParser (new CommonTokenStream (new primeLexer (new ANTLRInputStream (request))));

        for (final primeParser.CommandContext command : parser.primerequest ().command ()) {
            final primeParser.CommandbodyContext commandBody = command.commandbody ();
            if (!commandBody.query ().isEmpty ()) {
                return ReadPrimeCommand.executeQuery (commandBody.query ());
            }
        }
        return null;
    }

    private static <T> List<T> executeDatabaseQuery (final Class<T> type, final List<PrimeWhere> conditions) {
        return ReadPrimeCommand.launchQuery (type, conditions, null, null);
    }

    private static <T> List<T> executeObjectQuery (final Object container, final Method method, final Class<T> type, final List<PrimeWhere> conditions) {
        return ReadPrimeCommand.launchQuery (type, conditions, container, method);
    }

    private static <T> List<T> executeQuery (final Class<T> type, final Method methodIfExists, final List<PrimeWhere> conditions) {
        final Object container = ReferenceRecorder.popCurrentThreadRecordedObject ();
        if (container == null) {
            return ReadPrimeCommand.executeDatabaseQuery (type, conditions);
        }
        return ReadPrimeCommand.executeObjectQuery (container, methodIfExists, type, conditions);
    }

    private static <T> List<T> executeQuery (final primeParser.QueryContext query) {
        final String typeAsString = query.returnedType ().getText ();
        final Method method = ReadPrimeCommand.getMethodIfApplicable (typeAsString);
        Class<T> returnType = null;
        if (method != null) {
            returnType = ReadPrimeCommand.getParameterizedReturnType (method);
        } else {
            returnType = ReadPrimeCommand.getCorrectReturnType (typeAsString);
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
        return ReadPrimeCommand.executeQuery (returnType, method, conditions);
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
                return ReadPrimeCommand.findReturnTypeForParameterizedType ((ParameterizedType) type);
            }
            return null;
        } catch (final SecurityException e) {
            return null;

        }
    }

    @SuppressWarnings ("unchecked")
    private static <T> Collection<T> getTargetCollection (final Object container, final Method method) {
        try {
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
        final Map<Integer, List<SubExpression>> subExprsModel = PrimeWhereSubExprFinder.findSubConditions (conditions);
        @SuppressWarnings ("unchecked")
        final Collection<T> collection = (Collection<T>) ( (container != null) && (method != null) ? ReadPrimeCommand.getTargetCollection (container, method)
                : Database.listType (type));
        final List<T> result = new ArrayList<T> ();
        for (final T element : collection) {
            final Map<Integer, List<SubExpression>> subExprs = ReadPrimeCommand.cloneSubExprs (subExprsModel);
            if (PrimeWhereResolver.findTruth (PrimeWhereResolver.resolve (subExprs, element).get (0).get (0))) {
                result.add (element);
            }
        }
        return result;
    }
}
