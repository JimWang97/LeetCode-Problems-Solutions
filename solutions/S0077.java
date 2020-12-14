package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 */
public class S0077 {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        helper(n, k, 1, 0, new ArrayList<Integer>());
        return ans;
    }

    public void helper(int n, int k, int cur, int len, List<Integer> ls){
        if(len == k) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i = cur; i <= n; i++) {
            ls.add(i);
            helper(n, k, i+1, len+1, ls);
            ls.remove(ls.size()-1);
        }
    }
}