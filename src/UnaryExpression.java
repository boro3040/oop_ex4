/*
Barak Davidovitch
211604350
oop - ex4
 */

import java.util.Map;

/**
 * Class representing the Unary Expressions.
 */
public abstract class UnaryExpression extends BaseExpression {

    /**
     * The constructor.
     * @param leftExp the left Expression in the Unary Expression.
     * @param rightExp the right Expression in the Unary Expression.
     */
    public UnaryExpression(Expression leftExp, Expression rightExp) {
        super();
        this.setLeftExp(leftExp);
        this.setRightExp(rightExp);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return applyOperator(this.getLeftExp().evaluate(assignment),
                            this.getRightExp().evaluate(assignment));
    }

    @Override
    public Boolean evaluate() throws Exception {
        return applyOperator(this.getLeftExp().evaluate(),
                            this.getRightExp().evaluate());
    }

    @Override
    public String toString() {
        return "(" + this.getLeftExp().toString() + " " + this.getSign()
                + " " + this.getRightExp().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Expression newLeft = this.getLeftExp().assign(var, expression);
        Expression newRight = this.getRightExp().assign(var, expression);
        Expression newExp = this.copy();

        ((UnaryExpression) newExp).setLeftExp(newLeft);
        ((UnaryExpression) newExp).setRightExp(newRight);
        return newExp;
    }

    @Override
    public Expression copy() {
        return createNewInstance(getLeftExp().copy(), getRightExp().copy());
    }

    /**
     * This method takes 2 values and compute the logic operator of Class.
     * @param val1 The first Boolean value.
     * @param val2 The second Boolean value.
     * @return The val1 OP val2, when OP is the specific operator.
     */
    protected abstract Boolean applyOperator(Boolean val1, Boolean val2);
}
