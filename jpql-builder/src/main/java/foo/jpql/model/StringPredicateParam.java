package foo.jpql.model;

public class StringPredicateParam extends PredicateParam {

	private OperatorType operatorType;

	private String attributeName;

	private String value;

	@Override
	public String buildFragment() {
		return replace(" :%s ", attributeName);
	}

	public OperatorType getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(OperatorType operatorType) {
		this.operatorType = operatorType;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
