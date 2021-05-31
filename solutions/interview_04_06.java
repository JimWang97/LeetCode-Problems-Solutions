package solutions;

/**
 * 面试题 04.06. 后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * <p>
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [2,1,3], p = 1
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出: 2
 */
public class interview_04_06 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (root == null) {
                return null;
            }
            // 当前节点值小于等于目标值，那么当前目标值的后继者必然在右子树
            if (p.val >= root.val) {
                return inorderSuccessor(root.right, p);
            }
            // 否则结果有可能是当前节点，或者在当前节点的左子树中
            // 那么先去左子树找一下试试，找不到的话返回当前节点即是结果
            TreeNode node = inorderSuccessor(root.left, p);
            return node == null ? root : node;
        }
    }
}
