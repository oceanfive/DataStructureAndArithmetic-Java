package com.company;

public class MyLinkedListSet<E> implements MySet<E> {

    MyLinkedList<E> linkedList;

    public MyLinkedListSet(MyLinkedList<E> linkedList) {
        this.linkedList = linkedList;
    }

    public MyLinkedListSet() {
        this(new MyLinkedList<>());
    }


    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void add(E e) {
        // 去重操作
        if (!linkedList.contains(e)) {
            linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        if (linkedList.contains(e)) {
            linkedList.delete(e);
        }
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }
}
