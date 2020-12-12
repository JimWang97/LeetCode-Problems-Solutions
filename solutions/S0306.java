package solutions;

/**
 * 306. 累加数 累加数是一个字符串，组成它的数字可以形成累加序列。
 * 
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 * 
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 * 
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 * 
 * 示例 1:
 * 
 * 输入: "112358" 输出: true 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 +
 * 3 = 5, 3 + 5 = 8
 */
public class S0306 {

  public boolean isAdditiveNumber(String num) {
    return dfs(num, num.length(), 0, 0, 0, 0);
  }

  public boolean dfs(String num, int len, int idx, long sum, long pre, int k) {
    if (idx >= len) {
      return k > 2;
    }
    for (int i = idx; i < len; i++) {
      long cur = fetchCurValue(num, idx, i);
      if (cur < 0) {
        continue;
      }
      if (k >= 2 && cur != sum) {
        continue;
      }
      if (dfs(num, len, i + 1, pre + cur, cur, k + 1)) {
        return true;
      }
    }
    return false;
  }

  private long fetchCurValue(String num, int l, int r) {
    if (l < r && num.charAt(l) == '0') {
      return -1;
    }
    long res = 0;
    while (l <= r) {
      res = res * 10 + num.charAt(l++) - '0';
    }
    return res;
  }
}
