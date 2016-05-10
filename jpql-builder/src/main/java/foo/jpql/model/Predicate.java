package foo.jpql.model;

/**
 * 
 * @author jcruz
 *
 */
public class Predicate extends AbstractJPQLFragment {

	private String attrName;

	private OperatorType operator;

	public Predicate() {
		super();
	}

	public Predicate(String attrName, OperatorType operator) {
		super();
		this.attrName = attrName;
		this.operator = operator;
	}

	@Override
	public String buildFragment() {
		return null;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public OperatorType getOperator() {
		return operator;
	}

	public void setOperator(OperatorType operator) {
		this.operator = operator;
	}

}
