/*
Barak Davidovitch
211604350
oop - ex4
 */

import java.util.List;

/**
 * The abstract base class of expressions. implements the Expression interface.
 */
public abstract class BaseExpression implements Expression {

    // not use rightExp in all classes (not in UnaryExpression)
    private Expression leftExp;
    private Expression rightExp;
    private String sign;

    /**
     * The constructor that get nothing, The real one will be in the
     * sons classes.
     */
    public BaseExpression() {
        this.leftExp = null;
        this.rightExp = null;
        this.sign = null;
    }

    @Override
    public List<String> getVariables() {
        if ((this.leftExp == null) & (this.rightExp == null)) {
            return null;
        } else if (this.leftExp == null) {
            return this.rightExp.getVariables();
        } else if (this.rightExp == null) {
            return this.leftExp.getVariables();
        }

        return Util.union(this.leftExp.getVariables(), this.rightExp.getVariables());
    }

    /**
     * Abstract method to be implemented by subclasses to create
     * a new instance of the same type.
     * @param newLeft new Expression on left.
     * @param newRight new Expression on right (on Binary is null).
     * @return The new instance expression.
     */
    protected abstract Expression createNewInstance(Expression newLeft, Expression newRight);

    /**
     * getter for leftExp.
     * @return the leftEXp.
     */
    protected Expression getLeftExp() {
        return this.leftExp.copy();
    }

    /**
     * setter to leftExp.
     * @param leftExp the Expression we want to put in.
     */
    protected void setLeftExp(Expression leftExp) {
        this.leftExp = leftExp.copy();
    }

    /**
     * getter for rightExp.
     * @return the rightEXp.
     */
    protected Expression getRightExp() {
        return this.rightExp.copy();
    }

    /**
     * setter to rightExp.
     * @param rightExp the Expression we want to put in.
     */
    protected void setRightExp(Expression rightExp) {
        this.rightExp = rightExp.copy();
    }

    /**
     * getter for sign.
     * @return a string representing the sign.
     */
    protected String getSign() {
        return this.sign;
    }

    /**
     * setter for sign.
     * @param sign the sign String we want to set.
     */
    protected void setSign(String sign) {
        this.sign = sign;
    }
}
