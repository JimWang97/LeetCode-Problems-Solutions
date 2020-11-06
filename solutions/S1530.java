package solutions;

/**
 * 给你二叉树的根节点 root 和一个整数 distance 。

如果二叉树中两个 叶 节点之间的 最短路径长度 小于或者等于 distance ，那它们就可以构成一组 好叶子节点对 。

返回树中 好叶子节点对的数量 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-good-leaf-nodes-pairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

时间复杂度 O(distance^2 * n)
 */

 class S1530{

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

    public int ans = 0;
    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return ans;
    }

    public int[] dfs(TreeNode root, int distance){
        if(root == null) return new int[distance+1];
        int[] count = new int[distance+1];
        if(root.left==null && root.right==null){
            count[1]=1;
            return count;
        }
        int[] leftcount = dfs(root.left, distance);
        int[] rightcount = dfs(root.right, distance);
        for(int i =1;i<=distance;i++){
            for(int j = 1;j<=distance-i;j++){
                ans+=leftcount[i] * rightcount[j];
            }
        }

        for(int i = 2;i<=distance;i++){
            count[i]=leftcount[i-1]+rightcount[i-1];
        }
        return count;
    }
 }