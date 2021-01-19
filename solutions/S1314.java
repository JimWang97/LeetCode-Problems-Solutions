package solutions;

/**
 * 1314. 矩阵区域和
给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和： 

i - K <= r <= i + K, j - K <= c <= j + K 
(r, c) 在矩阵内。
 

示例 1：

输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
输出：[[12,21,16],[27,45,33],[24,39,28]]
 */
public class S1314 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] ans = new int[mat.length][mat[0].length];
        int x_low,x_hi,y_low,y_hi;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++) {
                if(i==0) {
                    if(j!=0){
                        mat[i][j] += mat[i][j-1];
                    }
                }
                else {
                    mat[i][j]+=mat[i-1][j];
                    if(j!=0){
                        mat[i][j]+=mat[i][j-1];
                        mat[i][j]-=mat[i-1][j-1];
                    }
                }
            }
        }
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++) {
                x_low = i-K;
                x_hi = i+K>=mat.length-1?mat.length-1 : i+K;
                y_low = j-K;
                y_hi = j+K>=mat[0].length-1?mat[0].length-1 : j+K;
                if(x_low<=0 && y_low<=0) {
                    ans[i][j] = mat[x_hi][y_hi];
                } else if(x_low>0 && y_low<=0) {
                    ans[i][j] = mat[x_hi][y_hi] - mat[x_low-1][y_hi];
                } else if(x_low<=0 && y_low>0) {
                    ans[i][j] = mat[x_hi][y_hi] - mat[x_hi][y_low-1];
                } else {
                    ans[i][j] = mat[x_hi][y_hi] - mat[x_hi][y_low-1]- mat[x_low-1][y_hi]+mat[x_low-1][y_low-1];
                }
            }
            
        }
        return ans;
    }
}