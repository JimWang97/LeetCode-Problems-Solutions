package solutions;

import java.util.*;

/**
 * 1353. 最多可以参加的会议数目
 * 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
 *
 * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。
 *
 * 请你返回你可以参加的 最大 会议数目。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：events = [[1,2],[2,3],[3,4]]
 * 输出：3
 * 解释：你可以参加所有的三个会议。
 * 安排会议的一种方案如上图。
 * 第 1 天参加第一个会议。
 * 第 2 天参加第二个会议。
 * 第 3 天参加第三个会议。
 *
 * 根据起始日期排序。记录当前日，然后把当前日可以开的会的结束日期全部加入到最小堆中。
 * 每次弹出一个最早结束的会，如果还可以开，那就去开
 */
public class S1353a {
    public int maxEvents(int[][] events) {
        // 按照开始日期升序排列。
        Arrays.sort(events, (first, second) -> first[0] - second[0]);
        // queue 为小顶推。
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int count = 0;
        int day = events[0][0];
        int res = 0;
        while (count < events.length || !queue.isEmpty()) {
            // 这一天开始开的会议。进行补充
            while (count < events.length && events[count][0] == day) {
                queue.add(events[count][1]);
                count++;
            }
            // 从中选出 最近结束的会议。
            while (!queue.isEmpty()) {
                int remove = queue.remove();// 弹出。
                if (remove >= day) { // 过滤了一下那些早已结束的会议。
                    res++;
                    break;
                }
            }
            day++;
        }
        return res;
    }
}
