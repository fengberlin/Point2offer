package solution;

/**
 * 面试题52：两个链表的第一个公共结点
 * 题目：输入两个链表，找出它们的第一个公共结点。
 */
public class FirstCommonNodeInLists {

    private class ListNode {
        int value;
        ListNode next;
    }

    // 先计算两个链表的长度之差step，然后在较长的链表走step步，
    // 然后再在两个链表同时出发遍历两个链表，如果遍历到相同的节点，
    // 就返回那个节点，否则返回null。
    public ListNode getFirstCommonNode(ListNode head0, ListNode head1) {

        if (head0 == null || head1 == null) {
            return null;
        }

        int length0 = getListLength(head0);
        int length1 = getListLength(head1);
        int step = (length0 > length1) ? (length0 - length1) : (length1 - length0);
        ListNode pHead0 = head0;
        ListNode pHead1 = head1;
        if (length0 > length1) {
            while (step > 0) {
                pHead0 = pHead0.next;
                step--;
            }
        } else if (length0 < length1) {
            while (step > 0) {
                pHead1 = pHead1.next;
                step--;
            }
        }

        while (pHead0 != pHead1) {
            pHead0 = pHead0.next;
            pHead1 = pHead1.next;
        }

        return pHead0;
    }

    public int getListLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        int length = 0;
        ListNode pHead = head;
        while (pHead != null) {
            pHead = pHead.next;
            length++;
        }

        return length;
    }
}
