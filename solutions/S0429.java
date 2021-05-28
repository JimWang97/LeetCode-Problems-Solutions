package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N 叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 *
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 */
public class S0429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> ans = new ArrayList<>();
            if(root==null) return ans;
            Queue<Node> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()) {
                int sz = q.size();
                List<Integer> ls = new ArrayList<>();
                for(int i = 0; i < sz; i++) {
                    Node node = q.poll();
                    ls.add(node.val);
                    for(Node child : node.children) {
                        if(child!=null) q.offer(child);
                    }
                }
                ans.add(ls);
            }
            return ans;
        }
    }
}
