package solutions;

/**
 * 1725. 可以形成最大正方形的矩形数目
 * 给你一个数组 rectangles ，其中 rectangles[i] = [li, wi] 表示第 i 个矩形的长度为 li 、宽度为 wi 。
 *
 * 如果存在 k 同时满足 k <= li 和 k <= wi ，就可以将第 i 个矩形切成边长为 k 的正方形。例如，矩形 [4,6] 可以切成边长最大为 4 的正方形。
 *
 * 设 maxLen 为可以从矩形数组 rectangles 切分得到的 最大正方形 的边长。
 *
 * 返回可以切出边长为 maxLen 的正方形的矩形 数目 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：rectangles = [[5,8],[3,9],[5,12],[16,5]]
 * 输出：3
 * 解释：能从每个矩形中切出的最大正方形边长分别是 [5,3,5,5] 。
 * 最大正方形的边长为 5 ，可以由 3 个矩形切分得到。
 */
public class S1725 {
    public int countGoodRectangles(int[][] rectangles) {
        int max = 0;
        int ans = 1;
        for(int i = 0; i < rectangles.length; i++) {
            if(Math.min(rectangles[i][0],rectangles[i][1])==max) {
                ans++;
            } else if (Math.min(rectangles[i][0],rectangles[i][1])>max) {
                max = Math.min(rectangles[i][0],rectangles[i][1]);
                ans = 1;
            }
        }
        return max;
    }
}
