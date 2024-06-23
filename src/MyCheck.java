import java.util.HashMap;
import java.util.Map;

public class MyCheck {
    public static void main(String[] args) {
        Expression e = new Xnor(new Nand(new Var("x"), new Val(false)),
                new Not(new And(new Or(new Var("x"), new Var("y")),
                        new Xor(new Val(true), new Var("z")))));
        System.out.println(e);
        System.out.println("Should print: ((x A F) # ~((x v y) ^ (T ⊕ z)))\n");
        e = e.assign("y", new Val(false));
        System.out.println("After assigning y = false: " + e);
        System.out.println("Should print: ((x A F) # ~((x v F) ^ (T ⊕ z)))\n");
        System.out.println("Should print: (T # ~((x ^ ~(z))))\n");
        Map<String, Boolean> map = new HashMap<>();
        map.put("x", true);
        map.put("z", false);
        try {
            System.out.println("evalute using x = true, z = false: " + e.evaluate(map));
            System.out.println("Should print: false");
        } catch (Exception ignored) {
            System.out.println("Error. Exception thrown during evaluation.");
        }


    }
}
