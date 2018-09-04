package solution;

/**
 * 面试题36：二叉搜索树与双向链表
 * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求
 * 不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class BinaryTree2List {

    private static class BinaryTreeNode {
        private int value;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    BinaryTreeNode head = null;
    BinaryTreeNode pHead = null;


    public BinaryTreeNode convert(BinaryTreeNode root) {

        if (root == null) {
            return null;
        }

        // 核心思想是中序遍历
        convert(root.left);

        if (pHead == null) {
            head = pHead = root;
        } else {
            pHead.right = root;
            root.left = pHead;
            pHead = root;
        }

        convert(root.right);

        return head;
    }

}
