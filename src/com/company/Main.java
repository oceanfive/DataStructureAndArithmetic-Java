package com.company;

import java.util.ArrayList;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
//        testLinkedList();
//        testBST();
//        testBSTSet();
//        testLinkedListSet();
        testLinkedListMap();
    }

    private static void testLinkedListMap() {
        MyLinkedListMap<String, String> map = new MyLinkedListMap<>();

        System.out.println(map);

        map.add("name", "jack");
        System.out.println(map);
        map.add("age", "20");
        System.out.println(map);
        map.add("name", "hello");
        System.out.println(map);
    }


    private static void testLinkedListSet() {

        System.out.println("LinkedListSet===");

        long beginTime = System.nanoTime();

        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            MyLinkedListSet<String> set1 = new MyLinkedListSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }

        long endTime = System.nanoTime();

        System.out.println((endTime - beginTime) / 1000000000.0);

//        System.out.println("===");
//
//        System.out.println("A Tale of Two Cities ");
//
//        ArrayList<String> words2 = new ArrayList<>();
//        if(FileOperation.readFile("a-tale-of-two-cities.txt", words2)){
//            System.out.println("Total words: " + words2.size());
//
//            MyLinkedListSet<String> set2 = new MyLinkedListSet<>();
//            for(String word: words2)
//                set2.add(word);
//            System.out.println("Total different words: " + set2.getSize());
//        }
    }

    private static void testBSTSet() {
        System.out.println("BSTSet===");

        long beginTime = System.nanoTime();

        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            BSTSet<String> set1 = new BSTSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }

        long endTime = System.nanoTime();

        System.out.println((endTime - beginTime) / 1000000000.0);

//        System.out.println("=====");


//        System.out.println("A Tale of Two Cities");
//
//        ArrayList<String> words2 = new ArrayList<>();
//        if(FileOperation.readFile("a-tale-of-two-cities.txt", words2)){
//            System.out.println("Total words: " + words2.size());
//
//            BSTSet<String> set2 = new BSTSet<>();
//            for(String word: words2)
//                set2.add(word);
//            System.out.println("Total different words: " + set2.getSize());
//        }
    }


    private static void testBST() {
        BST<Integer> bst = new BST<>();

        bst.add(5);
        bst.add(3);
        bst.add(6);
        bst.add(2);
        bst.add(4);
        bst.add(8);

//        System.out.println(bst.getSize());
//        System.out.println(bst.contains(6));
//        System.out.println(bst.contains(1));


//        bst.preOrder();

//        System.out.println("========");
//        System.out.println(bst);
//
//        System.out.println("========");
//
//        bst.levelOrder();


        System.out.println("========");
        System.out.println(bst);

        System.out.println("删除最小节点========");
        bst.removeMin();
        System.out.println(bst);

        System.out.println("删除最大节点========");
        bst.removeMax();
        System.out.println(bst);

        System.out.println("删除节点元素 4 ========");
        bst.remove(4);
        System.out.println(bst);
    }

    private static void testLinkedList() {
        MyLinkedList<Integer> list = new MyLinkedList();

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
