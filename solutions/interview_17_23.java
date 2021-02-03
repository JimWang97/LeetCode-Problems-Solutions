package solutions;

/**
 * 面试题 17.23. 最大黑方阵
 * 给定一个方阵，其中每个单元(像素)非黑即白。设计一个算法，找出 4 条边皆为黑色像素的最大子方阵。
 *
 * 返回一个数组 [r, c, size] ，其中 r, c 分别代表子方阵左上角的行号和列号，size 是子方阵的边长。若有多个满足条件的子方阵，返回 r 最小的，若 r 相同，返回 c 最小的子方阵。若无满足条件的子方阵，返回空数组。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *    [1,0,1],
 *    [0,0,1],
 *    [0,0,1]
 * ]
 * 输出: [1,0,2]
 * 解释: 输入中 0 代表黑色，1 代表白色，标粗的元素即为满足条件的最大子方阵
 */
public class interview_17_23 {
    public int[] findSquare(int[][] matrix) {
        int row = matrix.length;
        int col = row;
        int ans = -1;
        int ax=-1, ay=-1;
        // 0用于向上求最长连续0，1用于向左求最长连续0
        int[][][] dp = new int[row][col][2];
        if(matrix[0][0]==0) {
            dp[0][0][0] = 1;
            dp[0][0][1] = 1;
            ans = 1;
            ax=0;
            ay=0;
        }
        for(int i = 1; i < row; i++) {
            if(matrix[i][0]==0){
                dp[i][0][0] =dp[i-1][0][0] +1;
                dp[i][0][1] = 1;
            }
        }
        for(int i = 1; i < col; i++) {
            if(matrix[0][i]==0){
                dp[0][i][1]=dp[0][i-1][1]+1;
                dp[0][i][0] = 1;
            }
        }

        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(matrix[i][j]==0) {
                    dp[i][j][0] = dp[i-1][j][0]+1;
                    dp[i][j][1] = dp[i][j-1][1] +1;
                    int m = Math.min(dp[i][j][0], dp[i][j][1]);
                    // 这一步要注意，之前把这一步漏了！！也就是该点往上最大和往左最大中的最小值
                    // 不能直接取到那两个点取看他们的往左往右是否符合。
                    // 比如最小值是4，那么当4不符合的时候，3可能符合。那么就漏了这个情况
                    for(int k=m; k>=1;k--){
                        if(dp[i-k+1][j][1]>=k && dp[i][j-k+1][0]>=k) {
                            if(ans<k){
                                ans = k;
                                ax = i-k+1;
                                ay = j-k+1;
                                System.out.println(ax+" " + ay + " " + ans);
                            }
                        }
                    }

                }
            }
        }
        return ans==-1?new int[0]:new int[]{ax, ay, ans};
    }
}
