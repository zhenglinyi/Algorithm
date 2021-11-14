package nb.leetcode;

public class _309 {
}

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        //0持有1以前卖了2今天卖了3冷冻期
        int[][] dp=new int[prices.length][4];
        dp[0][0]=-prices[0];
        for (int i = 1; i <prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],Math.max(dp[i-1][3],dp[i-1][1])-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][3]);
            dp[i][2]=dp[i-1][0]+prices[i];
            dp[i][3]=dp[i-1][2];
        }
        return Math.max(Math.max(dp[prices.length-1][1],dp[prices.length-1][2]),dp[prices.length-1][3]);
    }
}
