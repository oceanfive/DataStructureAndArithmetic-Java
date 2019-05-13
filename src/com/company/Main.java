package com.company;

public class Main {

    public static void main(String[] args) {
//        testLinkedList();

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


    private static void testBST() {

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
