package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1282. 用户分组
 * 有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，每位用户都 恰好 属于某一用户组。给你一个长度为 n 的数组
 * groupSizes，其中包含每位用户所处的用户组的大小，请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。
 *
 * 你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：groupSizes = [3,3,3,3,3,1,3]
 * 输出：[[5],[0,1,2],[3,4,6]]
 * 解释：
 * 其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
 *
 * 将人数从小到大排序，能放进一组就放，不行就新开一组
 */
public class S1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int len = groupSizes.length;
        int[][] d = new int[len][2];
        for(int i = 0; i < len; i++) {
            d[i][0] = groupSizes[i];
            d[i][1] = i;
        }
        Arrays.sort(d, (o1, o2) -> o1[0]-o2[0]);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();;
        int count = 0;
        for(int i=0;i<len;i++) {
            if(count==0) {
                tmp = new ArrayList<>();
            }
            count++;
            tmp.add(d[i][1]);
            if(count==d[i][0]) {
                count = 0;
                ans.add(tmp);
            }
        }
        return ans;
    }
}
