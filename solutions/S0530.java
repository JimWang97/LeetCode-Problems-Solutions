package solutions;

import java.util.List;
import java.util.ArrayList;

/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

时间复杂度O(n)
 */
public class S0530 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int ans = Integer.MAX_VALUE;
    List<Integer> nodeval = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        midorder(root);
        int sz = nodeval.size();
        for(int i = 1;i<sz;i++){
            int tmp = Math.abs(nodeval.get(i) - nodeval.get(i-1));
            if(tmp<ans) ans=tmp;
        }
        return ans;
    }

    public void midorder(TreeNode node){
        if(node==null) return;
        midorder(node.left);
        nodeval.add(node.val);
        midorder(node.right);
    }
}