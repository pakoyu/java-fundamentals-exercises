package com.bobocode.cs;


import com.bobocode.util.ExerciseNotCompletedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

/**
 * {@link LinkedList} is a list implementation that is based on singly linked generic nodes. A node is implemented as
 * inner static class {@link Node<T>}.
 * <p><p>
 * <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com">visit our website</a></strong>
 * <p>
 *
 * @param <T> generic type parameter
 * @author Taras Boychuk
 * @author Serhii Hryhus
 */

public class LinkedList<T> implements List<T> {
    Node<T> head;
    Node<T> tail;
    int size = 0;

    public static <T> LinkedList<T> of(T... elements) {
        LinkedList<T> l = new LinkedList<T>();
        for (T e : elements) {
            l.add(e);
        }
        return l;
    }

    @Override
    public void add(T element) {
        if (this.isEmpty()) {
            tail = new Node<T>();
            tail.value = element;
            head = tail;
            size++;
        } else {
            Node<T> n = new Node<T>();
            n.value = element;
            tail.next = n;
            tail = tail.next;
            size++;
        }
    }

    @Override
    public void add(int index, T element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (this.isEmpty() && index == 0 || index == size) {
            this.add(element);
        } else if (index == 0) {
            Node<T> n = new Node<T>();
            n.value = element;
            n.next = head;
            head = n;
            size++;
        } else {
            Node<T> n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            Node<T> n1 = n.next;
            Node<T> n2 = new Node<T>();
            n2.value = element;
            n.next = n2;
            n2.next = n1;
            size++;
        }
    }

    @Override
    public void set(int index, T element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        n.value = element;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n.value;
    }

    @Override
    public T getFirst() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.value;
    }

    @Override
    public T getLast() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.value;
    }

    @Override
    public T remove(int index) {
        if (index >= size || index < 0 || size == 0) {
            throw new IndexOutOfBoundsException();
        }
        if (size == 1) {
            T t = head.value;
            this.clear();
            return t;
        }
        if (index == 0) {
            T t = head.value;
            head = head.next;
            size--;
            return t;
        }
        Node<T> n = head;
        for (int i = 0; i < index-1; i++) {
            n = n.next;
        }
        if (index == size-1) {
            T t = n.next.value;
            n.next = null;
            tail = n;
            size--;
            return t;
        } else {
            T t = n.next.value;
            n.next = n.next.next;
            tail = n;
            size--;
            return t;
        }
    }

    @Override
    public boolean contains(T element) {
        boolean b = false;
        Node<T> n = head;
        for (int i = 0; i < size; i++) {
            if (n.value.equals(element)) {
                b = true;
            }
            n = n.next;
        }
        return b;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public static class Node<T> {
        T value;
        Node<T> next;
    }
}