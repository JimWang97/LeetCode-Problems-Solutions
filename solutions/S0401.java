package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 401. 二进制手表 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 * 
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * 
 * 
 * 
 * 例如，上面的二进制手表读取 “3:25”。
 * 
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入: n = 1 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04",
 * "0:08", "0:16", "0:32"]
 */
public class S0401 {
    List<String> ans;
    public List<String> readBinaryWatch(int num) {
        ans = new ArrayList<>();
        if(num<0) return ans;
        int[] nums = new int[]{8,4,2,1,32,16,8,4,2,1};
        helper(num, nums, 0, 0, 0);
        return ans;
    }

    public void helper(int num, int[] nums, int start, int h, int m){
        if(num==0){
            if(h>11||m>59) return;
            StringBuffer tmp = new StringBuffer();
            tmp.append(h);
            tmp.append(":");
            if(m<10) tmp.append("0");
            tmp.append(m);
            ans.add(tmp.toString());
            return;
        }
        for(int i = start; i < nums.length; i++){
            if(i<4)
                h+=nums[i];
            else
                m+=nums[i];
            helper(num-1, nums, i+1, h, m);
            if(i<4)
                h-=nums[i];
            else
                m-=nums[i];
        }
    }
}