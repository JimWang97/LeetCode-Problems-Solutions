package solutions;

/**
 * 450. Delete Node in a BST
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Follow up: Can you solve it with time complexity O(height of tree)?

 

Example 1:


Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
 */
public class S0450 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(key>root.val) root.right=deleteNode(root.right, key);
        else if(key<root.val) root.left = deleteNode(root.left, key);
        else{
            if(root.left==null && root.right==null) return null;
            else if(root.right!=null){
                root.val=successor(root);
                root.right=deleteNode(root.right, root.val);
            }
            else{
                root.val=predecessor(root);
                root.left=deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    public Integer successor(TreeNode node){
        node=node.right;
        while(node.left!=null) node=node.left;
        return node.val;
    }

    public Integer predecessor(TreeNode node){
        node=node.left;
        while(node.right!=null) node=node.right;
        return node.val;
    }
}