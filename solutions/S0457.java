package solutions;

import java.util.ArrayList;

/**
 * 457. 环形数组是否存在循环
 * 存在一个不含 0 的 环形 数组 nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数：
 *
 * 如果 nums[i] 是正数，向前 移动 nums[i] 步
 * 如果 nums[i] 是负数，向后 移动 nums[i] 步
 * 因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。
 *
 * 数组中的 循环 由长度为 k 的下标序列 seq ：
 *
 * 遵循上述移动规则将导致重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
 * 所有 nums[seq[j]] 应当不是 全正 就是 全负
 * k > 1
 * 如果 nums 中存在循环，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,-1,1,2,2]
 * 输出：true
 * 解释：存在循环，按下标 0 -> 2 -> 3 -> 0 。循环长度为 3 。
 */
public class S0457 {
    class Solution {
        /*
         * 判断环形数组中是否存在循环
         */
        public boolean circularArrayLoop(int[] nums) {

            int n = nums.length;	//数组长度
            //数组长度为1时，要么不成循环，要么循环长度为1
            if(n == 1)	return false;
            boolean[] visit = new boolean[n];	//访问数组，用来记录数组中元素是否被访问
            for(boolean v: visit)	v = false;

            int i = 0;
            //遍历整个环形数组，查看以i为下标作为起点，是否存在循环
            while(i < n) {
                int j = i;
                ArrayList<Integer> loopLink = new ArrayList<Integer>();  //循环链，用来判断循环

                //进入循环链，判断为起点的下标的循环链中是否符合循环条件
                while(true) {
                    visit[j] = true;
                    loopLink.add(j);
                    //得到循环链中下一个元素的下标
                    int next = j + nums[j];	//表示循环链下一元素的索引
                    while(next >= n || next < 0) {
                        if(next >= n)	next %= n;
                        else if(next < 0)	next = n + next;
                    }
                    //判断循环不成立
                    //若循环链前后两元素为相反数，则不满足循环条件（同向）
                    //若循环长度为1，或者进入死循环,循环的长度为1不满足循环
                    if(j == next || nums[j] * nums[next] < 0)	break;

                    //判断循环成立
                    //若进入死循环，长度大于1满足循环
                    if(loopLink.contains(next)) return true;

                    j = next;
                }

                //已经在循环链上走过的点，不用再遍历
                while(visit[i] == true) {
                    i++;
                    if(i >= n)	return false;
                }

            }
            return false;
        }
    }
}
