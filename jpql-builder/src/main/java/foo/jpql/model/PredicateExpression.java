package foo.jpql.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author jcruz
 *
 */
public abstract class PredicateExpression extends AbstractJPQLFragment {

	private List<Predicate> predicates;

	private JunctionOperator junctionOperator;

	public List<Predicate> getPredicates() {
		if (this.predicates == null) {
			this.predicates = new ArrayList<>();
		}
		return predicates;
	}

	public void setPredicates(List<Predicate> predicates) {
		this.predicates = predicates;
	}

	public JunctionOperator getJunctionOperator() {
		return junctionOperator;
	}

	public void setJunctionOperator(JunctionOperator junctionOperator) {
		this.junctionOperator = junctionOperator;
	}

}
