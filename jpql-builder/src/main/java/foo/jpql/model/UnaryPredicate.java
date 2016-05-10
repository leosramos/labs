package foo.jpql.model;

public class UnaryPredicate extends Predicate {

	@Override
	public String buildFragment() {
		return replace("%s %s ", getAttrName(), getOperator().getOperatorValue());
	}

}
