package solutions;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * 1239. 串联字符串的最大长度 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s
 * 中的每一个字符都只出现过一次，那么它就是一个可行解。
 * 
 * 请返回所有可行解 s 中最长长度。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：arr = ["un","iq","ue"] 输出：4 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和
 * "ique"，最大长度为 4。
 */
public class S1239 {

    int maxLen = 0;
    public int maxLength(List<String> arr) {
        helper(arr, 0, "");
        return maxLen;
    }

    public void helper(List<String> arr, int start, String maxS){
        if(start==arr.size()){
            if(maxS.length()>maxLen) maxLen = maxS.length();
            return;
        }

        for(int i = start; i < arr.size(); i++){
            if (!checkDup(maxS, arr.get(i))){
                maxLen = Math.max(maxLen, maxS.length() + arr.get(i).length());
                helper(arr, i + 1, maxS + arr.get(i));
            }

        }
        return ;
    }

    boolean checkDup(String str1, String str2) {
        Set<Character> charSet = new HashSet<>();
        for (char ch : str1.toCharArray()) {
            if (charSet.contains(ch)) {
                return true;
            }
            charSet.add(ch);
        }

        for (char ch : str2.toCharArray()) {
            if (charSet.contains(ch)) {
                return true;
            }

            charSet.add(ch);
        }

        return false;
    }
}