package solutions;

import java.util.ArrayList;
/**
 * 241. 为运算表达式设计优先级
给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。

示例 1:

输入: "2-1-1"
输出: [0, 2]
解释: 
((2-1)-1) = 0 
(2-(1-1)) = 2

 */
import java.util.List;

public class S0241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '-' || c == '+' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for(Integer l : left){
                    for(Integer r : right) {
                        if(c == '-'){
                            ans.add(l-r);
                        }  else if(c == '+'){
                            ans.add(l+r);
                        } else if(c == '*'){
                            ans.add(l*r);
                        }
                    }
                }
            }
        }
        if(ans.size()==0) ans.add(Integer.valueOf(input));
        return ans;
    }
}