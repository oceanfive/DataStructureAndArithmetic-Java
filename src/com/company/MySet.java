package com.company;

public interface MySet<E> {

    int getSize();
    boolean isEmpty();
    void add(E e);
    void remove(E e);
    boolean contains(E e);
}
