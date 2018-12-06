package solution;

import java.util.LinkedList;

/**
 * 面试题32（二）：分行从上到下打印二叉树
 * 题目：从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层
 * 打印到一行。
 */
public class PrintTreeInLines {

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
        int now = 1;
        int next = 0;
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            now--;
            System.out.print(node.value);
            if (node.left != null) {
                queue.offer(node.left);
                next++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                next++;
            }
            if (now == 0) {
                System.out.println();
                now = next;
                next = 0;
            }
        }
    }
}
