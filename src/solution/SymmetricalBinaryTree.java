package solution;

/**
 * 面试题28：对称的二叉树
 * 题目：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和
 * 它的镜像一样，那么它是对称的。
 */
public class SymmetricalBinaryTree {

    private static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static boolean isSymmetrical(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetricalCore(root.left, root.right);
    }

    // 解法是分别判断两对节点：一个父节点的左孩子节点和另一个父节点的右孩子节点的值是否相等（包含判断节点是否为null），
    // 和一个父节点的右孩子节点和另一个父节点的左孩子节点的值是否相等（包含判断节点是否为null）
    // 如果这棵树为null，则直接返回true
    public static boolean isSymmetricalCore(BinaryTreeNode leftRoot, BinaryTreeNode rightRoot) {
        if (leftRoot == null && rightRoot == null) {
            return true;
        }

        if (leftRoot == null || rightRoot == null) {
            return false;
        }

        if (leftRoot.value != rightRoot.value) {
            return false;
        }

        return isSymmetricalCore(leftRoot.left, rightRoot.right)
                && isSymmetricalCore(leftRoot.right, rightRoot.left);
    }
}
