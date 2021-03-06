package offer;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 *
 * 当作不能用乘法来做
 */
public class offer64a {
    public int sumNums(int n) {
        // (首项+末项)*项数/2
        int ans = 0, A = n, B = n+1;
        for(;B>0;B>>=1) {
            if((B&1)==1){
                ans += A;
            }
            A<<=1;
        }
        return ans>>1;
    }
}
