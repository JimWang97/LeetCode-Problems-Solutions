package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 971. 翻转二叉树以匹配先序遍历
 * 给你一棵二叉树的根节点 root ，树中有 n 个节点，每个节点都有一个不同于其他节点且处于 1 到 n 之间的值。
 * <p>
 * 另给你一个由 n 个值组成的行程序列 voyage ，表示 预期 的二叉树 先序遍历 结果。
 * <p>
 * 通过交换节点的左右子树，可以 翻转 该二叉树中的任意节点。例，翻转节点 1 的效果如下：
 * <p>
 * <p>
 * 请翻转 最少 的树中节点，使二叉树的 先序遍历 与预期的遍历行程 voyage 相匹配 。
 * <p>
 * 如果可以，则返回 翻转的 所有节点的值的列表。你可以按任何顺序返回答案。如果不能，则返回列表 [-1]。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2], voyage = [2,1]
 * 输出：[-1]
 * 解释：翻转节点无法令先序遍历匹配预期行程。
 */
public class S0971a {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        List<Integer> flipped;
        int index;
        int[] voyage;

        public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
            flipped = new ArrayList();
            index = 0;
            this.voyage = voyage;

            dfs(root);
            if (!flipped.isEmpty() && flipped.get(0) == -1) {
                flipped.clear();
                flipped.add(-1);
            }

            return flipped;
        }

        public void dfs(TreeNode node) {
            if (node != null) {
                if (node.val != voyage[index++]) {
                    flipped.clear();
                    flipped.add(-1);
                    return;
                }

                if (index < voyage.length && node.left != null &&
                        node.left.val != voyage[index]) {
                    flipped.add(node.val);
                    dfs(node.right);
                    dfs(node.left);
                } else {
                    dfs(node.left);
                    dfs(node.right);
                }
            }
        }
    }
}
