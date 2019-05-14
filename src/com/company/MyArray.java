package com.company;

public class MyArray<E> {

    private E[] data;
    private int size;

    public MyArray(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    public MyArray() {
        this(10);
    }

    public MyArray(E[] arr) {
        data = (E[])new Object[arr.length];
        size = arr.length;
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
    }

    // 大小
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getCapacity() {
        return data.length;
    }

    // 添加元素
    public void add(int index, E e) {
        if (index < 0 || index > getSize()) {
            return;
        }

        // 容量不足，需要扩容
        if (getSize() + 1 > getCapacity()) {
            resize(getCapacity() * 2);
        }

        // index 以及之后的元素后移 1 位 (需要重后往前遍历)
        for (int i = getSize() - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        // 插入元素
        data[index] = e;

        size++;
    }

    public void addAtFirst(E e) {
        add(0, e);
    }

    public void addAtLast(E e) {
        add(getSize(), e);
    }


    // 删除
    public E remove(int index) {
        if (index < 0 || index > getSize() - 1) {
            return null;
        }

        E e = data[index];

        // 从 index + 1 位置开始，后一个元素前移
        for (int i = index + 1; i < getSize(); i++) {
            data[i - 1] = data[i];
        }

        // 值为null
        data[getSize() - 1] = null;

        size--;

        return e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(getSize() - 1);
    }


    // 查找
    public E get(int index) {
        if (index < 0 || index > getSize() - 1) {
            return null;
        }

        return data[index];
    }

    public E getFrist() {
        return get(0);
    }

    public E getLast() {
        return get(getSize() - 1);
    }

    // 交换
    public void swap(int index1, int index2) {
        if (index1 < 0 || index1 > getSize() - 1) {
            return;
        }

        if (index2 < 0 || index2 > getSize() - 1) {
            return;
        }

        E tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
    }


    // 设置
    public void set(int index, E e) {
        if (index < 0 || index > getSize() - 1) {
            return;
        }
        data[index] = e;
    }

    // 扩容
    private void resize(int capacity) {
        E[] newData = (E[])new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }


    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
