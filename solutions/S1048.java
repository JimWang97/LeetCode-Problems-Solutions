package solutions;

import java.util.Arrays;
import java.util.Set;

/**
 * 1048. 最长字符串链
 * 给出一个单词列表，其中每个单词都由小写英文字母组成。
 *
 * 如果我们可以在 word1 的任何地方添加一个字母使其变成 word2，那么我们认为 word1 是 word2 的前身。例如，"abc" 是 "abac" 的前身。
 *
 * 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word_1 是 word_2 的前身，word_2 是 word_3 的前身，依此类推。
 *
 * 从给定单词列表 words 中选择单词组成词链，返回词链的最长可能长度。
 *
 *
 * 示例：
 *
 * 输入：["a","b","ba","bca","bda","bdca"]
 * 输出：4
 * 解释：最长单词链之一为 "a","ba","bda","bdca"。
 */
public class S1048 {
    public int longestStrChain(String[] words) {
        if(words.length == 1) {
            return 1;
        }
        words = arraySort(words);

        int[] dp = new int[words.length];
        int ans=0;
        for(int i=1;i<words.length;i++)
            for(int j=0;j<i;j++)
                if(contains(words[j],words[i])){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    ans=Math.max(ans,dp[i]);
                }
        return 1+ans;
    }

    public String[] arraySort(String[] input){
        for (int i=0;i<input.length-1;i++){
            for (int j=0;j<input.length-i-1;j++) {
                if(input[j].length()-input[j+1].length()>0){
                    String temp=input[j];
                    input[j]=input[j+1];
                    input[j+1]=temp;
                }
            }
        }
        return input;
    }

    public boolean contains(String a, String b) {
        if(a.length()+1 != b.length()){
            return false;
        }
        int i = 0;
        for(int j = 0; j < b.length(); j++) {
            if(b.charAt(j) == a.charAt(i)){
                i++;
            }
            if(i==a.length()) {
                return true;
            }
        }
        return i==a.length();
    }
}
