package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * 874. 模拟行走机器人
 * 机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
 *
 * -2 ：向左转 90 度
 * -1 ：向右转 90 度
 * 1 <= x <= 9 ：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
 *
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
 *
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
 *
 *
 * 注意：
 *
 * 北表示 +Y 方向。
 * 东表示 +X 方向。
 * 南表示 -Y 方向。
 * 西表示 -X 方向。
 *
 *
 * 示例 1：
 *
 * 输入：commands = [4,-1,3], obstacles = []
 * 输出：25
 * 解释：
 * 机器人开始位于 (0, 0)：
 * 1. 向北移动 4 个单位，到达 (0, 4)
 * 2. 右转
 * 3. 向东移动 3 个单位，到达 (3, 4)
 * 距离原点最远的是 (3, 4) ，距离为 32 + 42 = 25
 */
public class S0874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        Set<int[]> ob = new HashSet<>();
        for(int[] o : obstacles) {
            ob.add(o);
        }
        int d = 0;
        int x = 0, y = 0;
        int ans=0;
        for(int c : commands) {
            if(c==-1) {
                d = (d+1)%4;
            } else if(c==-2) {
                d = (d+3)%4;
            } else {
                for(int j = 0; j < c; j++) {
                    int next_x = x+direction[d][0];
                    int next_y = y+direction[d][1];
                    if(ob.contains(new int[]{next_x, next_y})){
                        break;
                    }
                    x = next_x;
                    y = next_y;
                }
            }
            ans = Math.max(ans, x*x+y*y);
        }
        return ans;
    }
}
