package competition.sweek246;

public class S2 {
    class Solution {
        public int numberOfRounds(String startTime, String finishTime) {
            int startHour = Integer.parseInt(startTime.substring(0,2));
            int finishHour = Integer.parseInt(finishTime.substring(0,2));
            int startMin = Integer.parseInt(startTime.substring(3,5));
            int finishMin = Integer.parseInt(finishTime.substring(3,5));
            int ans = 0;
            if(finishHour<startHour || (finishHour==startHour&&finishMin<startMin))
                ans = (finishHour+24-startHour)*4;
            else ans = (finishHour-startHour)*4;
            if(startMin>0) {
                if(startMin<=15) ans--;
                else if(startMin<=30) ans-=2;
                else if(startMin<=45) ans-=3;
                else ans-=4;
            }
            if(finishMin>0) {
                if(finishMin>=45) ans+=3;
                else if(finishMin>=30) ans+=2;
                else if(finishMin>=15) ans++;
            }
            return ans;
        }
    }
}
