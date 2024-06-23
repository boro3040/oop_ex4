/*
Barak Davidovitch
211604350
oop - ex4
 */

/**
 * This class is representing (Exp1 V Exp2).
 */
public class Nor extends UnaryExpression {

    /**
     * Constructor of the "nor" Expression with V sign.
     * @param leftExp The left expression in the "nor" statement.
     * @param rightExp The right expression in the "nor" statement.
     */
    public Nor(Expression leftExp, Expression rightExp) {
        super(leftExp, rightExp);
        this.setSign("V");
    }

    @Override
    protected Boolean applyOperator(Boolean val1, Boolean val2) {
        return !(val1 | val2);
    }

    @Override
    protected Expression createNewInstance(Expression newLeft, Expression newRight) {
        return new Nor(newLeft, newRight);
    }
}
