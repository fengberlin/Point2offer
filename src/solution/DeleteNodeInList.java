package solution;

/**
 * Problem 18-1：在O(1)时间内删除链表节点
 * 在这里要假设节点存在才能在O(1)时间内删除链表节点，
 * 不然的话要遍历节点才能判断出来。对于删除的是尾节点，
 * 需要丛头开始遍历，因为它没有下一个节点。对于其他情况，
 * 我们都可以用下一个节点的数据覆盖要删除的节点的数据，
 * 然后再删除该节点的下一个节点。
 */
public class DeleteNodeInList {

    private static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void deleteNode(ListNode head, ListNode node) {

        if (head == null || node == null) {
            return;
        }

        if (node.next != null) {
            node.value = node.next.value;
            node.next = node.next.next;
            return;
        } else if (head == node){
            head = null;
            node = null;
            return;
        } else {
            ListNode p = head;
            while (p.next != node) {
                p = p.next;
            }
            p.next = null;
            node = null;
            return;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = node1;

        ListNode p = head;
        while (p != null) {
            System.out.print(p.value + " ");
            p = p.next;
        }

        System.out.println();

        deleteNode(head, node1);

        p = head;
        while (p != null) {
            System.out.print(p.value + " ");
            p = p.next;
        }
    }
}
