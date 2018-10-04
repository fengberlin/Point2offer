package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题68：树中两个结点的最低公共祖先
 * 题目：输入两个树结点，求它们的最低公共祖先。
 */
public class CommonAncestor {

    private class TreeNode {
        int value;
        List<TreeNode> children = new ArrayList<>();    // 存储一个节点的所有子节点
        public TreeNode(int value) {
            this.value = value;
        }
    }

    public TreeNode getLastCommonAncestor(TreeNode root, TreeNode p1, TreeNode p2) {

        //path1和path2分别存储根节点到p1和p2的路径（不包括p1和p2）
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        List<TreeNode> tempList = new ArrayList<>();

        getNodePath(root, p1, tempList, path1);
        getNodePath(root, p2, tempList, path2);
        // 如果路径不存在，返回空
        if (path1.isEmpty() || path2.isEmpty()) {
            return null;
        }

        return getLastCommonAncestorCore(path1, path2);
    }

    // 获取根节点到目标节点的路径
    public void getNodePath(TreeNode root, TreeNode target, List<TreeNode> tempList, List<TreeNode> path) {

        if (root == null || target == null) {
            return;
        }

        tempList.add(root);
        // 递归处理每个子节点
        List<TreeNode> children = root.children;
        for (TreeNode node : children) {
            if (node == target) {
                path.addAll(tempList);
                break;
            }
            getNodePath(node, target, tempList, path);
        }

        tempList.remove(tempList.size() - 1);
    }

    // 将问题转化为求链表最后一个共同节点
    public TreeNode getLastCommonAncestorCore(List<TreeNode> path1, List<TreeNode> path2) {

        TreeNode tempNode = null;
        for (int i = 0; i < path1.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
            tempNode = path1.get(i);
        }

        return tempNode;
    }
}
