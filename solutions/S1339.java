package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 1339. 分裂二叉树的最大乘积 给你一棵二叉树，它的根为 root 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。
 * 
 * 由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：root = [1,2,3,4,5,6] 输出：110 解释：删除红色的边，得到 2 棵子树，和分别为 11 和 10 。它们的乘积是 110
 * （11*10）
 * 
 * 时间复杂度O(n)
 */
public class S1339 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Double> ls = new ArrayList<>();
    public int maxProduct(TreeNode root) {
        if(root==null) return 0;
        double sum = travel(root);
        double bs = sum/2;
        double bn = sum;
        double m = Integer.MAX_VALUE;
        for(Double num : ls){
            if(Math.abs(bs-num)<m){
                bn = num;
                m=Math.abs(bs-num);
            }
        }
        return (int) (bn * (sum - bn) % (1e9 + 7));
    }

    public double travel(TreeNode node){
        if(node == null) return 0;
        double sum = travel(node.left)+travel(node.right) + node.val;
        ls.add(sum);
        return sum;
    }
}