package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 
 * 注意: 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 中序遍历 inorder = [9,3,15,20,7] 后序遍历 postorder = [9,15,7,20,3] 返回如下的二叉树：
 * 
 * 3 / \ 9 20 / \ 15 7
 */
public class S0106 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int currentNum;
    int[] inorder, postorder;
    Map<Integer,Integer> idx_map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        currentNum = postorder.length - 1;
        int idx = 0;
        for(Integer val : inorder){
            idx_map.put(val, idx++);
        }
        return helper(0, currentNum);
    }

    public TreeNode helper(int left, int right){
        if(left > right) return null;
        int root_val = postorder[currentNum];
        TreeNode root = new TreeNode(root_val);

        int index = idx_map.get(root_val);
        currentNum--;
        root.right = helper(index+1, right);
        root.left = helper(left, index-1);
        return root;
    }
}