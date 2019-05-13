package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<E>> {


    // 节点
    private class Node {
        E e;
        Node left;
        Node right;

        // 构造方法
        public Node(E e, Node left, Node right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }

        public Node(E e) {
            this(e, null, null);
        }

        public Node() {
            this(null, null, null);
        }
    }


    private Node root;
    private int size;

    // 构造方法
    public BST(Node root) {
        this.root = root;
        size = 0;
    }

    public BST() {
        this(null);
    }


    // 大小
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 添加
    public void add(E e) {
        root = add(root, e);
    }

    // 递归函数，给 根节点为 node 的二叉树添加元素 e，返回这个节点所在的二叉树的根节点
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            // 当前节点node，的左子树也是一个二叉树，这个二叉树的根节点是 node.left
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            // 当前节点node，的右子树也是一个二叉树，这个二叉树的根节点是 node.right
            node.right = add(node.right, e);
        }

        // 无论、大于、小于、等于的情况，都需要返回当前这个节点
        return node;
    }

    // 查找
    // 包含
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }


    // 遍历(深度优先)
    // 前序遍历
    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 中序遍历
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 后续遍历
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


    // 遍历(广度优先)
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root); // 根节点是第一个入队的节点

        // 循环条件是，队列的节点不为空
        while (!queue.isEmpty()) {
            Node node = queue.remove(); // 根节点也是第一个出队的节点
            System.out.println(node.e);

            // 节点出队的时候，需要把这个节点的左右孩子节点进行入队操作
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }


    // 获取最小节点
    public E min() {
        return min(root).e;
    }
    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    // 获取最大节点
    public E max() {
        return max(root).e;
    }
    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }


    // 删除
    // 删除最小的元素
    public E removeMin() {
        E min = min();
        removeMin(root);
        return min;
    }
    // 删除根节点为node的二叉树中的最小元素，返回的这个二叉树的根节点
    private Node removeMin(Node node) {

        // 已经找到最小的节点 (left == null)
        if (node.left == null) {
            Node right = node.right; // 右节点就是新的根节点
            node.right = null; // 当前节点右节点为null，左右都为null，释放
            size--;
            return right;
        }

        // 递归查找右节点，对当前节点的左子树进行查找，返回的根节点作为当前节点的根节点
        node.left = removeMin(node.left);
        return node;
    }

    // 删除最大的元素
    public E removeMax() {
        E max = max();
        removeMax(root);
        return max;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node left = node.left;
            node.left = null;
            size--;
            return left;
        }

        node.right = removeMax(node.right);
        return node;
    }


    // 删除任意元素
    public void remove(E e) {
        root = remove(root, e);
    }

    // 删除根节点为 node 的二叉树中的元素 e ，返回新的根节点，因为根节点会发生变化，新的根节点的挂接是在上一层递归函数中处理的
    private Node remove(Node node, E e) {
        // 找到这个元素所在节点

        // 没有找到
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            // 小于，从左子树中继续递归查找
            node.left = remove(node.left, e); // 查找结果继续挂在左节点上
            return node; // 左孩子，节点不变
        } else if (e.compareTo(node.e) > 0) {
            // 大于，从右子树中继续递归
            node.right = remove(node.right, e);
            return node; // 右孩子，节点不变
        } else {
            // 相等情况，找到了这个节点

            if (node.right == null) {
                // 只有左孩子
                Node left = node.left;
                node.left = null;
                size--;
                return left; // 左子树是新的根节点
            } else if (node.left == null) {
                // 只有右孩子
                Node right = node.right;
                node.right = null;
                size--;
                return right; // 右子树是新的根节点
            } else {
                // 左孩子、右孩子都存在的情况

                // 这个节点的右子树中找到最小的节点，并且新建一份
                Node rightMin = new Node(min(node.right).e);
                size++;
                // 最小的节点从右子树中删除
                removeMin(node.right);

                // 给新的根节点赋值，左右孩子
                rightMin.right = node.right;
                rightMin.left = node.left;

                // 原来的节点的左右孩子清空
                node.left = null;
                node.right = null;
                size--;

                // 节点赋值是在上一次递归函数中处理的
                return rightMin;
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }
}
