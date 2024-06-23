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

    @Override
    public Expression nandify() {
        Expression nandLeft = this.getLeftExp().nandify();
        Expression nandRight = this.getRightExp().nandify();
        return new Nand(new Nand(nandLeft, nandRight), new Nand(nandLeft, nandRight));
    }

    @Override
    public Expression norify() {
        Expression norLeft = this.getLeftExp().norify();
        Expression norRight = this.getRightExp().norify();
        return new Nor(new Nor(norLeft, norLeft), new Nor(norRight, norRight));
    }

    @Override
    public Expression simplify() {
        Expression newExp = super.simplify();
        if (newExp.equals(new Val(true)) | newExp.equals(new Val(false))) {
            return newExp;
        }

        Expression newLeft = this.getLeftExp().simplify();
        Expression newRight = this.getRightExp().simplify();
        if (newLeft.equals(new Val(true))) {
            return  newRight;
        } else if (newRight.equals(new Val(true))) {
            return  newLeft;
        } else if (newLeft.equals(new Val(false)) | newRight.equals(new Val(false))) {
            return new Val(false);
        } else if (newLeft.equals(newRight)) {
            return newLeft;
        }

        return new And(newLeft, newRight);
    }
}
