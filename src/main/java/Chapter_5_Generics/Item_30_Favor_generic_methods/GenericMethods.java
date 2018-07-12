package Chapter_5_Generics.Item_30_Favor_generic_methods;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GenericMethods {

    // Generic method
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        return result;
    }

    // Using a recursive type bound to express mutual comparability
    /**may be read as “any type E that can be compared to itself”*/
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty())
            throw new IllegalArgumentException("Empty collection");
        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        return result;
    }
}
