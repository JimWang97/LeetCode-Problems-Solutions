package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 */
public class S0139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[][] dp = new boolean[len+1][len+1];
        dp[0][0] = true;
        for(int j = 1; j <= len; j++) {
            for(int i = j-1; i>=0; i--) {
                for(int k = i; k < j; k++) {
                    if(dp[i][k] && wordDict.contains(s.substring(k,j))){
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[0][len];
    }
}
