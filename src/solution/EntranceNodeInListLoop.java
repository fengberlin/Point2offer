package solution;

/**
 * 面试题23：链表中环的入口结点
 * 题目：一个链表中包含环，如何找出环的入口结点？
 */
public class EntranceNodeInListLoop {

    private class ListNode {
        int data;
        ListNode next;
    }

    // 思路就是：先判断此链表是否存在环（用一个快指针，一个慢指针），
    // 若存在环，则记录下相遇点，然后把快指针重新置于头节点，两个指针
    // 以相同速度继续前进，那么之后两个指针相遇的点就刚刚好是环的入口点
    // 具体证明在：https://www.nowcoder.com/questionTerminal/253d2c59ec3e4bc68da16833f79a38e4
    public ListNode findEntrance(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast  = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                if (fast == slow) {
                    return fast;
                }
            }
        }
        return null;
    }

}
