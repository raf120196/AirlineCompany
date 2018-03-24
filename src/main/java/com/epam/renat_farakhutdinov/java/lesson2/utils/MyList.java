package com.epam.renat_farakhutdinov.java.lesson2.utils;

import java.util.Iterator;

/**
 * Created by Renat Farakhutdinov on 25.02.2018.
 */
public interface MyList<E> {
    public void add(E value);
    public E get(int index);
    public boolean set(int index, E value);
    public boolean add(int index, E value);
    public int indexOf(E value);
    public int size();
    public E remove(int index);
    public boolean remove(E value);
    public Iterator<E> iterator();
}