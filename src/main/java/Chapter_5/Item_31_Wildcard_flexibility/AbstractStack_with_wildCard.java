package Chapter_5.Item_31_Wildcard_flexibility;

import java.util.Collection;

public abstract class AbstractStack_with_wildCard<E> {

    abstract E pop();
    abstract void push(E e);
    abstract boolean isEmpty();


    // Wildcard type for a parameter that serves as an E producer
    public void pushAll(Iterable<? extends E> src) {
        for (E e : src)
            push(e);
    }

    // Wildcard type for parameter that serves as an E consumer
    public void popAll(Collection<? super E> dst) {
        while (!isEmpty())
            dst.add(pop());
    }
}
