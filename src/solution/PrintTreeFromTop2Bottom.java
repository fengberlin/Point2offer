package solution;

import java.util.LinkedList;

/**
 * 面试题32（一）：不分行从上往下打印二叉树
 * 题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
 *
 * 也就是二叉树的层序遍历
 */
public class PrintTreeFromTop2Bottom {

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

    public void print(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            System.out.println(node.value);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }
}
