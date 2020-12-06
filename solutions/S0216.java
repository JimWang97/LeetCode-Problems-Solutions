package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 
 * 说明：
 * 
 * 所有数字都是正整数。 解集不能包含重复的组合。 示例 1:
 * 
 * 输入: k = 3, n = 7 输出: [[1,2,4]]
 */
public class S0216 {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        helper(k, n, 1, new ArrayList<Integer>(), 0);
        return ans;
    }

    public void helper(int k, int n, int start, List<Integer> ls, int sum){
        if(ls.size()==k){
            if(sum==n) ans.add(new ArrayList<Integer>(ls));
            return;
        }
        for(int i = start; i <= Math.min(n,9); i++){
            if(sum+i>n) return;
            ls.add(i);
            helper(k, n, i+1, ls, sum+i);
            ls.remove(ls.size()-1);
        }
        return;
    }
}