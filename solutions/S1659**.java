package solutions;

import java.util.Arrays;

/**
 * 1659. 最大化网格幸福感 给你四个整数 m、n、introvertsCount 和 extrovertsCount 。有一个 m x n
 * 网格，和两种类型的人：内向的人和外向的人。总共有 introvertsCount 个内向的人和 extrovertsCount 个外向的人。
 * 
 * 请你决定网格中应当居住多少人，并为每个人分配一个网格单元。 注意，不必 让所有人都生活在网格中。
 * 
 * 每个人的 幸福感 计算如下：
 * 
 * 内向的人 开始 时有 120 个幸福感，但每存在一个邻居（内向的或外向的）他都会 失去 30 个幸福感。 外向的人 开始 时有 40
 * 个幸福感，每存在一个邻居（内向的或外向的）他都会 得到 20 个幸福感。 邻居是指居住在一个人所在单元的上、下、左、右四个直接相邻的单元中的其他人。
 * 
 * 网格幸福感 是每个人幸福感的 总和 。 返回 最大可能的网格幸福感 。
 * 
 * 超难  看一下解析。
 * 状压！记得放到库中去
 * https://leetcode-cn.com/problems/maximize-grid-happiness/solution/you-yi-chong-zhuang-ya-jiao-zuo-hua-dong-chuang-ko/
 */
public class S1659 {
    // 预处理：每一个 mask 的三进制表示
    int[] mask_span [] = new int[243][5];
    // dp[上一行的 mask][当前处理到的行][剩余的内向人数][剩余的外向人数]
    Integer [][][][] dp = new Integer[243][5][7][7];
    // 预处理：每一个 mask 包含的内向人数，外向人数，行内得分（只统计 mask 本身的得分，不包括它与上一行的），行外得分
    int [] nx_inner = new int [243];  //内向人数
    int [] wx_inner = new int [243]; // 外向人数
    int [] score_inner = new int[243]; //行内得分（只统计 mask 本身的得分，不包括它与上一行的）
    int [][] score_outer = new int[243][243];
    int m,n,n3;



    public static int calc(int x, int y){
        if (x == 0 || y == 0) {
            return 0;
        }
        // 例如两个内向的人，每个人要 -30，一共 -60，下同
        if (x == 1 && y == 1) {
            return -60;
        }
        if (x == 2 && y == 2) {
            return 40;
        }
        return -10;
    }


    public  int getMaxGridHappiness(int m, int n, int nx, int wx){
        int n3 = (int)Math.pow(3, n);
        this.n = n;
        this.m = m;
        this.n3 = n3;

        for (int mask = 0; mask < n3; mask++) {

            //初始化mask_span
            for (int mask_tmp=mask,i=0;i<n;i++){
                mask_span[mask][i] = mask_tmp % 3;
                mask_tmp /= 3;
            }
            for (int i=0;i<n;i++){
                //个人分数
                if(mask_span[mask][i]!=0){
                    if(mask_span[mask][i]==1){
                        nx_inner[mask]+=1;
                        score_inner[mask] += 120;
                    }else if (mask_span[mask][i]==2){
                        wx_inner[mask]+=1;
                        score_inner[mask] += 40;
                    }
                    //行内分数汇总
                    if(i >= 1){
                        score_inner[mask] += calc(mask_span[mask][i], mask_span[mask][i - 1]);
                    }
                }
            }
        }
        //行外分数
        for(int mask0=0;mask0<n3;mask0++){
            for(int mask1=0;mask1<n3;mask1++){
                for (int i = 0; i < n; i++) {
                    score_outer[mask0][mask1] += calc(mask_span[mask0][i],mask_span[mask1][i]);
                }
            }
        }
        return dfs(0, 0, nx, wx);
    }

    int dfs(int mask_last, int row, int nx, int wx) {
        // 边界条件：如果已经处理完，或者没有人了
        if (row == m || nx + wx == 0) {
            return 0;
        }

        //记忆化搜索
        if (dp[mask_last][row][nx][wx] != null) {
            return dp[mask_last][row][nx][wx];
        }

        int best = 0;
        for (int mask=0;mask<n3;mask++){
            if(nx_inner[mask] > nx || wx_inner[mask] > wx){
                continue;
            }
            int score = score_inner[mask] + score_outer[mask][mask_last];
            best = Math.max(best, score + dfs(mask, row + 1, nx - nx_inner[mask], wx - wx_inner[mask]));
        }

        dp[mask_last][row][nx][wx] = best;
        return best;
    }

//    public static void main(String[] args) {
//        System.out.println(new Solution3().getMaxGridHappiness(3, 1, 2, 3));
//    }
}