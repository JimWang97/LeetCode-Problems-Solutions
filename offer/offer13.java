package offer;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0]
 * 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格
 * [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 */
public class offer13 {
    public int movingCount(int m, int n, int k) {
        int[][] dp = new int[m][n];
        int ans = 1;
        dp[0][0] = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(helper(i,j)<=k && (isArrive(dp, i-1,j)||isArrive(dp, i+1,j)||isArrive(dp, i,j-1)||isArrive(dp, i,j+1))){
                    dp[i][j]++;
                    ans++;
                }
            }
        }
        return ans;
    }
    public int helper(int x, int y) {
        int ans = 0;
        while(x>0) {
            ans+=x%10;
            x/=10;
        }
        while(y>0){
            ans+=y%10;
            y/=10;
        }

        return ans;
    }
    public boolean isArrive(int[][] dp, int x, int y) {

        if(x<0||x>=dp.length||y<0||y>=dp[0].length) {
            return false;
        }
        if(dp[x][y]>0) {

            return true;
        }
        return false;
    }
}
