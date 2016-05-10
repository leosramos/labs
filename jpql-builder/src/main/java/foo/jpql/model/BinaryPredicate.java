package foo.jpql.model;

public class BinaryPredicate extends Predicate {

	private PredicateParam param;

	@Override
	public String buildFragment() {
		return replace("%s %s %s", getAttrName(), getOperator().getOperatorValue(), param.buildFragment());
	}

	public PredicateParam getParam() {
		return param;
	}

	public void setParam(PredicateParam param) {
		this.param = param;
	}

}
