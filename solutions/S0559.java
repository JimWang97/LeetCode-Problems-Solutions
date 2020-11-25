package solutions;

import java.util.List;

/**
 * 559. Maximum Depth of N-ary Tree Given a n-ary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: root = [1,null,3,2,4,null,5,6] Output: 3
 */
public class S0559 {
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

    public int maxDepth(Node root) {
        if(root==null) return 0;
        else if(root.children.isEmpty()) return 1;
        else{
            int max = -1;
            for(Node n : root.children){
                max = Math.max(maxDepth(n), max);
            }
            return max + 1;
        }
    }
}