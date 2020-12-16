package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：n = 3 输出：[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 */
public class S0022 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(ans, new String(), 0, 0, n); 
        return ans;
    }

    public void helper(List<String> ans, String str, int count1, int count2, int n){
        if(count1>n || count2>n) return;
        if(count1==n&&count2==n) ans.add(str);
        if(count1>count2){
            helper(ans, str+")", count1, count2+1, n);
        }
        helper(ans, str+"(", count1+1, count2, n);
    }
}