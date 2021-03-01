package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * <p>
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class offer32_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int x = 0;
        while(!q.isEmpty()) {
            if(q.peek()!=null) {
                List<Integer> l = new ArrayList<>();
                int sz = q.size();
                for(int i = 0; i < sz; i++) {
                    if(q.peek()!=null) {
                        TreeNode tmp = q.poll();
                        if(x%2==0) {
                            l.add(tmp.val);
                        } else {
                            l.add(0, tmp.val);
                        }
                        q.offer(tmp.left);
                        q.offer(tmp.right);
                    } else {
                        q.poll();
                    }
                }
                ans.add(l);
                x++;
            }else {
                q.poll();
            }
        }
        return ans;
    }
}
