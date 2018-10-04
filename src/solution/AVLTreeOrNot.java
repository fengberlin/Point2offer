package solution;

/**
 * 面试题55（二）：平衡二叉树
 * 题目：输入一棵二叉树的根结点，判断该树是不是平衡二叉树即AVL树。如果某二叉树中
 * 任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class AVLTreeOrNot {

    private class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    // 方法一
    // 注意：平衡二叉树一定是二叉搜索树，反过来就不一定了，所以要分别判断
    // 每对左右子树的高度差是否不超过1来判断是不是平衡二叉树。
    // 又因为它不断地向下遍历节点，很多节点会被遍历多遍
    public boolean avlTreeOrNot(BinaryTreeNode root) {

        if (root == null) {
            return true;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        int diff = Math.abs(leftDepth - rightDepth);
        if (diff > 1) {
            return false;
        }

        return avlTreeOrNot(root.left) && avlTreeOrNot(root.right);
    }

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

    // 方法二
    public boolean avlTreeOrNot1(BinaryTreeNode root) {

        return getDepthCore(root) != -1;
    }

    public int getDepthCore(BinaryTreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = getDepthCore(root.left);
        if (leftDepth == -1) {    // 若左边已经不是平衡二叉树了，那就直接返回，没必要搜索右边了
            return -1;
        }
        int rightDepth = getDepthCore(root.right);
        if (rightDepth == -1) {
            return -1;
        }

        // -1代表：不是平衡二叉树
        return Math.abs(leftDepth - rightDepth) > 1 ? -1 : Math.max(leftDepth, rightDepth) + 1;
    }
}
