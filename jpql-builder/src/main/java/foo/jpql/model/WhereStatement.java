package foo.jpql.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author jcruz
 *
 */
public class WhereStatement extends AbstractJPQLFragment {

	private List<PredicateExpression> predicateExpressions;

	private JunctionOperator junctionOperator = JunctionOperator.AND;

	@Override
	public String buildFragment() {
		List<String> predicateExpressionFragments = new ArrayList<>();
		for (PredicateExpression predicateExpression : getPredicateExpressions()) {
			predicateExpressionFragments.add(predicateExpression.buildFragment());
		}
		String whereFragment = "where ".concat(StringUtils.join(predicateExpressionFragments, junctionOperator.getJunctionOperatorValue()));
		return whereFragment;
	}

	public List<PredicateExpression> getPredicateExpressions() {
		if (this.predicateExpressions == null) {
			this.predicateExpressions = new ArrayList<>();
		}
		return predicateExpressions;
	}

}
