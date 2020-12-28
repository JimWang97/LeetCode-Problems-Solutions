package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
212. 单词搜索 II
给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。

单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

 

示例 1：


输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
输出：["eat","oath"]
*/
public class S0212 {
    List<String> ans = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        Map<Character, List<String>> map = new HashMap<>();
        for(String word : words) {
            List ls = map.getOrDefault(word.charAt(0), new ArrayList<>());
            ls.add(word);
            map.put(word.charAt(0), ls);
        }
        Set<Character> keySet = map.keySet();
        int[][] visited = new int[board.length][board[0].length];
        for(int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], 0);
        }
        for(int i = 0;i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(keySet.contains(board[i][j])) {
                    visited[i][j]=1;
                    helper(board, visited, map.get(board[i][j]), i, j, Character.toString(board[i][j]));
                    visited[i][j]=0;
                }
            }
        }
        return ans;
    } 
    public void helper(char[][] board, int[][] visited, List<String> ls, int x, int y, String str){
        if(ls.contains(str)){
            if(!ans.contains(str))
                ans.add(str);
        }
        int i;
        for(i = 0;i < ls.size(); i++){
            if(ls.get(i).contains(str)) break;
        }
        if(i>=ls.size()) return;
        if(x-1>0 && visited[x-1][y]!=1) {
            visited[x-1][y] = 1;
            helper(board, visited, ls, x-1, y, str+board[x-1][y]);
            visited[x-1][y] = 0;
        }
        if(y-1>0 && visited[x][y-1] != 1) {
            visited[x][y-1] = 1;
            helper(board, visited, ls, x, y-1, str+board[x][y-1]);
            visited[x][y-1] = 0;
        }
        if(x+1<board.length && visited[x+1][y] != 1) {
            visited[x+1][y] = 1;
            helper(board, visited, ls, x+1, y, str+board[x+1][y]);
            visited[x+1][y] = 0;
        }
        if(y+1<board[0].length && visited[x][y+1] != 1) {
            visited[x][y+1] = 1;
            helper(board, visited, ls, x, y+1, str+board[x][y+1]);
            visited[x][y+1] = 0;
        }
    }
}