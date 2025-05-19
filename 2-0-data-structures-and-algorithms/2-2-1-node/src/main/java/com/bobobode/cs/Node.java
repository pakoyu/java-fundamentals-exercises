package com.bobobode.cs;

/**
 * Class {@link Node} is a very simple data structure that consists of an element itself and the reference to the next
 * node. An element can have any value since it's a generic. A reference to the next node allows to link {@link Node}
 * objects and build more comprehensive data structures on top of those liked nodes.
 *
 * @param <T> a generic type T
 * @author Taras Boychuk
 */
public class Node<T> {

    T e;
    Node<T> next;
    Node<T> prew;

    public Node(T e) {
        this.e = e;
    }

    public void setNext(Node<T> n) {
        next = n;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setPrew(Node<T> n) {
        prew = n;
    }

    public Node<T> getPrew() {
        return prew;
    }

    public T getElement() {
        return e;
    }
    // todo:
}
