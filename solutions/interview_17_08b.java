package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.08. 马戏团人塔
 * 有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。
 *
 * 示例：
 *
 * 输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
 * 输出：6
 * 解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190)
 */
public class interview_17_08b {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int len = height.length;
        if(len<2){
            return len;
        }
        int[][] st = new int[len][2];
        for(int i = 0; i < len; i++) {
            st[i]  = new int[]{height[i], weight[i]};
        }
        // 在身高相等的情况下，按照体重排序
        Arrays.sort(st, (o1, o2) -> o1[0] == o2[0]?(o2[1] - o1[1]) : o1[0] - o2[0]);
        //dp[i]表示长度为i的最小体重
        int[] dp = new int[len + 1];
        dp[1] = st[0][1];
        int res = 1;
        for(int i = 1; i < len; i++) {
            int w = st[i][1];
            if(w > dp[res])
                dp[++res] = w;
            else {
                //对dp数组进行二分查找
                //pos纪录比num小的最大索引
                int l = 1, r = res - 1, pos = 0;
                while(l <= r) {
                    int mid = l + (r - l) / 2;
                    if(dp[mid] < w) {
                        pos = mid;
                        l = mid + 1;
                    }else
                        r = mid - 1;
                }
                //严格意义上的递增
                //替换第一个比num大的数
                dp[pos + 1] = w;
            }
        }
        return res;
    }
}
