package solutions;

import java.util.Stack;

/**
 * 227. 基本计算器 II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3+2*2"
 * 输出：7
 */
public class S0227a {
    class Solution {
        public int calculate(String s) {
            char[] cs = s.toCharArray();
            int len = cs.length;
            Stack<Integer> stack = new Stack<>();
            int num = 0;
            char prevSign = '+';
            for(int i = 0;i < len; i++) {
                if(Character.isDigit(cs[i])) {
                    num = num*10+cs[i]-'0';
                }
                if(!Character.isDigit(cs[i])&&cs[i]!=' '||i==len-1) {
                    switch (prevSign) {
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
                            break;
                        case '*':
                            stack.push(stack.pop()*num);
                            break;
                        case '/':
                            stack.push(stack.pop()/num);
                    }
                    num = 0;
                    prevSign = cs[i];
                }
            }

            int ans = 0;
            while(!stack.isEmpty()) {
                ans+=stack.pop();
            }
            return ans;
        }
    }
}
