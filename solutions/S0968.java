package solutions;

/**
 * 968. 监控二叉树
给定一个二叉树，我们在树的节点上安装摄像头。

节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。

计算监控树的所有节点所需的最小摄像头数量。

 

示例 1：



输入：[0,0,null,0,0]
输出：1
解释：如图所示，一台摄像头足以监控所有节点。

时间复杂度 O(n)
 */
public class S0968 {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int res = 0;
    public int minCameraCover(TreeNode root) {
        int last = preOrder(root);
        if(last==0) res++;
        return res;
    }

    // 0未被覆盖 1被覆盖 2安装相机
    public int preOrder(TreeNode root){
        if(root==null) return 1;
        int left = preOrder(root.left);
        int right = preOrder(root.right);

        if(left==1&&right==1) return 0;
        if(left==0||right==0){
            res++;
            return 2;
        }
        if(left==2||right==2) return 1;
        return 0;
    }
}