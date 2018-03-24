package com.epam.renat_farakhutdinov.java.lesson2.companies;

import com.epam.renat_farakhutdinov.java.lesson2.utils.MyList;

import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Renat Farakhutdinov on 25.02.2018.
 */
public class PlanePark<E> implements Iterable<E>, Serializable, MyList<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private E[] values;
    private int index;
    private int size;

    public PlanePark() {
        values = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(E value) {
        if (index == values.length) {
            growArray();
        }

        values[index] = value;
        index++;
        size++;
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index is out of bound!");
        }

        return (E) values[index];
    }

    @Override
    public boolean set(int index, E value) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index is out of bound!");
        }

        if (index < size) {
            values[index] = value;
            return true;
        }

        return false;
    }

    @Override
    public boolean add(int index, E value) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index is out of bound!");
        }

        System.arraycopy(values, index, values, index + 1, size - index);
        values[index] = value;
        size++;
        return true;
    }

    @Override
    public int indexOf(E value) {
        if (value == null) {
            for (int i = 0; i < size; i++) {
                if (values[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (value.equals(values[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bound!");
        }

        E oldValue = values[index];
        int value = size - index - 1;
        if (value > 0) {
            System.arraycopy(values, index + 1, values, index, value);
        }
        values[--size] = null;

        return oldValue;
    }

    @Override
    public boolean remove(E value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(values[i])) {
                int v = size - i - 1;
                if (v > 0) {
                    System.arraycopy(values, index + 1, values, index, v);
                }
                values[--size] = null;

                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int cursor;

            @Override
            public boolean hasNext() {
                if (cursor >= size) {
                    return false;
                }
                return true;
            }

            @Override
            public E next() {
                int i = cursor;
                if (i >= size) {
                    throw new NoSuchElementException();
                }
                E[] elements2 = values;
                if (i > elements2.length) {
                    throw new ConcurrentModificationException();
                }
                cursor = i + 1;
                return (E) elements2[i];
            }

            @Override
            public void remove() {
            }
        };
    }

    private void growArray() {
        E[] newArray = (E[]) new Object[values.length * 2];
        System.arraycopy(values, 0, newArray, 0, index);
        values = newArray;
    }
}
