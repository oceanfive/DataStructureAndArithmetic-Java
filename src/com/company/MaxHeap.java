package com.company;

public class MaxHeap<E extends Comparable<E>> {

    MyArray<E> array;


    public MaxHeap() {
        array = new MyArray<>();
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChild(int index) {
        return 2 * index + 1;
    }

    private int getRightChild(int index) {
        return getLeftChild(index) + 1;
    }

    // heapfiy，把任意数组整理成二叉堆格式
    public MaxHeap(E[] arr) {
        array = new MyArray<>(arr);
        for (int i = getParent(array.getSize() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }


    // 添加
    public void add(E e) {
        // 二叉堆从左往右依次放置元素，也就是每次都是放到数组的最后一个
        array.addAtLast(e);

        // 这个元素到父节点，再到父节点....一直到根节点，进行大小的比较
        int curIndex = array.getSize() - 1;
        int parIndex = getParent(curIndex);
        while (array.get(curIndex).compareTo(array.get(parIndex)) > 0) {
            array.swap(curIndex, parIndex);

            int tmp = parIndex;
            parIndex = getParent(parIndex);
            curIndex = tmp;
        }
    }


//    // 向堆中添加元素
//    public void add(E e){
//        data.addLast(e);
//        siftUp(data.getSize() - 1);
//    }
//
//    private void siftUp(int k){
//
//        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0 ){
//            data.swap(k, parent(k));
//            k = parent(k);
//        }
//    }

    public E findMax() {
        return array.getFrist();
    }


    // 删除最大元素
    public E extractMax() {
        // 获取最大的元素
        E res = array.getFrist();

        // 首尾元素交换，并删除最后一个元素
        array.swap(0, array.getSize() - 1);
        array.removeLast();

        siftDown(0);

        return res;
    }

    // 从 索引 index 处开始下沉操作
    private void siftDown(int index) {

        // 左孩子索引，在数组索引范围内，开始循环操作 (进入循环表示一定存在左孩子)
        while (getLeftChild(index) < array.getSize()) {

            // 默认左孩子为最大值索引
            int m = getLeftChild(index);

            // 为了找出左孩子、右孩子中的最大值（对应的索引）
            // 右孩子索引没有越界，存在右孩子
            if (m + 1 < array.getSize()) {
                // 右孩子值比左孩子值大，那么最大值索引为右孩子（一开始初始化为左孩子）
                if (array.get(m + 1).compareTo(array.get(m)) > 0) {
                    m++;
                }
            }

            // 该节点和它的左孩子、右孩子中最大值进行比较
            if (array.get(index).compareTo(array.get(m)) >= 0) {
                // 符合二叉堆性质，不需要处理，退出循环
                break;
            }

            // 不符合二叉堆性质，需要进行交换处理
            array.swap(index, m);

            // 重置索引，为下一次循环左准备，maxIndex 已经赋值过了
            index = m;
        }
    }


    // 替换二叉堆的最大元素
    public E replace(E e) {
        E ret = findMax();
        array.set(0, e);
        siftDown(0);
        return ret;
    }


    @Override
    public String toString() {
        return array.toString();
    }
}
