package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 还没做出来
 * 1467. Probability of a Two Boxes Having The Same Number of Distinct Balls
 * Given 2n balls of k distinct colors. You will be given an integer array balls
 * of size k where balls[i] is the number of balls of color i.
 * 
 * All the balls will be shuffled uniformly at random, then we will distribute
 * the first n balls to the first box and the remaining n balls to the other box
 * (Please read the explanation of the second example carefully).
 * 
 * Please note that the two boxes are considered different. For example, if we
 * have two balls of colors a and b, and two boxes [] and (), then the
 * distribution [a] (b) is considered different than the distribution [b] (a)
 * (Please read the explanation of the first example carefully).
 * 
 * We want to calculate the probability that the two boxes have the same number
 * of distinct balls.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: balls = [1,1] Output: 1.00000 Explanation: Only 2 ways to divide the
 * balls equally: - A ball of color 1 to box 1 and a ball of color 2 to box 2 -
 * A ball of color 2 to box 1 and a ball of color 1 to box 2 In both ways, the
 * number of distinct colors in each box is equal. The probability is 2/2 = 1
 */
public class S1469 {

    int n;
    List<List<Integer>> lset = new ArrayList<>();
    public double getProbability(int[] balls) {
        if(balls.length==0) return 0;
        double ans = 0;
        List<Integer> ls = new ArrayList<>();
        for(int i = 0; i < balls.length; i++){
            for(int j = 0; j < balls[i]; j++){
                ls.add(i+1);
            }
        }
        int sz = ls.size();
        n = sz/2;
        helper(ls, 0, new ArrayList<Integer>());

        for(List<Integer> tls : lset){
            List<Integer> ttls = new ArrayList<>(ls);
            for(Integer t : tls){
                int ind = ttls.indexOf(t);
                if(ind!=-1){
                    ttls.remove(ind);
                }
            }
            Set<Integer> s1 = new HashSet<>(ttls);
            Set<Integer> s2 = new HashSet<>(tls);
            if(s1.size()==s2.size()) ans++;
        }
        return ans*1.0/lset.size();
    }

    public void helper(List<Integer> ls, int count, ArrayList<Integer> op){
        if(op.size()==n){
            lset.add(new ArrayList<>(op));
        }
        for(int i = 0; i < ls.size(); i++){
            int tmp = ls.get(i);
            op.add(tmp);
            ls.remove(i);
            helper(ls, count+1, op);
            op.remove(count);
            ls.add(i, tmp);
        }
    }

    public static void main(String[] args){
        int[] i = new int[]{2,1,1};
        S1469 s = new S1469();
        s.getProbability(i);
    }
}