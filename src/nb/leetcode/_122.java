package nb.leetcode;

public class _122 {
}
//贪心
class Solution {
    public int maxProfit(int[] prices) {
        int res=0;
        for (int i = 1; i < prices.length; i++) {
            res+=Math.max(prices[i]-prices[i-1],0);
        }
        return res;

    }
}

//动态规划
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]= Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[prices.length-1][1];
    }
}

//动态规划
class Solution {
    public int maxProfit(int[] prices) {
        int dp0=-prices[0];
        int dp1=0;
        for (int i = 1; i < prices.length; i++) {
            int tmp=dp0;
            dp0= Math.max(dp0,dp1-prices[i]);
            dp1=Math.max(dp1,tmp+prices[i]);
        }
        return dp1;
    }
}
