package com.company;

public class MyLinkedList<E> {

    // 节点
    private class Node {
        public E e; // 数据域
        public Node next; // 指针域(指向)


        // 构造函数，初始化方法
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(Node next) {
            this(null, next);
        }

        public Node() {
            this(null, null);
        }

    }

    // 头结点(虚拟的)
    private Node dummyHead;
    // 大小
    private int size;


    // 初始化
    public MyLinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    // 大小
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    // 添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            // 异常
            return;
        }

        // 第0个节点的前一个节点就是 dummyHead
        Node previous = dummyHead;
        for (int i = 0; i < index; i++) {
            previous = previous.next;
        }

        previous.next = new Node(e, previous.next);

        size++;
    }


    // 遍历 - 内部方法
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        // 从第 0 个节点开始遍历，也就是 dummyHead 的 next 指向
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    // 遍历
    public E get(int index) {
        Node current = getNode(index);
        return current == null ? null : current.e;
    }

    public E getFirst() {
       return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    // 包含
    public boolean contains(E e) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false; // 没有找到返回 false
    }


    // 修改
    public void set(int index, E e) {
        Node current = getNode(index);
        if (current != null) {
            current.e = e;
        }
    }


    // 删除
    public E delete(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node previous = dummyHead;
        for (int i = 0; i < index; i++) {
            previous = previous.next;
        }

        Node current = previous.next;
        previous.next = current.next;
        current.next = null;

        size--;

        return current.e;
    }

    public E deleteFirst() {
       return delete(0);
    }

    public E deleteLast() {
        return delete(size - 1);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        for(Node cur = dummyHead.next ; cur != null ; cur = cur.next)
            res.append(cur.e + "->");
        res.append("NULL");

        return res.toString();
    }

}

/**
 * 索引index的校验，添加操作和获取操作是不一样的
 *
 * 相同点：index 都不可以小于 0
 * 不通电：添加操作可以为size，但是获取操作不可以为size，最大索引是size-1
 *
 * */