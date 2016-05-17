package foo.jpql.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class PredicateGroupedExpression extends PredicateExpression {

	private List<Predicate> predicates;
	
	private JunctionOperator junctionOperator = JunctionOperator.OR;

	@Override
	public String buildFragment() {
		List<String> predicatesFragments = new ArrayList<>();
		for (Predicate predicate : predicates) {
			predicatesFragments.add(predicate.buildFragment());
		}
		String fragment = StringUtils.join(predicatesFragments, junctionOperator.getJunctionOperatorValue());
		return "(".concat(fragment).concat(")");
	}
	
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
