/*
Barak Davidovitch
211604350
oop - ex4
 */

/**
 * This class is representing (Exp1 A Exp2).
 */
public class Nand extends UnaryExpression {

    /**
     * Constructor of the "nand" Expression with A sign.
     * @param leftExp The left expression in the "nand" statement.
     * @param rightExp The right expression in the "nand" statement.
     */
    public Nand(Expression leftExp, Expression rightExp) {
        super(leftExp, rightExp);
        this.setSign("A");
    }

    @Override
    protected Boolean applyOperator(Boolean val1, Boolean val2) {
        return !(val1 & val2);
    }

    @Override
    protected Expression createNewInstance(Expression newLeft, Expression newRight) {
        return new Nand(newLeft, newRight);
    }

    @Override
    public Expression nandify() {
        Expression nandLeft = this.getLeftExp().nandify();
        Expression nandRight = this.getRightExp().nandify();
        return new Nand(nandLeft, nandRight);
    }

    @Override
    public Expression norify() {
        Expression norLeft = this.getLeftExp().norify();
        Expression norRight = this.getRightExp().norify();
        return new Nor(new Nor(new Nor(norLeft, norLeft), new Nor(norRight, norRight)),
                        new Nor(new Nor(norLeft, norLeft), new Nor(norRight, norRight)));
    }

    @Override
    public Expression simplify() {
        Expression newExp = super.simplify();
        if (newExp.equals(new Val(true)) | newExp.equals(new Val(false))) {
            return newExp;
        }

        Expression newLeft = this.getLeftExp().simplify();
        Expression newRight = this.getRightExp().simplify();
        if (newLeft.equals(new Val(false)) | newRight.equals(new Val(false))) {
            return  new Val(true);
        } else if (newLeft.equals(new Val(true))) {
            return new Not(newRight);
        } else if (newRight.equals(new Val(true))) {
            return new Not(newLeft);
        } else if (newLeft.equals(newRight)) {
            return new Not(newLeft);
        }

        return new Nand(newLeft, newRight);
    }
}
