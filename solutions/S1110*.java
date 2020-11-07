package solutions;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。

如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。

返回森林中的每棵树。你可以按任意顺序组织答案。

 

示例：



输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
输出：[[1,2,null,4],[6],[7]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/delete-nodes-and-return-forest
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class S1110 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Set<Integer> toDelete;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        toDelete = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        List<TreeNode> ans = new ArrayList<>();
        hepler(root, ans, false);
        return ans;
    }

    public boolean hepler(TreeNode root, List<TreeNode> ans, boolean parentExists){
        boolean del =false;
        if( root == null) return del;
        del = toDelete.contains(root.val);
        if( hepler(root.left, ans, !del)){
            root.left = null;
        }
        if( hepler(root.right, ans, !del)){
            root.right = null;
        }
        if(!del && !parentExists){
            ans.add(root);
        }
        return del;
    }
}