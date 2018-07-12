package Chapter_5_Generics.Item_31_Wildcard_flexibility;

import java.util.Collection;

public abstract class AbstractStack_without_wildcard <E> {

    abstract E pop();
    abstract void push(E e);
    abstract boolean isEmpty();


    // pushAll method without wildcard type - deficient!
    public void pushAll(Iterable<E> src) {
        for (E e : src)
            push(e);
    }

    // popAll method without wildcard type - deficient!
    public void popAll(Collection<E> dst) {
        while (!isEmpty())
            dst.add(pop());
    }
}
