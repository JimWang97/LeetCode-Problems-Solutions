package solutions;

import java.util.Stack;

/**
 * 856. 括号的分数
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 *
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *
 *
 * 示例 1：
 *
 * 输入： "()"
 * 输出： 1
 */
public class S0856a {
    class Solution {
        public int scoreOfParentheses(String S) {
            int length=S.length();
            int sum=0;
            int n=0;
            for(int i=0;i<length;i++)
            {
                if(S.charAt(i)=='(')
                {
                    if(n==0)
                    {
                        n=1;
                    }
                    else
                    {
                        n=n<<1;
                    }
                }
                else if(S.charAt(i)==')')
                {
                    if(S.charAt(i-1)=='(')
                    {
                        sum+=n;
                    }
                    n=n>>1;

                }
            }
            return sum;
        }
    }
}
