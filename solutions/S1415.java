package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 1415. The k-th Lexicographical String of All Happy Strings of Length n A
 * happy string is a string that:
 * 
 * consists only of letters of the set ['a', 'b', 'c']. s[i] != s[i + 1] for all
 * values of i from 1 to s.length - 1 (string is 1-indexed). For example,
 * strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings
 * "aa", "baa" and "ababbc" are not happy strings.
 * 
 * Given two integers n and k, consider a list of all happy strings of length n
 * sorted in lexicographical order.
 * 
 * Return the kth string of this list or return an empty string if there are
 * less than k happy strings of length n.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 1, k = 3 Output: "c" Explanation: The list ["a", "b", "c"]
 * contains all happy strings of length 1. The third string is "c".
 */
public class S1415 {
    List<String> ls;
    StringBuffer sb = new StringBuffer();
    char[] CHAR = new char[]{'a','b','c'};
    public String getHappyString(int n, int k) {
        ls = new ArrayList<>();
        helper(n, 0);
        if(k-1>ls.size()) return "";
        return ls.get(k-1);
    }

    public void helper(int target, int now){
        if(now==target) {
            ls.add(sb.toString());
            return;
        }
        
        for(char c : CHAR){
            if(now>=1 && sb.charAt(now-1)!=c){
                sb.append(c);
                helper(target, now+1);
                sb.deleteCharAt(now);
            }
            if(now==0){
                sb.append(c);
                helper(target, now+1);
                sb.deleteCharAt(now);
            }
        }
    }
}