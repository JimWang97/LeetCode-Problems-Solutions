package solutions;

import java.util.Arrays;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-binary-search-trees
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 设n个节点的二叉搜索树有G(n)个，当根节点为i时，二叉搜索树的个数为f(i)。 
 * f(i)=G(i-1)*G(n-i); 左子树的个数乘以右字数的个数
 * G(n)=G(0)*G(n-1)+G(1)*G(n-2)...
 * 
 * 空间复杂度O(n)
 * 时间复杂度O(n^2)
 */
public class S0096 {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}