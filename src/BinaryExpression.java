/*
Barak Davidovitch
211604350
oop - ex4
 */

import java.util.Map;

/**
 * Class representing the binary expressions.
 */
public abstract class BinaryExpression extends BaseExpression {

    /**
     * The constructor.
     * @param leftExp the only binary expression we have.
     */
    public BinaryExpression(Expression leftExp) {
        super();
        this.setLeftExp(leftExp);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return applyOperator(this.getLeftExp().evaluate(assignment));
    }

    @Override
    public Boolean evaluate() throws Exception {
        return applyOperator(this.getLeftExp().evaluate());
    }

    @Override
    public String toString() {
        return this.getSign() + "(" + this.getLeftExp().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Expression newLeft = this.getLeftExp().assign(var, expression);
        Expression newExp = this.copy();

        ((BinaryExpression) newExp).setLeftExp(newLeft);
        return newExp;
    }

    @Override
    public Expression copy() {
        return createNewInstance(getLeftExp().copy(), null);
    }

    /**
     * This method takes val and compute the logic operator on the class.
     * @param val The Boolean value before.
     * @return The OP(val), when OP is the specific operator.
     */
    protected abstract Boolean applyOperator(Boolean val);
}
