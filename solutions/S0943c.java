package solutions;

import java.util.HashMap;

/**
 * 943. 最短超级串
 * 给定一个字符串数组 words，找到以 words 中每个字符串作为子字符串的最短字符串。如果有多个有效最短字符串满足题目条件，返回其中 任意一个 即可。
 *
 * 我们可以假设 words 中没有字符串是 words 中另一个字符串的子字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：words = ["alex","loves","leetcode"]
 * 输出："alexlovesleetcode"
 * 解释："alex"，"loves"，"leetcode" 的所有排列都会被接受。
 */
public class S0943c {
    public String shortestSuperstring(String[] words) {
        HashMap<String, String[]> map = new HashMap<>();
        int n = words.length;
        String[] dp = new String[1<<n];
        for(int i = 0; i < n; i++) {
            dp[1<<i] = words[i];
        }
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < n; j++) {
                // 说明这一位已经合并过了。 也就是说01111 & 00001
                // 状态压缩就是用位来表示状态 01111 表示后四个字符串已经合并过
                if((i&(1<<j))!=0) {
                    continue;
                }
                // 01110 | 00001 = 01111
                int next = i | (1 << j);
                // 获取当前以合并的 与 新加入的公共部分
                String[] e = getCommonString(map, dp[i], words[j]);
                if(dp[next] == null || e[1].length()<dp[next].length()) {
                    dp[next] = e[1];
                }
            }
        }
        return dp[dp.length-1];
    }

    private String[] getCommonString(HashMap<String, String[]> map, String a, String b) {
        String key = a + "," + b;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        String[] common = check(a,b);
        String[] common2 = check(b,a);
        // 公共部分越长越好
        if(common2[0].length()>common[0].length()) {
            common = common2;
        }
        map.put(key, common);
        return common;
    }

    //[0]是a的前缀和b的后缀的公共部分
    //[1]是合并之后的字符串b+a的非重合部分
    private String[] check(String a, String b) {
        int res = 0;
        if(a.contains(b)) {
            return new String[]{b,a};
        }
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        int n = arr2.length;
        for(int i = n-1; i>=0;i--) {
            int l = n - i;
            if(l > arr1.length) break;
            boolean match = true;
            for(int j = 0; j< l;j++) {
                if(arr1[j] != arr2[i+j]) {
                    match = false;
                    break;
                }
            }
            if(match) {
                res = l;
            }
        }
        if(res==0) {
            return new String[]{"", a+b};
        }
        String t = b + a.substring(res);
        return new String[]{a.substring(0,res), t};
    }
}
