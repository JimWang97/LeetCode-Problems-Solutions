package solutions;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其后序遍历: [5,6,3,2,4,1].
 * 
 * 
 * 
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * 
 * 时间复杂度O(n)
 */
public class S0590 {
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
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        lrd(root, ans);
        return ans;
    }
    public void lrd(Node root, List<Integer> ans){
        if(root==null) return;
        if(root.children!=null){
            for(Node node : root.children){
                lrd(node, ans);
            }
        }
        ans.add(root.val);
    }
}