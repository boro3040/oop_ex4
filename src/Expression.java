/*
Barak Davidovitch
211604350
oop - ex4
 */

import java.util.List;
import java.util.Map;

/**
 * This interface is represent nested logical expressions that include variables
 * evaluate their values for specific variable assignments, convert them,
 * and simplify the results.
 */
public interface Expression {

    /**
     * Evaluate the expression using the variable values provided in the assignment,
     * and return the result.
     * @param assignment The mapping of vars to boolean values.
     * @return The Boolean value of the expression with the assignments.
     * @throws Exception If the expression contains a variable which is not in the assignment.
     */
    Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    /**
     * Evaluate the expression without using variable values and return the result.
     * @return The Boolean value of the expression.
     * @throws Exception If the expression contains any variable.
     */
    Boolean evaluate() throws Exception;

    /**
     * get a list of all variables in the expression.
     * @return a List of the variables in the expression.
     */
    List<String> getVariables();

    /**
     * make the representation a string.
     * @return Returns a nice string representation of the expression.
     */
    String toString();

    /**
     * This method takes a Var and Expression and change the var in the Expression
     * with the given Expression in all places.
     * @param var The var we want to change.
     * @param expression the expression we want to change to.
     * @return a new expression in which all occurrences of the variable var are
     * replaced with the provided expression (Does not modify the current expression).
     */
    Expression assign(String var, Expression expression);

    /**
     * Returns the expression tree resulting from converting all the operations
     * to the logical Nand operation.
     * @return Expression with only Nand signs.
     */
    Expression nandify();

    /**
     * Returns the expression tree resulting from converting all the operations
     * to the logical Nor operation.
     * @return Expression with only Nor signs.
     */
    Expression norify();

    /**
     * Returned a simplified version of the current expression.
     * @return The simple version of the Expression.
     */
    Expression simplify();

    /**
     * Create a copy of this expression.
     * @return A copy of this expression.
     */
    Expression copy();

    /**
     * Checks if 2 Expressions is equals based on their Strings.
     * @param expression the second Expression we want to compare to.
     * @return true if their string are equal, false otherwise.
     */
    boolean equals(Expression expression);
}
