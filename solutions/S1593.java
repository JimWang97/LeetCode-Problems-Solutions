package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 1593. 拆分字符串使唯一子字符串的数目最大 给你一个字符串 s ，请你拆分该字符串，并返回拆分后唯一子字符串的最大数目。
 * 
 * 字符串 s 拆分后可以得到若干 非空子字符串 ，这些子字符串连接后应当能够还原为原字符串。但是拆分出来的每个子字符串都必须是 唯一的 。
 * 
 * 注意：子字符串 是字符串中的一个连续字符序列。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "ababccc" 输出：5 解释：一种最大拆分方法为 ['a', 'b', 'ab', 'c', 'cc'] 。像 ['a', 'b',
 * 'a', 'b', 'c', 'cc'] 这样拆分不满足题目要求，因为其中的 'a' 和 'b' 都出现了不止一次。
 */
public class S1593 {
    List<String> ls;
    int ans = -1;
    public int maxUniqueSplit(String s) {
        ls = new ArrayList<>();
        helper(ls, 0, s.length(), s);
        return ans;
    }

    public void helper(List<String> ls, int start, int end, String s){
        if(start>=end){
            if(ans<ls.size()){
                ans = ls.size();
            }
            return;
        }
        for(int i = start; i < end; i++){
            String ts =s.substring(start,i); 
            if(!ls.contains(ts)){
                ls.add(ts);
                helper(ls, i+1, end, s);
                ls.remove(ls.size()-1);
            }
        }
    }
}