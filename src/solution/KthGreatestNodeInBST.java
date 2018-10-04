package solution;

import java.util.LinkedList;

/**
 * 面试题54：二叉搜索树的第k个结点
 * 题目：给定一棵二叉搜索树，请找出其中的第k大的结点。
 */
public class KthGreatestNodeInBST {

    private class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    private int count = 0;

    // 递归法
    // 很明显这是一棵二叉搜索树，父节点的值大于左子节点而小于右子节点，通过中序遍历可以得到有序的遍历序列
    public BinaryTreeNode getKthGreatestNode(BinaryTreeNode root, int k) {

        BinaryTreeNode node = null;

        if (root != null) {
            node = getKthGreatestNode(root.left, k);
            if (node != null) {
                return node;
            }
            count++;
            if (count == k) {
                return root;
            }
            node = getKthGreatestNode(root.right, k);
            if (node != null) {
                return node;
            }
        }

        return null;
    }

    // 循环法
    public BinaryTreeNode getKthGreatestNode1(BinaryTreeNode root, int k) {

        if (root == null || k <= 0) {
            return null;
        }

        int count = 0;
        LinkedList<BinaryTreeNode> stack = new LinkedList<>();
        BinaryTreeNode pRoot = root;
        while (pRoot != null || !stack.isEmpty()) {
            while (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }

            if (!stack.isEmpty()) {
                pRoot = stack.pop();
                count++;
                if (count == k) {
                    return pRoot;
                }
                pRoot = pRoot.right;
            }
        }

        return null;
    }
}
