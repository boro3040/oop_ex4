/*
Barak Davidovitch
211604350
oop - ex4
 */

/**
 * This class is representing (Exp1 & Exp2).
 */
public class And extends UnaryExpression {

    /**
     * Constructor of the "and" Expression with & sign.
     * @param leftExp The left expression in the "and" statement.
     * @param rightExp The right expression in the "and" statement.
     */
    public And(Expression leftExp, Expression rightExp) {
        super(leftExp, rightExp);
        this.setSign("&");
    }

    @Override
    protected Boolean applyOperator(Boolean val1, Boolean val2) {
        return (val1 & val2);
    }

    @Override
    protected Expression createNewInstance(Expression newLeft, Expression newRight) {
        return new And(newLeft, newRight);
    }
}
