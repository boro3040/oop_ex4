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

    @Override
    public Expression nandify() {
        Expression nandLeft = this.getLeftExp().nandify();
        return new Nand(nandLeft, nandLeft);
    }

    @Override
    public Expression norify() {
        Expression norLeft = this.getLeftExp().norify();
        return new Nor(norLeft, norLeft);
    }

    @Override
    public Expression simplify() {
        Expression newExp = super.simplify();
        if (newExp.equals(new Val(true)) | newExp.equals(new Val(false))) {
            return newExp;
        }

        Expression newLeft = this.getLeftExp().simplify();
        return new Not(newLeft);
    }
}
