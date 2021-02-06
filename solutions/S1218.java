package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1218. 最长定差子序列
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 *
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 */
public class S1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int len = arr.length;
        int[] dp = new int[len];
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.fill(dp, 1);
        int ans = 0;
        for(int i = 0; i < len; i++) {
            if(map.containsKey(arr[i]-difference)) {
                dp[i] = Math.max(dp[i], 1 + map.get(arr[i]-difference));
            }
            map.put(arr[i], dp[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
