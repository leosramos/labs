package foo.jpql.model;

public class UnaryPredicate extends Predicate {

	public UnaryPredicate() {
		super();
	}

	public UnaryPredicate(String attrName, OperatorType operator) {
		super(attrName, operator);
	}

	@Override
	public String buildFragment() {
		return replace("%s %s ", getAttrName(), getOperator().getOperatorValue());
	}

}
