/*
Barak Davidovitch
211604350
oop - ex4
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * a class representing boolean value.
 */
public class Val implements Expression {

    private Boolean val;

    /**
     * The constructor of the value.
     * @param val the Boolean true or false value.
     */
    public Val(Boolean val) {
        this.val = val;
    }

    @Override
    public List<String> getVariables() {
        return new ArrayList<>();
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return this.val;
    }

    @Override
    public Boolean evaluate() throws Exception {
        return this.val;
    }

    @Override
    public String toString() {
        if (this.val) {
            return "T";
        } else {
            return "F";
        }
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return this.copy();
    }

    @Override
    public Expression nandify() {
        return this.copy();
    }

    @Override
    public Expression norify() {
        return this.copy();
    }

    @Override
    public Expression simplify() {
        return new Val(this.getVal());
    }

    @Override
    public Expression copy() {
        return new Val(this.val);
    }

    /**
     * getter of the value of Val.
     * @return true or false, like Val.
     */
    protected Boolean getVal() {
        return this.val;
    }

    /**
     * setter of the value of Val.
     * @param val Boolean value we want to assign.
     */
    protected void setVal(Boolean val) {
        this.val = val;
    }

    @Override
    public boolean equals(Expression expression) {
        return this.toString().equals(expression.toString());
    }
}
