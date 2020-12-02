package solutions;

import java.util.LinkedList;
import java.util.List;

/**
 * 842. Split Array into Fibonacci Sequence Given a string S of digits, such as
 * S = "123456579", we can split it into a Fibonacci-like sequence [123, 456,
 * 579].
 * 
 * Formally, a Fibonacci-like sequence is a list F of non-negative integers such
 * that:
 * 
 * 0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer
 * type); F.length >= 3; and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length -
 * 2. Also, note that when splitting the string into pieces, each piece must not
 * have extra leading zeroes, except if the piece is the number 0 itself.
 * 
 * Return any Fibonacci-like sequence split from S, or return [] if it cannot be
 * done.
 * 
 * Example 1:
 * 
 * Input: "123456579" Output: [123,456,579]
 */
public class S0842 {
    public List<Integer> splitIntoFibonacci(String S) {
        LinkedList<Integer> res=new LinkedList<>();
        dfs(S,0,res);
        return res;
    }

    public boolean dfs(String S,int index,List<Integer> lis){
        if (index == S.length()) {
            return lis.size()>2;
        }
        for (int i=index+1;i<=S.length();i++) {
            String temp=S.substring(index,i);
            //长度大于10,或者Long解析出来大于INT_MAX了就直接break
            if (S.charAt(index) == '0' && i>index+1 || temp.length()>10 || Long.valueOf(temp)>Integer.MAX_VALUE) {
                break;
            }
            int str=Integer.valueOf(temp);
            int one=lis.size()>=2 ? lis.get(lis.size()-1):-1;
            int two=lis.size()>=2 ? lis.get(lis.size()-2):-1;
            lis.add(str);
            if ((one==-1 || two==-1 || one+two==str) && dfs(S,i,lis)) {
                return true;
            }
            lis.remove(lis.size()-1);
        }
        return false;
    }
}