package solutions;

import java.util.ArrayList;
import java.util.List;

/*
229. 求众数 II
给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。

进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。



示例 1：

输入：[3,2,3]
输出：[3]
 */
public class S0229a {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int x = 0, y = 0, cx = 0, cy = 0, count = 0;
        for(int num: nums) {
            if((num==x || cx==0) && num!=y) {
                cx++;
                x=num;
            }else if((num==y || cy==0)) {
                cy++;
                y = num;
            } else {
                cx--;
                cy--;
            }
        }
        for(int num:nums) {
            if(num==x) {
                count++;
            }
        }
        if(count>nums.length/3){
            ans.add(x);
        }
        count=0;
        for(int num:nums) {
            if(num==y) {
                count++;
            }
        }
        if(count>nums.length/3&&y!=x){
            ans.add(y);
        }
        return ans;
    }
}
