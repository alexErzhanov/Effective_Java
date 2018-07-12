package Chapter_5_Generics.Item_29_Favor_generic_types;

import java.util.EmptyStackException;

public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // The elements array will contain only E instances from push(E).
// This is sufficient to ensure type safety, but the runtime
// type of the array won't be E[]; it will always be Object[]!
    @SuppressWarnings("unchecked")
    public Stack() {
//        elements = new E[DEFAULT_INITIAL_CAPACITY];
        /**elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];*/
    }
    public void push(E e) {
        elements[size++] = e;
    }
    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    } // no changes in isEmpty or ensureCapacity
}
