package solutions;

/**
 * 130. 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 *
 * 示例 1：
 *
 *
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class S0130 {
    class Solution {
        int row, col;
        public void solve(char[][] board) {
            if(board==null || board.length==0) return;
            row = board.length;
            col = board[0].length;
            for(int i = 0 ; i < col; i++) {
                dfs(board, 0, i);
                dfs(board, row-1, i);
            }
            for(int i = 0 ; i < row; i++) {
                dfs(board, i, 0);
                dfs(board, i, col-1);
            }
            for(int i = 0 ; i < row; i++) {
                for(int j = 0 ; j < col ; j++) {
                    if(board[i][j]=='O') board[i][j] = 'X';
                    if(board[i][j]=='-') board[i][j] = 'O';
                }
            }
        }

        private void dfs(char[][] board, int i, int j) {
            if(i<0||i>=row||j<0||j>=row||board[i][j]!='O') return;
            board[i][j] = '-';
            dfs(board, i-1, j);
            dfs(board, i+1, j);
            dfs(board, i, j-1);
            dfs(board, i, j+1);
            return;
        }

    }
}
