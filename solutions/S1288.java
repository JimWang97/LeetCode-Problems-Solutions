package solutions;

import java.util.Arrays;

/**
 * 1288. 删除被覆盖区间
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 *
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 *
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 *
 *
 *
 * 示例：
 *
 * 输入：intervals = [[1,4],[3,6],[2,8]]
 * 输出：2
 * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 */
public class S1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0]);
        int max = 0;
        int ans = 0;
        for(int i = 0; i < intervals.length; i++) {
            System.out.println(intervals[i][0]);
            if(max<intervals[i][1]) {
                max = intervals[i][1];
                ans++;
            }
        }
        return ans;
    }
}
