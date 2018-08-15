package solution;

/**
 * 面试题18（二）：删除链表中重复的结点
 * 题目：在一个排序的链表中，如何删除重复的结点？
 */
public class DeleteDuplicatedNode {

    private static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void deleteDuplicatedListNode(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        ListNode p = head;
        ListNode pre = null;
        while (p != null) {
            boolean needDeleted = false;
            if (p.next != null && p.value == p.next.value) {
                needDeleted = true;
            }

            if (needDeleted == false) {
                pre = p;
                p = p.next;
            } else {
                int value = p.value;
                ListNode deleted = p;
                while (deleted != null && deleted.value == value) {
                    p.next = deleted.next;
                    deleted = p.next;
                }
                if (pre == null) {
                    head = p.next;
                } else {
                    pre.next = p.next;
                }
                p = p.next;
            }
        }
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(1);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode head = node1;

        ListNode p = head;
        while (p != null) {
            System.out.print(p.value + " ");
            p = p.next;
        }

        System.out.println();

        deleteDuplicatedListNode(head);

        p = head;
        while (p != null) {
            System.out.print(p.value + " ");
            p = p.next;
        }
    }
}
