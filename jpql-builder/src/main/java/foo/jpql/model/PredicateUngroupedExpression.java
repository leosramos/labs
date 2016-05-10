package foo.jpql.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class PredicateUngroupedExpression extends PredicateExpression {

	public PredicateUngroupedExpression() {
		super();
		this.setJunctionOperator(JunctionOperator.OR);
	}

	@Override
	public String buildFragment() {
		List<String> predicateFraments = new ArrayList<>();
		for (Predicate predicate : getPredicates()) {
			predicateFraments.add(predicate.buildFragment());
		}
		return StringUtils.join(predicateFraments, getJunctionOperator().getJunctionOperatorValue());
	}

}
