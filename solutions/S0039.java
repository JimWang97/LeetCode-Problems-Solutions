package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为
 * target 的组合。
 * 
 * candidates 中的数字可以无限制重复被选取。
 * 
 * 说明：
 * 
 * 所有数字（包括 target）都是正整数。 解集不能包含重复的组合。 示例 1：
 * 
 * 输入：candidates = [2,3,6,7], target = 7, 所求解集为： [ [7], [2,2,3] ]
 */
public class S0039 {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, 0, new ArrayList<Integer>());
        return ans;
    }

    public void helper(int[] candidates, int target,int start, int sum, List<Integer> ls){
        if(sum==target){
            ans.add(new ArrayList<Integer>(ls));
        }
        for(int i = start; i < candidates.length; i++){
            if(sum+candidates[i]<=target){
                ls.add(candidates[i]);
                helper(candidates, target,i, sum+candidates[i], ls);
                ls.remove(ls.size()-1);
            }
        }
    }
}