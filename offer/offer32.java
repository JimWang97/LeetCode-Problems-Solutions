package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
 * 返回：
 * <p>
 * [3,9,20,15,7]
 */
public class offer32 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ls = new ArrayList<>();
        if(root==null) {
            return new int[]{};
        }
        q.add(root);
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i++) {
                if(q.peek()!=null) {
                    ls.add(q.peek().val);
                    TreeNode tmp = q.poll();
                    q.add(tmp.left);
                    q.add(tmp.right);
                } else {
                    q.poll();
                }
            }
        }
        int[] res = new int[ls.size()];
        for(int i = 0; i < ls.size(); i++)
            res[i] = ls.get(i);
        return res;
    }
}
