package solutions;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 40. 组合总和 II 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target
 * 的组合。
 * 
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 
 * 说明：
 * 
 * 所有数字（包括目标数）都是正整数。 解集不能包含重复的组合。 示例 1:
 * 
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8, 所求解集为: [ [1, 7], [1, 2, 5],
 * [2, 6], [1, 1, 6] ]
 */
public class S0040 {
    List<List<Integer>> ans;
    // public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    //     ans = new ArrayList<>();
    //     helper(new ArrayList<Integer>(), 0, candidates.length, 0, candidates, target);
    //     return ans;
    // }

    // public void helper(List<Integer> ls, int start, int end, int sum, int[] candidates, int target){
    //     if(sum==target){
    //         List<Integer> nls = new ArrayList<>(ls);
    //         Collections.sort(nls);
    //         if(!ans.contains(nls))
    //             ans.add(nls);
    //     }
    //     if(sum>target) return;

    //     for(int i = start; i < end; i++){
    //         ls.add(candidates[i]);
    //         helper(ls, i+1, end, sum+candidates[i], candidates, target);
    //         ls.remove(ls.size()-1);
    //     }
    // }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(new ArrayList<Integer>(), 0, candidates.length, 0, candidates, target);
        return ans;
    }

    public void helper(List<Integer> ls, int start, int end, int sum, int[] candidates, int target){
        if(sum == target){
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i = start; i < end; i++){
            if(sum+candidates[i]>target) continue;
            // 同一级的情况下，前一次循环已经有相同的输出过了，所以之后的都跳过
            if(i>start && candidates[i]==candidates[i-1]) continue;
            ls.add(candidates[i]);
            helper(ls, i+1, end, sum+candidates[i], candidates, target);
            ls.remove(ls.size()-1);
        }
    }
}