package com.bobocode.cs;

import com.bobocode.cs.exception.EmptyStackException;
import com.bobocode.util.ExerciseNotCompletedException;

/**
 * {@link LinkedStack} is a stack implementation that is based on singly linked generic nodes.
 * A node is implemented as inner static class {@link Node<T>}.
 * <p><p>
 * <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com">visit our website</a></strong>
 * <p>
 *
 * @param <T> generic type parameter
 * @author Taras Boychuk
 * @author Serhii Hryhus
 */
public class LinkedStack<T> implements Stack<T> {

    Node<T> head = new Node<T>();
    int size = 0;

    /**
     * This method creates a stack of provided elements
     *
     * @param elements elements to add
     * @param <T>      generic type
     * @return a new stack of elements that were passed as method parameters
     */
    public static <T> LinkedStack<T> of(T... elements) {
        LinkedStack<T> n  = new LinkedStack<T>();

        for (T e: elements) {
            n.push(e);
        }

        // for (int i = elements.length-1; i >= 0; i--) {
        //     n.push(elements[i]);
        // }

        return n;
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * The method pushes an element onto the top of this stack. This has exactly the same effect as:
     * addElement(item)
     *
     * @param element elements to add
     */
    @Override
    public void push(T element) {
        if (element.equals(null)) {
            throw new EmptyStackException();
        }
        Node<T> n1 = new Node<T>();
        n1.element = element;
        n1.next = head;
        head.prew = n1;
        head = n1;
        size++;
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * This method removes the object at the top of this stack
     * and returns that object as the value of this function.
     *
     * @return The object at the top of this stack
     * @throws EmptyStackException - if this stack is empty
     */
    @Override
    public T pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        T e = head.element;
        head = head.next;
        size--;
        return e;
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Returns the number of elements in the stack
     *
     * @return number of elements
     */
    @Override
    public int size() {
        return size;
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Checks if a stack is empty
     *
     * @return {@code true} if a stack is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size==0;
//        throw new ExerciseNotCompletedException(); // todo: implement this method;
    }

    public static class Node<T> {
        T element = null;
        Node<T> next;
        Node<T> prew;
    }

}
