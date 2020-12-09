package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原IP地址 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
 * 和 "192.168@1.1" 是 无效的 IP 地址。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "25525511135" 输出：["255.255.11.135","255.255.111.35"]
 */
public class S0093 {
    List<String> ans;
    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        helper(0, 0, s, new String());
        return ans;
    }

    public void helper(int start, int num, String s, String curS){
        if(start==s.length()||num==4){
            if(num==4&&start==s.length())
                ans.add((String) curS.subSequence(0, curS.length() - 1));
            return;
        }
        if(s.charAt(start)=='0') {
            helper(start+1,num+1, s, new String(curS+"0."));
            return;
        }
        for(int i = 0; i < 3; i++){
            if(start+i+1>s.length()) break;
            String temp = s.substring(start, start+i+1);
            if(Integer.parseInt(temp)<=255){
                helper(start+i+1,num+1, s, new String(curS+temp+"."));
            }
        }
    }
}