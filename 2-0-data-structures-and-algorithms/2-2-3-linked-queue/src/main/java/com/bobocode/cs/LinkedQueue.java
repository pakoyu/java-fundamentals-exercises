package com.bobocode.cs;

import com.bobocode.util.ExerciseNotCompletedException;

/**
 * {@link LinkedQueue} implements FIFO {@link Queue}, using singly linked nodes. Nodes are stores in instances of nested
 * class Node. In order to perform operations {@link LinkedQueue#add(Object)} and {@link LinkedQueue#poll()}
 * in a constant time, it keeps to references to the head and tail of the queue.
 * <p><p>
 * <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com">visit our website</a></strong>
 * <p>
 *
 * @param <T> a generic parameter
 * @author Taras Boychuk
 * @author Ivan Virchenko
 */
public class LinkedQueue<T> implements Queue<T> {

    Node<T> head;
    Node<T> tail;
    int size = 0;

    /**
     * Adds an element to the end of the queue.
     *
     * @param element the element to add
     */
    public void add(T element) {
        if (this.isEmpty()) {
            tail = new Node<T>();
            tail.value = element;
            head = tail;
        }
        else {
            Node<T> n = new Node<T>();
            n.value = element;
            tail.next = n;
            n.prew = tail;
            tail = n;
        }
        size++;
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Retrieves and removes queue head.
     *
     * @return an element that was retrieved from the head or null if queue is empty
     */
    public T poll() {
        if (this.isEmpty()) {
            return null;
        }
        if (size == 1) {
            T t = head.value;
            head = null;
            tail = null;
            size--;
            return t;
        }
        T t = head.value;
        Node<T> n = head.next;
        head.next = null;
        head = n;
        head.prew = null;
        size--;
        return t;
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Returns a size of the queue.
     *
     * @return an integer value that is a size of queue
     */
    public int size() {
        return size;
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue is empty, returns {@code false} if it's not
     */
    public boolean isEmpty() {
        return size==0;
//        throw new ExerciseNotCompletedException(); // todo: implement this method
    }
    public static class Node<T> {
        T value = null;
        Node<T> next;
        Node<T> prew;
    }
}
