package com.company;

public interface MyMap<K, V> {

    int getSize();
    boolean isEmpty();

    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);

    V get(K key);
    void set(K key, V value);
}
