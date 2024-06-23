/*
Barak Davidovitch
211604350
oop - ex4
 */

import java.util.HashMap;

/**
 * Class that test the code.
 */
public class ExpressionsTest {

    /**
     * Main which runs code.
     * @param args non-relevant
     */
    public static void main(String[] args) {
        Expression x = new Var("x");
        Expression y = new Var("y");
        Expression z = new Var("z");
        Expression ex = new Xnor(new And(new Val(true), new Or(x, y)),
                        new Nor(new And(new Val(true), new Val(false)),
                        new Not(new And(z, new Val(true)))));
        System.out.println(ex);

        HashMap<String, Boolean> map = new HashMap<>();
        map.put("x", true);
        map.put("y", false);
        map.put("z", false);

        try {
            System.out.println(ex.evaluate(map));
        } catch (Exception ignored) {
        }

        System.out.println(ex.nandify().toString());
        System.out.println(ex.norify().toString());
        System.out.println(ex.simplify().toString());
    }
}
