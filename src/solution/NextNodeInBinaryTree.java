package solution;

/**
 * Problem 8：二叉树的下一个结点。
 * 题目描述：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 * 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 */
public class NextNodeInBinaryTree {

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode(int value) {
            this.value = value;
            left = null;
            right = null;
            parent = null;
        }
    }

    public TreeNode getNextNodeInTreeInInOrder(TreeNode node) {

        if (node == null) {
            return null;
        }

        TreeNode next = null;
        if (node.right != null) {
            // 如果一个节点有右子树（或者说右节点），那么它的下一个节点就是它的右子树中的最左子节点。
            // 也就是说，从这个节点的右子节点出发一直沿着指向左子节点的指针，就可以找到这个节点的下一个节点。
            TreeNode pRight = node.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            next = pRight;
        } else if (node.parent != null) {
            // 如果一个节点没有右子树（或者说右节点），并且它是它的父节点的左子节点，
            // 那么它的下一个节点就是它的父节点。
            TreeNode current = node;
            TreeNode pParent = node.parent;
            // 如果它是它父节点的右子节点，我们可以沿着它指向父节点的指针一直向上遍历，
            // 直到找到那么一个节点，该节点是它父节点的左子节点。
            while (pParent != null && current == pParent.right) {
                current = pParent;
                pParent = pParent.parent;
            }
            next = pParent;
        }

        return next;
    }
}
