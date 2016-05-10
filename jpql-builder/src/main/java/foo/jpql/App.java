package foo.jpql;

import foo.jpql.model.OperatorType;
import foo.jpql.model.PredicateExpression;
import foo.jpql.model.UnaryPredicate;
import foo.jpql.model.WhereStatement;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		WhereStatement whereStatement = new WhereStatement();
		PredicateExpression predicateExpression1 = new PredicateExpression();
		
		whereStatement.getPredicateExpressions().add(predicateExpression1);
		
		UnaryPredicate unaryPredicate1 = new UnaryPredicate();
		unaryPredicate1.setAttrName("status");
		unaryPredicate1.setOperator(OperatorType.IS_TRUE);
		
		UnaryPredicate unaryPredicate2 = new UnaryPredicate();
		unaryPredicate2.setAttrName("name");
		unaryPredicate2.setOperator(OperatorType.LIKE);
		
		predicateExpression1.getPredicates().add(unaryPredicate1);
		predicateExpression1.getPredicates().add(unaryPredicate2);
		
		System.out.println(whereStatement.buildFragment());
	}
}
