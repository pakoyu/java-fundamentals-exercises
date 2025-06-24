package com.bobocode.cs;

import com.bobocode.util.ExerciseNotCompletedException;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/**
 * {@link ArrayList} is an implementation of {@link List} interface. This resizable data structure
 * based on an array and is simplified version of {@link java.util.ArrayList}.
 * <p><p>
 * <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com">visit our website</a></strong>
 * <p>
 *
 * @author Serhii Hryhus
 */

public class ArrayList<T> implements List<T> {
    int initCapacity;
    int size = 0;
    T[] list;

    public ArrayList(int initCapacity) {
        if (initCapacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.list = (T[]) new Object[initCapacity];
        this.initCapacity = initCapacity; // todo: implement this method
    }

    public ArrayList() {
        this(5); // todo: implement this method
    }

    public static <T> List<T> of(T... elements) {
        List<T> list = new ArrayList(elements.length); // todo: implement this method
        for (T e : elements) {
            list.add(e);
        }
        return list;
    }

    @Override
    public void add(T element) {
        if (size+1 >= initCapacity) {
            initCapacity = initCapacity*2+1;
            T[] list1 = (T[]) new Object[initCapacity];
            int i = 0;
            for (T t: list) {
                list1[i] = t;
                i++;
            }
            list = list1;
        }
        list[size] = element;
        size++;
        // todo: implement this method
    }

    @Override
    public void add(int index, T element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (size+1 >= initCapacity) {
            initCapacity = initCapacity*2+1;
            T[] list1 = (T[]) new Object[initCapacity];
            int i = 0;
            for (T t: list) {
                list1[i] = t;
                i++;
            }
            list = list1;
        }
        if (index==size) {
            list[size] = element;
            size++;
        }
        else {
            for (int i = size-1; i >= index; i--) {
                list[i+1] = list[i];
            }
            size++;
            list[index] = element;
        }
        // todo: implement this method
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0 || isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return list[index]; // todo: implement this method
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[0]; // todo: implement this method
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[size-1]; // todo: implement this method
    }

    @Override
    public void set(int index, T element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        list[index] = element; // todo: implement this method
    }

    @Override
    public T remove(int index) {
        if (index >= size || index < 0  || isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size-1) {
            T t = list[index];
            list[index] = null;
            size--;
            return t;
        }
        T t = list[index];
        for (int i = index; i < size-1; i++) {
            list[i] = list[i+1];
        }
        size--;
        return t;
        // todo: implement this method
    }

    @Override
    public boolean contains(T element) {
        if (isEmpty()) {
            return false;
        }
        for (T t: list) {
            if (t.equals(element)) {
                return true;
            }
        } // todo: implement this method
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size==0; // todo: implement this method
    }

    @Override
    public int size() {
        return size; // todo: implement this method
    }

    @Override
    public void clear() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        size = 0;
        list = (T[]) new Object[initCapacity]; // todo: implement this method
    }
}