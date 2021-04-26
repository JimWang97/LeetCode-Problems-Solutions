package solutions;

/**
 * 1496. 判断路径是否相交
 * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
 *
 * 机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
 *
 * 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：path = "NES"
 * 输出：false
 * 解释：该路径没有在任何位置相交。
 */
public class S1496 {
    class Solution {
        public boolean isPathCrossing(String path) {
            if(path.contains("NS")||path.contains("SN")||path.contains("EW")||path.contains("WE"))
                return true;
            char[] pat = path.toCharArray();
            int N = 0;
            int S = 0;
            int E = 0;
            int W = 0;
            for(int i=0; i<pat.length; i++){
                switch(pat[i]){
                    case 'N':
                        N++;
                        break;
                    case 'S':
                        S++;
                        break;
                    case 'E':
                        E++;
                        break;
                    case 'W':
                        W++;
                        break;
                }
                if(N==S && E==W)
                    return true;
            }
            return false;
        }
    }
}
