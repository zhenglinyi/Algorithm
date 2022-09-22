package nb.leetcode;

public class _714 {
}

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int res=0;
        int buy=prices[0]+fee;
        for (int i = 1; i < prices.length; i++) {
            //找到买入时机
            if(prices[i]+fee<buy){
                buy=prices[i]+fee;
            }

            //持有时机加利润
            if(prices[i]>buy){
                res+=prices[i]-buy;
                //这里就不加手续费了，手续费只需要减一次
                buy=prices[i];
            }

        }
        return res;
    }
}

//动态规划
class Solution {
    public int maxProfit(int[] prices,int fee) {
        int[][] dp=new int[prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]= Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]-fee);
        }
        return dp[prices.length-1][1];
    }
}

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy=prices[0];
        int res=0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]<buy){
                buy = prices[i];
            }
            if(prices[i]-buy>fee){
                res+=prices[i]-buy-fee;
                buy=prices[i]-fee;
            }
        }
        return res;
    }
}
