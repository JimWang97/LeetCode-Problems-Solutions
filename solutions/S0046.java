package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. 全排列 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3] 输出: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 * 
 */
public class S0046 {
    List<List<Integer>> ans;
    int[] visited;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        visited = new int[nums.length];
        Arrays.fill(visited, 0);
        helper(nums, new ArrayList<Integer>(), 0, nums.length);
        return ans;
    }

    public void helper(int[] nums, List<Integer> ls, int num, int len){
        if(num>=len){
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i = 0; i < len; i++){
            if(visited[i]!=1){
                ls.add(nums[i]);
                visited[i] = 1;
                helper(nums, ls, num+1, len);
                visited[i] = 0;
                ls.remove(ls.size()-1);
            }
        }
    }
}