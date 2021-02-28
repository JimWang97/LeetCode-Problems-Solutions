package solutions;

/**
 * 767. 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 *
 * 找出频率最高的，把它放在偶数位。放完后，从那个位置继续放别的字母，也是中间隔一个。
 * 到了res.length后，把index设为1，开始填充奇数位
 */
public class S0767a {
    public String reorganizeString(String S) {
        char[] alphabetArr = S.toCharArray();
        int[] alphabetCount = new int[26];
        int len = S.length();
        for(int i = 0; i < len; i++) {
            alphabetCount[alphabetArr[i] - 'a']++;
        }
        int max = 0, alphabet = 0, threshold = (len+1)>>1;
        for(int i = 0; i < alphabetCount.length; i++) {
            if(alphabetCount[i] > max) {
                alphabet = i;
                max = alphabetCount[i];
                if(max>threshold) {
                    return "";
                }
            }
        }
        // 把最常见的字母放在的坐标为偶数的地方
        char[] res = new char[len];
        int index = 0;
        while(alphabetCount[alphabet]-->0) {
            res[index] = (char) (alphabet+'a');
            index+=2;
        }

        for(int i = 0; i < alphabetCount.length; i++) {
            while(alphabetCount[i]-->0) {
                if(index >= res.length) {
                    index = 1;
                }
                res[index] = (char)(i+'a');
                index +=2;
            }
        }
        return new String(res);
    }
}
