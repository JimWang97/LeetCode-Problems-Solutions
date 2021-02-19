package solutions;

/**
 * 1736. 替换隐藏数字得到的最晚时间
 * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 *
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 *
 * 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
 *
 *
 *
 * 示例 1：
 *
 * 输入：time = "2?:?0"
 * 输出："23:50"
 * 解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
 */
public class S1736 {
    public String maximumTime(String time) {
        StringBuilder result = new StringBuilder();

        char one = time.charAt(0);
        char two = time.charAt(1);
        char three = time.charAt(3);
        char four = time.charAt(4);

        // 当one等于'?'时
        if (one == '?') {
            // two等于'?'
            if (two == '?') {
                result.append('2').append('3').append(':');
                // two不等于'?'
            } else {
                // two < '4'
                if (two < '4') {
                    result.append('2').append(two).append(':');
                    // two >= '4'
                } else {
                    result.append('1').append(two).append(':');
                }
            }
            // one等于'2'
        } else if (one == '2'){
            // two等于'?'
            if (two == '?') {
                result.append(one).append('3').append(':');
                // two不等于'?'
            } else {
                result.append(one).append(two).append(':');
            }
            // one等于'0'或'1'
        } else {
            // two等于'?'
            if (two == '?') {
                result.append(one).append('9').append(':');
                // two不等于'?'
            } else {
                result.append(one).append(two).append(':');
            }
        }

        // 当three等于'?'时
        if (three == '?') {
            result.append('5');
        } else {
            result.append(three);
        }

        // 当four等于'?'时
        if (four == '?') {
            result.append('9');
        } else {
            result.append(four);
        }

        return result.toString();
    }
}
