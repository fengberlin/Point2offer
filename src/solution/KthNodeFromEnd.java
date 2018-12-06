package solution;

/**
 * 面试题22：链表中倒数第k个结点
 * 题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，
 * 从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是
 * 值为4的结点。
 */
public class KthNodeFromEnd {

    private class ListNode {
        int data;
        ListNode next;
    }

    // 解法：定义两个指针，一个指针先走k-1步，然后把另一个指针指向头节点，
    // 然后处于k-1步位置的指针向前移动，另一个指针也向前移动，直到哪个快
    // 指针到达最后一个节点，那么另一个指针所指的节点就是倒数第k个节点。
    // 假设有n个节点，那么倒数第k个节点就是从头开始数起的第(n-k)+1个节点，
    // 开始时指针位于第一个节点，先走k-1步(走了k个节点)，那么这个指针还需要
    // 走n-k个节点才能到达链表最后一个节点，那么此时将另一个指针置于头节点，
    // 那么当之前的指针走到链表尾部时，这个指针就走了n-k-1步(第一个节点不需要
    // 一步，即它到达第二个节点就走了一步)，刚好就到了倒数第k个节点的位置。
    public ListNode findNode(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = null;

        for (int i = 0; i < k - 1; i++) {
            if (p1.next != null) {
                p1 = p1.next;
            } else {
                return null;
            }
        }

        p2 = head;
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }
}
