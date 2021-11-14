package nb.leetcode;

public class _123 {
}


class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][5];
        /*
         * 定义 5 种状态:
         * 0: 没有操作, 1: 第一次买入, 2: 第一次卖出, 3: 第二次买入, 4: 第二次卖出
         */
        dp[0][1]=-prices[0];
        dp[0][3]=-prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
            dp[i][2]=Math.max(dp[i-1][2],prices[i]+dp[i-1][1]);
            dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
            dp[i][4]=Math.max(dp[i-1][4],prices[i]+dp[i-1][3]);
        }
        return dp[prices.length-1][4];
    }
}

