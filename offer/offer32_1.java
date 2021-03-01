package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
 * [9,20],
 * [15,7]
 * ]
 */
public class offer32_1 {
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
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) {
            return ans;
        }
        q.add(root);
        while(!q.isEmpty()) {
            if(q.peek()!=null) {
                int num = q.size();
                List<Integer> a = new ArrayList<>();
                for (int i = 0; i < num; i++) {
                    if (q.peek() != null) {
                        TreeNode tmp = q.poll();
                        a.add(tmp.val);
                        q.add(tmp.left);
                        q.add(tmp.right);
                    } else {
                        q.poll();
                    }
                }
                ans.add(a);
            } else {
                q.poll();
            }
        }
        return ans;
    }
}
