package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 1305. 两棵二叉搜索树中的所有元素
 * 给你 root1 和 root2 这两棵二叉搜索树。
 * <p>
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 */
public class S1305 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        List<Integer> ls1 = new ArrayList<>();
        List<Integer> ls2 = new ArrayList<>();
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            dfs(root1, ls1);
            dfs(root2, ls2);
            int i1 = 0, i2 = 0;
            List<Integer> ans = new ArrayList<>();
            while(i1<ls1.size() && i2 < ls2.size()) {
                if(ls1.get(i1)<ls2.get(i2)) {
                    ans.add(ls1.get(i1));
                    i1++;
                } else {
                    ans.add(ls2.get(i2));
                    i2++;
                }
            }
            while(i1<ls1.size()) {
                ans.add(ls1.get(i1));
                i1++;
            }
            while(i2<ls2.size()) {
                ans.add(ls2.get(i2));
                i2++;
            }
            return ans;
        }

        private void dfs(TreeNode root, List<Integer> ls) {
            if(root==null) return;
            dfs(root.left, ls);
            ls.add(root.val);
            dfs(root.right, ls);
        }
    }
}
