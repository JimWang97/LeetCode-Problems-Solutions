package solutions;


import java.util.TreeSet;

/**
 * 988. 从叶结点开始的最小字符串
 * 给定一颗根结点为 root 的二叉树，树中的每一个结点都有一个从 0 到 25 的值，分别代表字母 'a' 到 'z'：值 0 代表 'a'，值 1 代表 'b'，依此类推。
 * <p>
 * 找出按字典序最小的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
 * <p>
 * （小贴士：字符串中任何较短的前缀在字典序上都是较小的：例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。）
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[0,1,2,3,4,3,4]
 * 输出："dba"
 */
public class S0988 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        String ans = "~";
        public String smallestFromLeaf(TreeNode root) {
            if(root==null) return new String();
            helper(root, new StringBuilder());
            return ans;
        }

        private void helper(TreeNode root, StringBuilder sb) {
            if(root==null) {
                return;
            }
            sb.append((char)('a'+root.val));
            if(root.left==null && root.right==null) {
                sb.reverse();
                String S = sb.toString();
                sb.reverse();
                if (S.compareTo(ans) < 0) {
                    ans = S;
                }
            }
            helper(root.left, sb);
            helper(root.right, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
