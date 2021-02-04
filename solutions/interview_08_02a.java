package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.02. 迷路的机器人
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
 * 解释:
 * 输入中标粗的位置即为输出表示的路径，即
 * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
 */
public class interview_08_02a {
    List<List<Integer>> path = new ArrayList<>();
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        if(dfs(obstacleGrid,0,0)){
            return path;
        }else{
            return new ArrayList<>();
        }
    }

    private boolean dfs(int[][] obstacleGrid, int row, int col){
        //当前路径不可走
        if (row > obstacleGrid.length-1 || col > obstacleGrid[0].length-1 || obstacleGrid[row][col] == 1){
            return false;
        }
        //当前坐标添加到路径中
        List<Integer> list = new ArrayList<>();
        list.add(row);
        list.add(col);
        path.add(list);

        if((row == obstacleGrid.length-1 && col == obstacleGrid[0].length-1) || dfs(obstacleGrid,row+1,col) || dfs(obstacleGrid,row,col+1)){
            return true;
        }
        //移除当前路径
        path.remove(path.size()-1);

        /** 如果到达此处, 说明从当前坐标(row,col)向下或向右移动都无法到达目标地, 那么将当前坐标置为1, 进行剪枝处理 */
        obstacleGrid[row][col] = 1;

        return false;
    }
}
