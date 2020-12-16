package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1291. 顺次数 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
 * 
 * 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输出：low = 100, high = 300 输出：[123,234]
 * 
 */
public class S1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            int num = i;
            for(int j = i + 1; j <= 9; j++){
                num = num * 10 + j;
                if(num>=low && num <=high){
                    ans.add(num);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}