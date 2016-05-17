package foo.jpql;

import foo.jpql.model.BinaryPredicate;
import foo.jpql.model.OperatorType;
import foo.jpql.model.PredicateExpression;
import foo.jpql.model.PredicateGroupedExpression;
import foo.jpql.model.StringPredicateParam;
import foo.jpql.model.UnaryPredicate;
import foo.jpql.model.WhereStatement;

/**
 * Hello world!
 *
 */
public class AppBinary {
	public static void main(String[] args) {
		WhereStatement whereStatement = new WhereStatement();
		
		PredicateGroupedExpression predicateExpression1 = new PredicateGroupedExpression();


		BinaryPredicate binaryPredicate1 = new BinaryPredicate();
		binaryPredicate1.setAttrName("name");
		binaryPredicate1.setOperator(OperatorType.LIKE);
		StringPredicateParam stringPredicateParam = new StringPredicateParam();
		stringPredicateParam.setAttributeName("name");
		stringPredicateParam.setOperatorType(OperatorType.LIKE);
		binaryPredicate1.setParam(stringPredicateParam);

		// Primeiro Predicado Unario
		UnaryPredicate unaryPredicate1 = new UnaryPredicate();
		unaryPredicate1.setAttrName("status");
		unaryPredicate1.setOperator(OperatorType.IS_TRUE);

		predicateExpression1.getPredicates().add(unaryPredicate1);
		PredicateExpression expression1 = new PredicateExpression();
		expression1.getPredicates().add(unaryPredicate1);
		//whereStatement.getPredicateExpressions().add(expression1);

		whereStatement.getPredicateExpressions().add(predicateExpression1);
		predicateExpression1.getPredicates().add(binaryPredicate1);
		System.out.println(whereStatement.buildFragment());
		
	}
}
