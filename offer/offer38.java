package offer;

import java.util.*;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
public class offer38 {

    public String[] permutation(String s) {
        Set<String> res=new HashSet<>();
        char[] C=s.toCharArray();
        backtrack(0,C,res);
        String[] ans=new String[res.size()];
        int i=0;
        for(String str:res) ans[i++]=str;
        return ans;
    }
    private void backtrack(int index,char[] S,Set<String> res) {
        if(index==S.length-1) {//结束判断条件
            res.add(String.valueOf(S));
            return;
        }
        for(int i=index;i<S.length;i++) {//可选择方案
            swap(index,i,S);//做出选择
            backtrack(index+1, S, res);//进行下一步
            swap(index,i,S);//撤销选择
        }
    }
    private void swap(int i, int j,char[] C) {//数组元素的交换
        char temp=C[i];
        C[i]=C[j];
        C[j]=temp;
    }
}
