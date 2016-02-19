package org.toilelibre.libe.prime;

class PrimeWhere implements Cloneable {

    private final String    conjunction;
    private final int       openedParentheses;
    private final String    expression;
    private final Object [] args;
	private final Class<?>[] paramTypes;
    private final String    operator;
    private final String    value;
    private final int       closedParentheses;

    public PrimeWhere (final String conjunction, final int openedParentheses, final String expression, final Class<?> [] paramTypes, final Object [] args, final String operator, final String value,
            final int closedParentheses) {
        super ();
        this.conjunction = conjunction;
        this.openedParentheses = openedParentheses;
        this.expression = expression;
        this.paramTypes = paramTypes;
        this.args = args;
        this.operator = operator;
        this.value = value;
        this.closedParentheses = closedParentheses;
    }

    @Override
    protected Object clone () throws CloneNotSupportedException {
        return super.clone ();
    }

    public Object [] getArgs () {
        return this.args;
    }

    public int getClosedParentheses () {
        return this.closedParentheses;
    }

    public String getConjunction () {
        return this.conjunction;
    }

    public String getExpression () {
        return this.expression;
    }

    public int getOpenedParentheses () {
        return this.openedParentheses;
    }

    public String getOperator () {
        return this.operator;
    }

    public String getValue () {
        return this.value;
    }

	public Class<?>[] getParamTypes() {
		return paramTypes;
	}

}
