package foo.jpql.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author jcruz
 *
 */
public class PredicateExpression extends AbstractJPQLFragment {

	private List<Predicate> predicates;

	private JunctionOperator junctionOperator = JunctionOperator.AND;

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

	@Override
	public String buildFragment() {
		List<String> predicatesFragments = new ArrayList<>();
		for (Predicate predicate : predicates) {
			predicatesFragments.add(predicate.buildFragment());
		}
		return StringUtils.join(predicatesFragments, junctionOperator.getJunctionOperatorValue());
	}

}
