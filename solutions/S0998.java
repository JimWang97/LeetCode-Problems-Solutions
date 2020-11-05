package solutions;

/**
 * 最大树定义：一个树，其中每个节点的值都大于其子树中的任何其他值。

给出最大树的根节点 root。

就像之前的问题那样，给定的树是从表 A（root = Construct(A)）递归地使用下述 Construct(A) 例程构造的：

如果 A 为空，返回 null
否则，令 A[i] 作为 A 的最大元素。创建一个值为 A[i] 的根节点 root
root 的左子树将被构建为 Construct([A[0], A[1], ..., A[i-1]])
root 的右子树将被构建为 Construct([A[i+1], A[i+2], ..., A[A.length - 1]])
返回 root
请注意，我们没有直接给定 A，只有一个根节点 root = Construct(A).

假设 B 是 A 的副本，并附加值 val。保证 B 中的值是不同的。

返回 Construct(B)。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-binary-tree-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

时间复杂度O(n)
 */
class S0998 {
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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null) return null;
        if(val > root.val){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        solv(root, val);
        return root;
    }

    public void solv(TreeNode node, int val){
        if(node.right == null){
            TreeNode n_node = new TreeNode(val);
            node.right = n_node;
            return;
        }
        if(val > node.right.val){
            TreeNode n_node = new TreeNode(val);
            n_node.left = node.right;
            node.right = n_node;
            return;
        } else {
            solv(node.right, val);
        }
    }
}