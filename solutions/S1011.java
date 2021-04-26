package solutions;

/**
 * 1011. 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * <p>
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 */
public class S1011 {
    class Solution {
        public int shipWithinDays(int[] weights, int D) {
            int sum = 0, max = -1;
            for (int i = 0; i < weights.length; i++) {
                sum += weights[i];
                max = Math.max(max, weights[i]);
            }
            int lo = max, hi = sum;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                int tmp = 0, day = 1;
                for(int weight : weights) {
                    tmp += weight;
                    if(tmp > mid) {
                        day++;
                        tmp = weight;
                    }
                }

                if(day>D) {
                    lo = mid+1;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }
    }
}
