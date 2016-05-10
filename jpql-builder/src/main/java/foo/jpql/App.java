package foo.jpql;

import foo.jpql.model.OperatorType;
import foo.jpql.model.PredicateUngroupedExpression;
import foo.jpql.model.UnaryPredicate;
import foo.jpql.model.WhereStatement;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		WhereStatement whereStatement = new WhereStatement();
		PredicateUngroupedExpression ungroupedExpression1 = new PredicateUngroupedExpression();
		
		whereStatement.getPredicateExpressions().add(ungroupedExpression1);
		
		UnaryPredicate unaryPredicate1 = new UnaryPredicate();
		unaryPredicate1.setAttrName("status");
		unaryPredicate1.setOperator(OperatorType.IS_TRUE);
		
		UnaryPredicate unaryPredicate2 = new UnaryPredicate();
		unaryPredicate2.setAttrName("name");
		unaryPredicate2.setOperator(OperatorType.LIKE);
		
		ungroupedExpression1.getPredicates().add(unaryPredicate1);
		ungroupedExpression1.getPredicates().add(unaryPredicate2);
		
		System.out.println(whereStatement.buildFragment());
	}
}
