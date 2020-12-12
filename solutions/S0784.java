package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * 
 * 
 * 
 * 示例： 输入：S = "a1b2" 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * 
 * 输入：S = "3z4" 输出：["3z4", "3Z4"]
 * 
 * 输入：S = "12345" 输出：["12345"]
 */
public class S0784 {
    List<String> ans;
    public List<String> letterCasePermutation(String S) {
        ans = new ArrayList<>();
        ans.add(S);
        helper(S, 0, 0, new String());    
        return ans;   
    }

    public void helper(String S, int start, int num, String str){
        if(start>=S.length()){
            if(num>=1)
                ans.add(str);
            return;
        }


        char c = S.charAt(start);
        if(c >= 'a' && c <='z'){
            helper(S, start+1, num+1, str+Character.toUpperCase(c));
        }
        if(c >= 'A' && c <='Z'){
            helper(S, start+1, num+1, str+Character.toLowerCase(c));
        }


        helper(S, start+1, num, str+c);
    }
}