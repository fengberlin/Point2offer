package solution;

/**
 * 面试题25：合并两个排序的链表
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按
 * 照递增排序的。
 */
public class MergeSortedList {

    private static class ListNode {
        int data;
        ListNode next;
    }

    // 非递归
    public static ListNode mergeTwoLists(ListNode list0, ListNode list1) {
        if (list0 == null) {
            return list1;
        }
        if (list1 == null) {
            return list0;
        }
        ListNode p0 = list0;
        ListNode p1 = list1;
        ListNode leader = null;
        ListNode tail = null;
        while (p0 != null && p1 != null) {
            if (p0.data <= p1.data) {
                if (leader == null) {
                    leader = p0;
                    tail = p0;
                } else {
                    tail.next = p0;
                    tail = p0;
                }
                p0 = p0.next;
            } else {
                if (leader == null) {
                    leader = p1;
                    tail = p1;
                } else {
                    tail.next = p1;
                    tail = p1;
                }
                p1 = p1.next;
            }
        }
        if (p0 != null || p1 != null) {
            if (p0 != null) {
                tail.next = p0;
            } else {
                tail.next = p1;
            }
        }
        return leader;
    }

    // 递归
    public static ListNode mergeTwoListsRecursively(ListNode list0, ListNode list1) {
        if (list0 == null) {
            return list1;
        }
        if (list1 == null) {
            return list0;
        }
        ListNode leader = null;
        if (list0.data <= list1.data) {
            leader = list0;
            leader.next = mergeTwoListsRecursively(list0.next, list1);
        } else {
            leader = list1;
            leader.next = mergeTwoListsRecursively(list0, list1.next);
        }
        return leader;
    }

}
