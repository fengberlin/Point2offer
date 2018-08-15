package solution;

/**
 * 面试题24：反转链表
 * 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 */
public class ReverseLinkedList {

    private static class ListNode {
        int data;
        ListNode next;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode current = head;
        ListNode post = null;
        while (current != null) {
            post = current.next;
            current.next = prev;
            prev = current;
            current = post;
        }
        return prev;
    }

    public static ListNode reverseRecursively(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

}
