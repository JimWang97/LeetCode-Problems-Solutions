package solutions;

/**
 * 357. Count Numbers with Unique Digits
Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:

Input: 2
Output: 91 
Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, 
             excluding 11,22,33,44,55,66,77,88,99
 */
public class S0357 {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        int ans = 10;
        int d = 9;
        for(int i = 1; i < n; i++){
            d = d*(10-i);
            ans+=d;
        }
        return ans;
    }
}