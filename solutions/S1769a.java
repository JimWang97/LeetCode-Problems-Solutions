package solutions;

/**
 * 1769. 移动所有球到每个盒子所需的最小操作数
 * 有 n 个盒子。给你一个长度为 n 的二进制字符串 boxes ，其中 boxes[i] 的值为 '0' 表示第 i 个盒子是 空 的，而 boxes[i] 的值为 '1' 表示盒子里有 一个 小球。
 *
 * 在一步操作中，你可以将 一个 小球从某个盒子移动到一个与之相邻的盒子中。第 i 个盒子和第 j 个盒子相邻需满足 abs(i - j) == 1 。注意，操作执行后，某些盒子中可能会存在不止一个小球。
 *
 * 返回一个长度为 n 的数组 answer ，其中 answer[i] 是将所有小球移动到第 i 个盒子所需的 最小 操作数。
 *
 * 每个 answer[i] 都需要根据盒子的 初始状态 进行计算。
 *
 *
 *
 * 示例 1：
 *
 * 输入：boxes = "110"
 * 输出：[1,1,3]
 * 解释：每个盒子对应的最小操作数如下：
 * 1) 第 1 个盒子：将一个小球从第 2 个盒子移动到第 1 个盒子，需要 1 步操作。
 * 2) 第 2 个盒子：将一个小球从第 1 个盒子移动到第 2 个盒子，需要 1 步操作。
 * 3) 第 3 个盒子：将一个小球从第 1 个盒子移动到第 3 个盒子，需要 2 步操作。将一个小球从第 2 个盒子移动到第 3 个盒子，需要 1 步操作。共计 3 步操作。
 */
public class S1769a {
    class Solution {
        public int[] minOperations(String boxes) {
            char[] chars = boxes.toCharArray();
            int left = 0, right = 0, total = 0;
            if(chars[0]=='1') left = 1;
            for(int i = 1; i < chars.length; i++) {
                if(chars[i]=='1') {
                    right++;
                    total+=i;
                }
            }
            int[] ans = new int[chars.length];
            ans[0] = total;
            for(int i = 1; i < chars.length; i++) {
                total = total - right + left;
                if(chars[i]=='1') {
                    left++;
                    right--;
                }
                ans[i] = total;
            }
            return ans;
        }
    }
}
