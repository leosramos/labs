package foo.jpql.model;

public enum JunctionOperator {
	AND("and "), OR("or ");

	private String JunctionOperatorValue;

	private JunctionOperator(String junctionOperatorValue) {
		JunctionOperatorValue = junctionOperatorValue;
	}

	public String getJunctionOperatorValue() {
		return JunctionOperatorValue;
	}

	public void setJunctionOperatorValue(String junctionOperatorValue) {
		JunctionOperatorValue = junctionOperatorValue;
	}

}
