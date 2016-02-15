package org.toilelibre.libe.prime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.toilelibre.libe.prime.PrimeWhereSubExprFinder.SubExpression;


public class ReadPrimeCommand {
	public static List<Object> execute (String request) {
		// String request = "temp query bus Pod * * limit 5 where \"attribute[Ip Address]==64064.11540.50433.13730 and attribute[Pod Status]==nop\" select id dump |;";
		
		primeParser parser = new primeParser (new CommonTokenStream (new primeLexer (new ANTLRInputStream(request))));
		
		for (primeParser.CommandContext command : parser.primerequest().command()) {
			primeParser.CommandbodyContext commandBody = command.commandbody();
			if (!commandBody.query().isEmpty()) {
				try {
					return executeQuery(commandBody.query());
				} catch (ClassNotFoundException e) {
					throw new RuntimeException ("classNotFound : " + e.getMessage());
				}
			}
		}
		return null;
	}

	private static List<Object> executeQuery(primeParser.QueryContext query) throws ClassNotFoundException {
		String typeAsString = query.returnedType().getText();
		@SuppressWarnings("unchecked")
		Class<Object> type = (Class<Object>) Class.forName(typeAsString);
		
		List<PrimeWhere> conditions = new ArrayList<PrimeWhere> ();
		for (int i = 0 ; i < query.wherecriterias().criterias().criteria().size() ; i++) {
			primeParser.CriteriaContext criteria = query.wherecriterias().criterias().criteria().get(i);
			primeParser.ConjunctionContext conjunction = i > 0 ? query.wherecriterias().criterias().conjunction(i - 1) : null;
			conditions.add(new PrimeWhere (conjunction == null ? null : conjunction.getText (),
			        (criteria.LPAREN() == null ? Collections.emptyList() : criteria.LPAREN()).size(), 
					        criteria.expression().field()==null ? criteria.expression().method ().getText () : criteria.expression ().field ().getText (), 
					                criteria.operator().getText (),
					criteria.value().getText().replaceAll("^'", "").replaceAll("'$", ""),
					(criteria.RPAREN() == null ? Collections.emptyList() : criteria.RPAREN()).size()));
			
		}
		return executeQuery (type, conditions);
	}

    private static <T> List<T> executeQuery (Class<T> type, List<PrimeWhere> conditions) {
        Object container = ReferenceRecorder.popCurrentThreadRecordedObject ();
        if (container == null) {
            return executeDatabaseQuery (type, conditions);
        }
        return executeObjectQuery (container, type, conditions);
    }
    
    private static <T> List<T> executeDatabaseQuery (Class<T> type, List<PrimeWhere> conditions) {
        return launchQuery(type, conditions, null);
    }
    
    private static <T> List<T> executeObjectQuery (Object container, Class<T> type, List<PrimeWhere> conditions) {
        return launchQuery(type, conditions, container);
    } 

	private static <T> List<T> launchQuery(Class<T> type, List<PrimeWhere> conditions, Object container) {
		Map<Integer, List<SubExpression>> subExprs = PrimeWhereSubExprFinder.findSubConditions (conditions);
        List<T> list = Database.listType(type);
        List<T> result = new ArrayList<T> ();
        for (T element : list) {
        	if (PrimeWhereResolver.findTruth(PrimeWhereResolver.resolve(subExprs, element, container).get(0).get(0))) {
        		result.add(element);
        	}
        }
        return result;
	}   
}
