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

    @Override
    public Expression nandify() {
        Expression nandLeft = this.getLeftExp().nandify();
        Expression nandRight = this.getRightExp().nandify();
        return new Nor(new Nor(new Nor(nandLeft, nandLeft), new Nor(nandRight, nandRight)),
                new Nor(new Nor(nandLeft, nandLeft), new Nor(nandRight, nandRight)));
    }

    @Override
    public Expression norify() {
        Expression norLeft = this.getLeftExp().norify();
        Expression norRight = this.getRightExp().norify();
        return new Nor(norLeft, norRight);
    }

    @Override
    public Expression simplify() {
        Expression newExp = super.simplify();
        if (newExp.equals(new Val(true)) | newExp.equals(new Val(false))) {
            return newExp;
        }

        Expression newLeft = this.getLeftExp().simplify();
        Expression newRight = this.getRightExp().simplify();
        if (newLeft.equals(new Val(true)) | newRight.equals(new Val(true))) {
            return  new Val(false);
        } else if (newLeft.equals(new Val(false))) {
            return new Not(newRight);
        } else if (newRight.equals(new Val(false))) {
            return new Not(newLeft);
        } else if (newLeft.equals(newRight)) {
            return new Not(newLeft);
        }

        return new Nor(newLeft, newRight);
    }
}
