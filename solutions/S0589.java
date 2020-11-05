package solutions;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 
 * 时间复杂度O(n)
 */

class S0589 {
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

    public List<Integer> ans = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        travel(root);
        return ans;
    }

    public void travel(Node node){
        if(node!=null){
            ans.add(node.val);
            for(Node child : node.children){
                travel(child);
            }
        }
    }
}