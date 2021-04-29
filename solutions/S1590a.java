package solutions;

import java.util.HashMap;

/**
 * 1590. 使数组和能被 P 整除
 * 给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。
 *
 * 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。
 *
 * 子数组 定义为原数组中连续的一组元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,1,4,2], p = 6
 * 输出：1
 * 解释：nums 中元素和为 10，不能被 p 整除。我们可以移除子数组 [4] ，剩余元素的和为 6 。
 */
public class S1590a {
    static class Solution {
        public int minSubarray(int[] nums, int p) {
            int ans = Integer.MAX_VALUE;
            HashMap<Long , Integer> map = new HashMap<>();
            //用 mod 存储 和 的余数
            long mod = 0;
            for(int num: nums){
                mod += num;
            }
            mod = mod % p;
            if(mod == 0){
                return 0; //如果 余数 为零，就说明整个数组的和是能被整除的！
            }
            long sum = 0;       //sum存储的是 nums[0] 到 nums[i]的和，也就是前缀和
            map.put((long)0,-1);//把 0 设置为 -1，因为数组起始坐标为0！
            for(int i = 0;i < nums.length;i ++){
                sum += nums[i];
                // 就是我当前余counter，要往前找一个位置，他的前缀和是余(counter -  mod + p) % p的。两个中间的全部删掉就行了。这一部分的和正好是余mod。删掉就正好能整除
                long counter = sum % p;//求出 前缀和 对 p 取余!
                long aimnum  =  (counter -  mod + p) % p; //求出目标的前缀和
                if(map.get(aimnum) != null){
                    ans = Math.min(ans,i - map.get(aimnum));
                }
                map.put(counter,i);//将当前位置的前缀和存储map中！
            }
            return ans >= nums.length ? -1 : ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minSubarray(new int[]{1,2,3,4,5,7}, 3);
    }
}
