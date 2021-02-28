package solutions;

/**
 * 1111. 有效括号的嵌套深度
 * 有效括号字符串 定义：对于每个左括号，都能找到与之对应的右括号，反之亦然。详情参见题末「有效括号字符串」部分。
 *
 * 嵌套深度 depth 定义：即有效括号字符串嵌套的层数，depth(A) 表示有效括号字符串 A 的嵌套深度。详情参见题末「嵌套深度」部分。
 *
 * 有效括号字符串类型与对应的嵌套深度计算方法如下图所示：
 *
 *
 *
 *
 *
 * 给你一个「有效括号字符串」 seq，请你将其分成两个不相交的有效括号字符串，A 和 B，并使这两个字符串的深度最小。
 *
 * 不相交：每个 seq[i] 只能分给 A 和 B 二者中的一个，不能既属于 A 也属于 B 。
 * A 或 B 中的元素在原字符串中可以不连续。
 * A.length + B.length = seq.length
 * 深度最小：max(depth(A), depth(B)) 的可能取值最小。
 * 划分方案用一个长度为 seq.length 的答案数组 answer 表示，编码规则如下：
 *
 * answer[i] = 0，seq[i] 分给 A 。
 * answer[i] = 1，seq[i] 分给 B 。
 * 如果存在多个满足要求的答案，只需返回其中任意 一个 即可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：seq = "(()())"
 * 输出：[0,1,1,1,1,0]
 *
 * flagA和flagB来标记A和B已有的左括号数。
 * 每次左括号都分配给flagA比较小的值。而右括号分配给flag比较大的
 */
public class S1111 {
    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        int[] ans = new int [len];
        // 表示有左括号的个数
        int flagA = 0, flagB = 0;
        for(int i = 0; i < len; i++) {
            char c = seq.charAt(i);
            if(c=='(') {
                if(flagA <= flagB) {
                    ans[i] = 0;
                    flagA++;
                } else {
                    ans[i] = 1;
                    flagB++;
                }
            } else if(c==')') {
                if(flagA<=flagB) {
                    ans[i] = 1;
                    flagB--;
                } else {
                    ans[i] = 0;
                    flagA--;
                }
            }
        }
        return ans;
    }
}
