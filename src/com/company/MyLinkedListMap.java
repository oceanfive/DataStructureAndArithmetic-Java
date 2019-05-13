package com.company;

public class MyLinkedListMap<K, V> implements MyMap<K, V> {


    private class Node {
        K key;
        V value;
        Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node() {
            this(null, null, null);
        }
    }


    // 头结点(虚拟的)
    private Node dummyHead;
    // 大小
    private int size;

    public MyLinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }


    // 获取 key 对应的节点
    private Node getNode(K key) {
        if (key == null) {
            return null;
        }

        Node current = dummyHead.next;
        while (current != null) {
            if (current.key.equals(key)) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }


    @Override
    public void add(K key, V value) {
        if (key == null) {
            return;
        }
        if (contains(key)) {
            set(key, value);
        } else {
            // 总是在头部添加节点
            Node node = new Node(key, value);
            node.next = dummyHead.next;
            dummyHead.next = node;
            size++;
        }
    }

    @Override
    public V remove(K key) {
        Node previous = dummyHead;
        for (int i = 0; i < size - 1; i++) {
            previous = previous.next;
            if (previous.next.key.equals(key)) {
                break;
            }
        }

        if (previous != null) {
            Node current = previous.next;
            previous.next = current.next;
            current.next = null;
            size--;
            return current.value;
        }

        return null;
    }


    @Override
    public V get(K key) {
        return getNode(key).value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
        }
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("[\n");

        Node current = dummyHead.next;
        while (current != null) {
            sb.append(current.key + ":" + current.value + "\n");
            current = current.next;
        }

        sb.append("]\n");
        return sb.toString();
    }
}
