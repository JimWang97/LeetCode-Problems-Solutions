package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题 04.03. 特定深度节点链表
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[1,2,3,4,5,null,7,8]
 * <p>
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * /
 * 8
 * <p>
 * 输出：[[1],[2,3],[4,5,7],[8]]
 */
public class interview_04_03 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode[] listOfDepth(TreeNode tree) {
            List<ListNode> ans = new ArrayList<>();
            if(tree==null) return new ListNode[]{};
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(tree);
            while(!q.isEmpty()) {
                int sz = q.size();
                ListNode last = null;
                for(int i = 0; i < sz; i++) {
                    TreeNode node = q.poll();
                    ListNode tmp = new ListNode(node.val);
                    if(last!=null) {
                        last.next=tmp;
                    } else {
                        ans.add(tmp);
                    }
                    last = tmp;
                    if(node.left!=null) q.offer(node.left);
                    if(node.right!=null) q.offer(node.right);
                }
            }
            return ans.toArray(new ListNode[ans.size()]);
        }
    }
}
