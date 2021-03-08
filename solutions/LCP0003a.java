package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * LCP 03. 机器人大冒险
 * 力扣团队买了一个可编程机器人，机器人初始位置在原点(0, 0)。小伙伴事先给机器人输入一串指令command，机器人就会无限循环这条指令的步骤进行移动。指令有两种：
 *
 * U: 向y轴正方向移动一格
 * R: 向x轴正方向移动一格。
 * 不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。
 *
 * 给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：command = "URR", obstacles = [], x = 3, y = 2
 * 输出：true
 * 解释：U(0, 1) -> R(1, 1) -> R(2, 1) -> U(2, 2) -> R(3, 2)。
 */
public class LCP0003a {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int upCnt = 0, rightCnt = 0;
        for(char ch : command.toCharArray()) {
            if(ch == 'U')
                upCnt++;
            else
                rightCnt++;
        }
        if(!canReach(upCnt, rightCnt, command, x, y))
            return false;


        for(int[] obstacle : obstacles) {
            if(obstacle[0] <= x && obstacle[1] <= y && canReach(upCnt, rightCnt, command, obstacle[0], obstacle[1]))
                return false;
        }
        return true;
    }

    private boolean canReach(int upCnt, int rightCnt, String command, int destX, int destY) {
        int loopCnt = Math.min(destX / rightCnt, destY / upCnt);

        destX -= loopCnt * rightCnt;
        destY -= loopCnt * upCnt;

        for(char ch : command.toCharArray()) {
            if(destX == 0 && destY == 0)
                return true;
            if(ch == 'U')
                destY--;
            else
                destX--;
        }

        return destX == 0 && destY == 0;
    }
}
