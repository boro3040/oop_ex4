/*
Barak Davidovitch
211604350
oop - ex4
 */

import java.util.List;
import java.util.ArrayList;

/**
 * class of static accessories methods.
 */
public class Util {

    /**
     * Returns the union of two ArrayLists.
     * @param list1 the first ArrayList
     * @param list2 the second ArrayList
     * @return a new ArrayList containing the union of list1 and list2
     * @param <T> the generic type that list made of.
     */
    public static <T> List<T> union(List<T> list1, List<T> list2) {

        if ((list1 == null) & (list2 == null)) {
            return null;
        } else if (list1 == null) {
            return new ArrayList<>(list2);
        } else if (list2 == null) {
            return new ArrayList<>(list1);
        }

        List<T> unionList = new ArrayList<>(list1);
        for (T item : list2) {
            if (!unionList.contains(item)) {
                unionList.add(item);
            }
        }

        return unionList;
    }
}
