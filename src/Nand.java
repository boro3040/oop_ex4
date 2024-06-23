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
}
