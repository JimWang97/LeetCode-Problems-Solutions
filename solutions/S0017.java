package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23" 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class S0017 {
    char[][] s = new char[][]{{'a','b','c'},{'d','e','f'},{'g','h','i'},
                            {'j','k','l'},{'m','n','o'},{'p','q','r','s'},
                            {'t','u','v'},{'w','x','y','z'}};

    List<String> ans;
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<String>();
        ans = new ArrayList<>();
        char[] ds = digits.toCharArray();
        helper(ds, 0, new String());
        return ans;
    }

    public void helper(char[] ds, int start, String ts){
        if(start == ds.length){
            ans.add(ts);
        }
        int num = ds[start]-'0'-2;
        for(int i = 0; i < s[num].length; i++){
            helper(ds, start+1, ts+s[num][i]);
        }
    }
}