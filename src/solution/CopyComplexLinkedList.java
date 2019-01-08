package solution;

import java.util.HashMap;

/**
 * 面试题35：复杂链表的复制
 * 题目：请实现函数ComplexListNode* Clone(ComplexListNode* pHead)，复
 * 制一个复杂链表。在复杂链表中，每个结点除了有一个m_pNext指针指向下一个
 * 结点外，还有一个m_pSibling 指向链表中的任意结点或者nullptr。
 */
public class CopyComplexLinkedList {

    private static class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode sibling;

        public ComplexListNode(int value) {
            this.value = value;
            next = null;
            sibling = null;
        }
    }

    // 方法一
    public ComplexListNode clone(ComplexListNode head) {

        if (head == null) {
            return null;
        }

        // 第一步：复制每个原始的节点并把它链接在每个节点的后面
        ComplexListNode pHead = head;
        while (pHead != null) {
            ComplexListNode node = new ComplexListNode(pHead.value);
            node.next = pHead.next;
            pHead.next = node;
            pHead = node.next;
        }

        // 第二步：使复制的节点的sibling指向原始节点指向的sibling节点的下一个节点
        pHead = head;
        while (pHead != null) {
            if (pHead.sibling != null) {
                pHead.next.sibling = pHead.sibling.next;
            }
            if (pHead.next != null) {
                pHead = pHead.next.next;
            }
        }

        // 第二步：拆分成两个链表
        pHead = head;
        ComplexListNode cloneHead = null;
        ComplexListNode pNode = null;
        cloneHead = pNode = pHead.next;
        while (pHead != null) {
            pHead.next = pNode.next;
            if (pHead.next != null) {
                pNode.next = pHead.next.next;
            }
            pHead = pHead.next;
            pNode = pNode.next;
        }

        return cloneHead;
    }

    // 方法2 使用散列表
    public ComplexListNode anotherClone(ComplexListNode head) {

        if (head == null) {
            return null;
        }

        // 存储复制节点与原始节点的关联关系
        HashMap<ComplexListNode, ComplexListNode> map = new HashMap<>();
        ComplexListNode pHead = head;
        ComplexListNode newHead = new ComplexListNode(head.value);
        ComplexListNode pNewHead = newHead;
        map.put(pHead, pNewHead);
        while (pHead.next != null) {
            pNewHead.next = new ComplexListNode(pHead.next.value);
            pHead = pHead.next;
            pNewHead = pNewHead.next;
            map.put(pHead, pNewHead);
        }

        pHead = head;
        pNewHead = newHead;
        while (pNewHead != null) {
            // 找到pHead.sibling在map中关联的那个节点即是对应的复制节点的sibling
            pNewHead.sibling = map.get(pHead.sibling);
            pHead = pHead.next;
            pNewHead = pNewHead.next;
        }

        return newHead;
    }
}
