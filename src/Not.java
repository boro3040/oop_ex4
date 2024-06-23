/*
Barak Davidovitch
211604350
oop - ex4
 */

/**
 * This class is representing ~(Expression).
 */
public class Not extends BinaryExpression {

    /**
     * Constructor of the not expression with ~ sign.
     * @param leftExp The Expression we do him not.
     */
    public Not(Expression leftExp) {
        super(leftExp);
        this.setSign("~");
    }

    @Override
    protected Boolean applyOperator(Boolean val) {
        return !val;
    }

    @Override
    protected Expression createNewInstance(Expression newLeft, Expression newRight) {
        return new Not(newLeft);
    }
}
