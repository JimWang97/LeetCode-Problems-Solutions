package solutions;

import java.util.Arrays;

/**
 * 980. Unique Paths III On a 2-dimensional grid, there are 4 types of squares:
 * 
 * 1 represents the starting square. There is exactly one starting square. 2
 * represents the ending square. There is exactly one ending square. 0
 * represents empty squares we can walk over. -1 represents obstacles that we
 * cannot walk over. Return the number of 4-directional walks from the starting
 * square to the ending square, that walk over every non-obstacle square exactly
 * once.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]] Output: 2 Explanation: We have the
 * following two paths: 1.
 * (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2) 2.
 * (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 */
public class S0980 {
    public int[][] G;
    public int ans;
    public int num0;
    public int uniquePathsIII(int[][] grid) {
        G = grid;
        ans = 0;
        int x=0,y=0;
        num0=0;
        for(int i =0;i<grid.length; i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    x=i;
                    y=j;
                }
                if(grid[i][j]==0) num0++;
            }
        }
        helper(x-1, y, 0);
        helper(x+1, y, 0);
        helper(x, y-1, 0);
        helper(x, y+1, 0);
        return ans;
    }

    public void helper(int x, int y, int num){
        if(x<0||x>=G.length||y<0||y>=G[0].length) return;
        if(G[x][y]==2){
            if(num==num0){
                ans++;
            }
            return;
        } else if(G[x][y]==-1||G[x][y]==1) {
            return;
        } else if(G[x][y]==0) {
            G[x][y] = -num-1;
            num++;
            helper(x-1, y, num);
            helper(x+1, y, num);
            helper(x, y-1, num);
            helper(x, y+1, num);
            num--;
            G[x][y] = 0;
        }
    }
}