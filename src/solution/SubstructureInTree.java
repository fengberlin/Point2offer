package solution;

/**
 * 面试题26：树的子结构
 * 题目：输入两棵二叉树A和B，判断B是不是A的子结构。（约定空树不是任意一个树的子结构）
 */
public class SubstructureInTree {

    private static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    // 第一步：判断根节点是否相等
    public static boolean isSubtree(BinaryTreeNode root0, BinaryTreeNode root1) {

//        boolean result = false;
//        if (root0 != null && root1 != null) {
//            if (root0.value == root1.value) {
//                result = isSubtreeCore(root0, root1);
//            }
//
//            // 如果根节点不相等，则分别遍历root0的左子树和右子树的根节点与root1的根节点比较，
//            // 实际上也就是找到root0中与root1的根节点相等的节点，找不到则返回false，找到则
//            // 调用另一个方法判断。
//            if (result == false) {
//                result = isSubtree(root0.left, root1);
//            }
//            if (result == false) {
//                result = isSubtree(root0.right, root1);
//            }
//        }
//        return result;

        if (root0 != null && root1 != null) {
            return isSubtreeCore(root0, root1) || isSubtree(root0.left, root1) || isSubtree(root0.right, root1);
        }
        return false;
    }

    // 第二步：当根节点相等时，分别判断两棵树的左子树和右子树的值是否相等
    public static boolean isSubtreeCore(BinaryTreeNode root0, BinaryTreeNode root1) {
        // 这里判断的是root1是否已经遍历结束
        // 因为isSubtree是入口函数，如果一开始进入到
        // isSubtreeCore函数，就表明两棵树都不是空树
        if (root1 == null) {
            return true;
        }

        if (root0 == null) {
            return false;
        }

        if (root0.value != root1.value) {
            return false;
        }

        return isSubtreeCore(root0.left, root1.left) && isSubtreeCore(root0.right, root1.right);
    }

}
