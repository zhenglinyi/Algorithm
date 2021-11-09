package nb.leetcode;

public class _343 {
}

class Solution {
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        dp[2]=1;
        for (int i = 3; i <=n; i++) {
            //< i-1保证最小取2
            for (int j = 1; j < i-1; j++) {
                //j*(i-j)代表把i拆分为j和i-j两个数相乘
                //j*dp[i-j]代表把i拆分成j和继续把(i-j)这个数拆分，取(i-j)拆分结果中的最大乘积与j相乘
                dp[i]=Math.max(dp[i],Math.max(j*(i-j),dp[i-j]*j));
            }
        }
        return dp[n];
    }
}
