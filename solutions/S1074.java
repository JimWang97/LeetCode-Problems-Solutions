package solutions;

/**
 * 1074. 元素和为目标值的子矩阵数量
 * 给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
 *
 * 子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。
 *
 * 如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * 输出：4
 * 解释：四个只含 0 的 1x1 子矩阵。
 *
 * 先求每一行的前缀和。然后对此求每一列的。然后按照行列限定住一个区域，对比target就行了。
 * 时间复杂度On^4
 */
public class S1074 {
    class Solution {
        public int numSubmatrixSumTarget(int[][] matrix, int target) {
            int[][] sum = new int[matrix.length][matrix[0].length+1];
            for(int i = 0; i < matrix.length; ++i){
                for(int j = 0; j < matrix[0].length; ++j){
                    sum[i][j+1] = sum[i][j] + matrix[i][j];
                }
            }

            int ans = 0;
            int startY = 0, endY = 1;
            int[] lineSum = new int[sum.length+1];
            while(endY < sum[0].length){
                for(; startY < endY; ++startY){
                    for(int i = 1; i < lineSum.length; ++i){
                        lineSum[i] = lineSum[i-1] + sum[i-1][endY] - sum[i-1][startY];
                    }
                    for(int i = 0; i < lineSum.length - 1; ++i){
                        for(int j = i+1; j < lineSum.length; ++j)
                            if(lineSum[j] - lineSum[i] == target)
                                ++ans;
                    }
                }
                ++endY;
                startY = 0;
            }
            return ans;
        }
    }

}
