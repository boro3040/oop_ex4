/*
Barak Davidovitch
211604350
oop - ex4
 */

/**
 * This class is representing (Exp1 | Exp2).
 */
public class Or extends UnaryExpression {

    /**
     * Constructor of the "or" Expression with | sign.
     * @param leftExp The left expression in the "or" statement.
     * @param rightExp The right expression in the "or" statement.
     */
    public Or(Expression leftExp, Expression rightExp) {
        super(leftExp, rightExp);
        this.setSign("|");
    }

    @Override
    protected Boolean applyOperator(Boolean val1, Boolean val2) {
        return (val1 | val2);
    }

    @Override
    protected Expression createNewInstance(Expression newLeft, Expression newRight) {
        return new Or(newLeft, newRight);
    }

    @Override
    public Expression nandify() {
        Expression nandLeft = this.getLeftExp().nandify();
        Expression nandRight = this.getRightExp().nandify();
        return new Nand(new Nand(nandLeft, nandLeft), new Nand(nandRight, nandRight));
    }

    @Override
    public Expression norify() {
        Expression norLeft = this.getLeftExp().norify();
        Expression norRight = this.getRightExp().norify();
        return new Nor(new Nor(norLeft, norRight), new Nor(norLeft, norRight));
    }
}
