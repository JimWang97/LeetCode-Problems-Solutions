package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1338. 数组大小减半
 * 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
 *
 * 返回 至少 能删除数组中的一半整数的整数集合的最小大小。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,3,3,3,5,5,5,2,2,7]
 * 输出：2
 * 解释：选择 {3,7} 使得结果数组为 [5,5,5,2,2]、长度为 5（原数组长度的一半）。
 * 大小为 2 的可行集合有 {3,5},{3,2},{5,2}。
 * 选择 {2,7} 是不可行的，它的结果数组为 [3,3,3,3,5,5,5]，新数组长度大于原数组的二分之一。
 */
public class S1338 {
    public int minSetSize(int[] arr) {
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2-o1);
        Arrays.sort(arr);
        int len = arr.length;
        int t = 1;
        for(int i = 1; i < len; i++) {
            if(arr[i]==arr[i-1]) {
                t++;
                if(i==len-1) {
                    q.offer(t);
                }
            } else {
                q.offer(t);
                t = 1;
            }
        }
        int sum = 0;
        int ans = 0;
        while(!q.isEmpty()) {
            System.out.println(q.peek());
            sum += q.poll();
            ans++;
            if(2*sum>=len) {
                break;
            }
        }
        return ans;
    }
}
