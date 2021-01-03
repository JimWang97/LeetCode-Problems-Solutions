package solutions;
/**
 * 面试题 10.09. 排序矩阵查找
给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。

示例:

现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。
 */
public class interview_10_09 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix.length;
        int y = 0;
        while(x>=0 && y <=matrix[0].length){
            if(matrix[x][y]<target){
                y++;
            } else if (matrix[x][y]>target) {
                x--;
            } else {
                return true;
            }
        }
        return false;
    }
}