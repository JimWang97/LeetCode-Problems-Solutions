package solutions;

/**
 * 1008. 前序遍历构造二叉搜索树
 * 返回与给定前序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
 *
 * (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node.val。此外，前序遍历首先显示节点
 * node 的值，然后遍历 node.left，接着遍历 node.right。）
 *
 * 题目保证，对于给定的测试用例，总能找到满足要求的二叉搜索树。
 *
 *
 *
 * 示例：
 *
 * 输入：[8,5,1,7,10,12]
 * 输出：[8,5,10,1,7,null,12]
 */
public class S1008a {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    class Solution {
        int ind = 0;
        int len;
        int[] preorder;
        public TreeNode bstFromPreorder(int[] preorder) {
            if(preorder.length<=0) return null;
            len = preorder.length;
            this.preorder = preorder;
            return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private TreeNode helper(int minValue, int maxValue) {
            if(ind == len) return null;
            int cur = preorder[ind];
            if(cur<minValue || cur>maxValue) return null;
            ind++;
            TreeNode root = new TreeNode(cur);
            root.left = helper(minValue, cur);
            root.right = helper(cur, maxValue);
            return root;
        }
    }
}
