package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 1375. 灯泡开关 III
 * 房间中有 n 枚灯泡，编号从 1 到 n，自左向右排成一排。最初，所有的灯都是关着的。
 *
 * 在 k  时刻（ k 的取值范围是 0 到 n - 1），我们打开 light[k] 这个灯。
 *
 * 灯的颜色要想 变成蓝色 就必须同时满足下面两个条件：
 *
 * 灯处于打开状态。
 * 排在它之前（左侧）的所有灯也都处于打开状态。
 * 请返回能够让 所有开着的 灯都 变成蓝色 的时刻 数目 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：light = [2,1,3,5,4]
 * 输出：3
 * 解释：所有开着的灯都变蓝的时刻分别是 1，2 和 4 。
 */
public class S1375 {
    class Solution {
        public int numTimesAllBlue(int[] light) {
            int size = light.length;
            int count = 0, maxReachingPoint = 0;
            for (int i = 0 ; i < size; i++){
                maxReachingPoint = Math.max(maxReachingPoint, light[i]);
                if ( i + 1 == maxReachingPoint){
                    count += 1;
                }
            }
            return count;
        }
    }
}
