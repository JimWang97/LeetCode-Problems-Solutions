package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * 1466. 重新规划路线
 * n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
 *
 * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
 *
 * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
 *
 * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
 *
 * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * 输出：3
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0
 */
public class S1466 {
    class Solution {
        public int minReorder(int n, int[][] connections) {
            int count = 0;

            Set<Integer> set = new HashSet<>();
            // 0 可直达 0
            set.add(0);
            for (int i=0; i<connections.length; i++) {
                // 标记可直达 0 的 城市，放入 set
                if (connections[i][1] == 0 ) {
                    set.add(connections[i][0]);
                }
            }
            // 保证所有城市都进入 Set 集合，即路线规划完毕
            while (set.size() < n) {
                for (int i=0; i<connections.length; i++) {
                    // 该城市A可达 0，现在可达城市B，set添加城市B
                    if (set.contains(connections[i][1])) {
                        set.add(connections[i][0]);
                        // 城市A 可达 城市B，而城市B可达0，set添加城市A
                    } else if (set.contains(connections[i][0])) {
                        //System.out.println("$$$ " + connections[i][0] + "-" + connections[i][1]);
                        set.add(connections[i][1]);
                        count++;
                    }
                }
            }

            return count;
        }
    }
}
