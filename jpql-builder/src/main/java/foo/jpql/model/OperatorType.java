package foo.jpql.model;

public enum OperatorType {

	EQUALS("="),

	LIKE("like"),

	IS_TRUE("is true");

	private String operator;

	private OperatorType(String operator) {
		this.operator = operator;
	}

	public String getOperatorValue() {
		return operator;
	}

}
