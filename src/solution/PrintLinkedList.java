package solution;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Author：Berlin
 * Problem 6：从尾到头打印链表。
 * 题目描述：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 */
public class PrintLinkedList {

    private static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }


    // 方法1：时间复杂度：O(n)，空间复杂度：O(n)。
    // 这道题我们不去改变链表本身的结构（如果可以改变链表本身的结构，就可以翻转链表然后再遍历），
    // 然后题目是从头到尾去遍历每个结点的值，我们不可能从头到尾每次去取一个结点的值，所以我们用到一个栈，
    // 从头到尾每次读取一个结点的值，然后把结点的值存储到一个栈里面，最后再遍历这个栈就可以了。
    // 因为用了标准库中的LinkedList数据结构，所以无法使用递归来做。
    public static void inReversedOrder(LinkedList<Integer> list) {

        if (list == null || list.isEmpty()) {
            return;
        }

        LinkedList<Integer> stack = new LinkedList<>();

        Iterator<Integer> iter = list.iterator();

        while (iter.hasNext()) {
            stack.push(iter.next());
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        System.out.println();
    }

    // 方法2：时间复杂度：O(n)，空间复杂度：O(n)。
    // 这里我们不使用自带的LinkedList，而是我们自己构造一个结点。
    public static void inReversedOrderRecursively(ListNode head) {

        ListNode p = head;

        if (p != null) {
            inReversedOrderRecursively(p.next);
            System.out.print(p.value + " ");    // 这里也可以用一个额外的ArrayList来存储元素，最后ArrayList存储的就是逆序的链表元素。
        }

    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        inReversedOrder(list);
    }
}
