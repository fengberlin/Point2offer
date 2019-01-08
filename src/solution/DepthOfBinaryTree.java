package solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题55（一）：二叉树的深度
 * 题目：输入一棵二叉树的根结点，求该树的深度。从根结点到叶结点依次经过的
 * 结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class DepthOfBinaryTree {

    private class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    // 递归地分别计算两棵子树的高度，最后高度最大者加1就是整棵树的高度
    public int getDepth(BinaryTreeNode root) {

        int leftDepth;
        int rightDepth;
        if (root != null) {
            leftDepth = getDepth(root.left);
            rightDepth = getDepth(root.right);
            return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
        }

        return 0;
    }

    // 循环，利用层序遍历
    public int getDepth1(BinaryTreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while (size > 0) {
                BinaryTreeNode node = queue.poll();
                size--;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return depth;
    }

    // 打印最长路径的所有节点
    public void printLongest(BinaryTreeNode root) {

        if (root != null) {
            System.out.println(root.value);
            if (getDepth(root.left) > getDepth(root.right)) {
                printLongest(root.left);
            } else {
                printLongest(root.right);
            }
        }
    }
}
