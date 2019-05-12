package com.company;

public class Main {

    public static void main(String[] args) {
        testLinkedList();
    }

    private static void testLinkedList() {
        LinkedList<Integer> list = new LinkedList();

        for (int i = 0; i < 4; i++) {
            list.addFirst(i);
            System.out.println(list);
        }

        System.out.println("添加完毕=======");
        System.out.println(list);

        System.out.println("插入元素====");

        list.add(1, 50);;
        System.out.println(list);


        System.out.println("删除元素====");
        list.delete(3);
        System.out.println(list);

        System.out.println("删除第一个元素====");
        list.deleteFirst();
        System.out.println(list);

        System.out.println("删除最后一个元素====");
        list.deleteLast();
        System.out.println(list);
    }
}
