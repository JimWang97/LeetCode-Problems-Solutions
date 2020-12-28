package solutions;

/**
 * 面试题 17.10. 主要元素
数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。

示例 1：

输入：[1,2,5,9,5,9,5,5,5]
输出：5
 */
public class interview_17_10 {
    public int majorityElement(int[] nums) {
        if(nums.length==0) return -1;
        int vote = 0;
        int major = 0;
        for(int num : nums){
            if(vote==0){
                major = num;
                vote++;
            } else if(num==major){
                vote++;
            } else if (num!=major){
                vote--;
            }
        }
        if(vote<=0) return -1;
        int count=0;
        for(int num : nums){
            if(num==major) count++;
        }
        return count>nums.length/2?major:-1;
    }
}