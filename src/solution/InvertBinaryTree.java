package solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * // 面试题27：二叉树的镜像(也即反转二叉树)
 * // 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class InvertBinaryTree {

    private static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    // 递归版本
    // 其实是分别交换两棵子树
    public static BinaryTreeNode invertBinaryTreeRecursively(BinaryTreeNode root) {

        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        BinaryTreeNode node = invertBinaryTreeRecursively(root.left);
        root.left = invertBinaryTreeRecursively(root.right);
        root.right = node;
        return root;
    }

    // 非递归版本
    public static BinaryTreeNode invertBinaryTree(BinaryTreeNode root) {

        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        BinaryTreeNode node;
        while (queue.size() > 0) {
            node = queue.poll();
            BinaryTreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}
