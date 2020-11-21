package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 889. Construct Binary Tree from Preorder and Postorder Traversal Return any
 * binary tree that matches the given preorder and postorder traversals.
 * 
 * Values in the traversals pre and post are distinct positive integers.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1] Output: [1,2,3,4,5,6,7]
 * 
 * 时间复杂度 O(n)
 */
public class S0889 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int N = pre.length;
        if (N==0) return null;
        TreeNode root = new TreeNode(pre[0]);
        if(N==1) return root;

        int L = 0;
        for(int i = 0;i<N;i++){
            if(post[i]==pre[1])
                L = i + 1;
        }
        
        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L+1), Arrays.copyOfRange(post, 0, L));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, L+1,N), Arrays.copyOfRange(post, L, N-1));

        return root;
    }
}