package offer;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 *
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 */
public class offer12 {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int x = 0; x < row; x++) {
            for(int y = 0; y < col; y++) {
                if(helper(board, visited, word, 0, x, y)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, boolean[][] visited, String word, int num, int x, int y) {
        if(num==word.length()){
            return true;
        }
        if(x<0||x>=board.length||y<0||y>=board[0].length||visited[x][y]) {
            return false;
        }
        if(board[x][y] == word.charAt(num)) {
            num++;
            visited[x][y] = true;
            boolean ans = helper(board,visited,word,num,x+1,y) | helper(board,visited,word,num,x-1,y) | helper(board,visited,word,num,x,y+1) | helper(board,visited,word,num,x,y-1);
            if(ans) {
                return true;
            }
            num--;
            visited[x][y]=false;
        }
        return false;
    }
}
