package solutions;

/**
 * 1849. 将字符串拆分为递减的连续值
 * 给你一个仅由数字组成的字符串 s 。
 *
 * 请你判断能否将 s 拆分成两个或者多个 非空子字符串 ，使子字符串的 数值 按 降序 排列，且每两个 相邻子字符串 的数值之 差 等于 1 。
 *
 * 例如，字符串 s = "0090089" 可以拆分成 ["0090", "089"] ，数值为 [90,89] 。这些数值满足按降序排列，且相邻值相差 1 ，这种拆分方法可行。
 * 另一个例子中，字符串 s = "001" 可以拆分成 ["0", "01"]、["00", "1"] 或 ["0", "0", "1"] 。然而，所有这些拆分方法都不可行，因为对应数值分别是 [0,1]、[0,1] 和 [0,
 * 0,1] ，都不满足按降序排列的要求。
 * 如果可以按要求拆分 s ，返回 true ；否则，返回 false 。
 *
 * 子字符串 是字符串中的一个连续字符序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "1234"
 * 输出：false
 * 解释：不存在拆分 s 的可行方法。
 */
public class S1849 {
    class Solution {
        char[] nums;
        int n;
        public boolean splitString(String s) {
            n = s.length();
            nums = s.toCharArray();
            return dfs(0,0,0);
        }

        private boolean dfs(int index, long prev, int count) {
            if(index==n) return count>1;
            long cur = 0;
            for(int i = index; i < n; i++) {
                cur = 10*cur+nums[i]-'0';
                if(count==0||cur==prev-1) {
                    if(dfs(i+1, cur, count+1)) return true;
                }
            }
            return false;
        }
    }
}
