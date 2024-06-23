/*
Barak Davidovitch
211604350
oop - ex4
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * a Class representing a Variable like String.
 */
public class Var implements Expression {

    private String var;

    /**
     * The constructor set the String of the variable.
     * @param var the variable String.
     */
    public Var(String var) {
        this.var = var;
    }

    @Override
    public List<String> getVariables() {
        List<String> list = new ArrayList<>();
        list.add(this.var);
        return list;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        if (assignment.containsKey(var)) {
            return assignment.get(var);
        } else {
            throw new Exception("Variable '" + var + "' not found in the assignment map.");
        }
    }

    @Override
    public Boolean evaluate() throws Exception {
        throw new Exception("No assignment map provided for evaluation.");
    }

    @Override
    public String toString() {
        return this.var;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        if (var.equals(this.var)) {
            return expression.copy();
        } else {
            return this.copy();
        }
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
        return new Var(this.getVar());
    }

    @Override
    public Expression copy() {
        return new Var(this.var);
    }

    /**
     * getter of the variable String.
     * @return String variable.
     */
    protected String getVar() {
        return this.var;
    }

    /**
     * setter of var String.
     * @param var the String of the variable.
     */
    protected void setVar(String var) {
        this.var = var;
    }

    @Override
    public boolean equals(Expression expression) {
        return this.toString().equals(expression.toString());
    }
}
