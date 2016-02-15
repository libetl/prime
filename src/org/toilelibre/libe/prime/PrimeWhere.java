package org.toilelibre.libe.prime;





public class PrimeWhere implements Cloneable {

    private String conjunction;
    private int openedParentheses;
    private String expression;
    private String operator;
    private String value;
    private int closedParentheses;


    public PrimeWhere (String conjunction, int openedParentheses, String expression, String operator, String value, int closedParentheses) {
        super ();
        this.conjunction = conjunction;
        this.openedParentheses = openedParentheses;
        this.expression = expression;
        this.operator = operator;
        this.value = value;
        this.closedParentheses = closedParentheses;
    }


    @Override
    protected Object clone () throws CloneNotSupportedException {
        return super.clone ();
    }


    public String getConjunction () {
        return conjunction;
    }


    public int getOpenedParentheses () {
        return openedParentheses;
    }


    public String getExpression () {
        return expression;
    }


    public String getOperator () {
        return operator;
    }


    public String getValue () {
        return value;
    }


    public int getClosedParentheses () {
        return closedParentheses;
    }


}
