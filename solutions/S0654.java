package solutions;

/**
 * 654. 最大二叉树
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 * <p>
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 * - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 * - 空数组，无子节点。
 * - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 * - 空数组，无子节点。
 * - 只有一个元素，所以子节点是一个值为 1 的节点。
 * - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 * - 只有一个元素，所以子节点是一个值为 0 的节点。
 * - 空数组，无子节点。
 */
public class S0654 {
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
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            int max = Integer.MIN_VALUE;
            int idx = -1;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i]>max) {
                    idx = i;
                    max = nums[i];
                }
            }
            TreeNode root = new TreeNode(max);
            root.left = helper(nums, 0, idx);
            root.right = helper(nums, idx+1,nums.length);
            return root;
        }

        private TreeNode helper(int[] nums, int l, int r) {
            if(l>=r) return null;
            int max = Integer.MIN_VALUE;
            int idx = -1;
            for(int i = l; i < r; i++) {
                if(nums[i]>max) {
                    idx = i;
                    max = nums[i];
                }
            }
            TreeNode node = new TreeNode(max);
            node.left = helper(nums, l, idx);
            node.right = helper(nums, idx+1,r);
            return node;
        }
    }
}
