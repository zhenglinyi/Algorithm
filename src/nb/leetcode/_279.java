package nb.leetcode;

public class _279 {
}

class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i]=Integer.MAX_VALUE;
        }
        for (int i = 1; i <= Math.sqrt(n); i++) {
            for (int j = i*i; j <=n; j++) {
//                if(dp[j-i*i]!=Integer.MAX_VALUE)
                    dp[j]=Math.min(dp[j-i*i]+1,dp[j]);
            }
        }
        return dp[n];

    }
}
