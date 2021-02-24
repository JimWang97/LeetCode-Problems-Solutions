package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 1253. 重构 2 行二进制矩阵
 * 给你一个 2 行 n 列的二进制数组：
 *
 * 矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是 0 就是 1。
 * 第 0 行的元素之和为 upper。
 * 第 1 行的元素之和为 lower。
 * 第 i 列（从 0 开始编号）的元素之和为 colsum[i]，colsum 是一个长度为 n 的整数数组。
 * 你需要利用 upper，lower 和 colsum 来重构这个矩阵，并以二维整数数组的形式返回它。
 *
 * 如果有多个不同的答案，那么任意一个都可以通过本题。
 *
 * 如果不存在符合要求的答案，就请返回一个空的二维数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：upper = 2, lower = 1, colsum = [1,1,1]
 * 输出：[[1,1,0],[0,0,1]]
 * 解释：[[1,0,1],[0,1,0]] 和 [[0,1,1],[1,0,0]] 也是正确答案。
 */
public class S1253 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> up = new ArrayList<>();
        List<Integer> low = new ArrayList<>();

        for(int i = 0; i < colsum.length; i++) {
            if(colsum[i]==2) {
                up.add(1);
                low.add(1);
                upper--;
                lower--;
            } else if(colsum[i]==0) {
                up.add(0);
                low.add(0);
            } else {

                if(upper>lower) {
                    up.add(1);
                    low.add(0);
                    upper--;
                } else {
                    up.add(0);
                    low.add(1);
                    lower--;
                }
            }
        }
        if(upper!=0||lower!=0) {
            return ls;
        }
        ls.add(up);
        ls.add(low);
        return ls;
    }
}
