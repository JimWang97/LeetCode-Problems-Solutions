package competition.sweek246;

public class S1 {
    class Solution {
        public String largestOddNumber(String num) {
            int ans = 0;
            String tmp = "13579";
            for(int i = 0; i < num.length(); i++) {
                if(tmp.indexOf(num.charAt(i))!=0) ans = i+1;
            }
            return num.substring(0,ans);
        }
    }
}
