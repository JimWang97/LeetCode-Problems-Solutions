package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 47. 全排列 II 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [1,1,2] 输出： [[1,1,2], [1,2,1], [2,1,1]]
 */
public class S0047 {
  boolean[] vis;

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> perm = new ArrayList<Integer>();
    vis = new boolean[nums.length];
    Arrays.sort(nums);
    backtrack(nums, ans, 0, perm);
    return ans;
  }

  public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
    if (idx == nums.length) {
      ans.add(new ArrayList<Integer>(perm));
      return;
    }
    for (int i = 0; i < nums.length; ++i) {
      if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
        continue;
      }
      perm.add(nums[i]);
      vis[i] = true;
      backtrack(nums, ans, idx + 1, perm);
      vis[i] = false;
      perm.remove(idx);
    }
  }
}