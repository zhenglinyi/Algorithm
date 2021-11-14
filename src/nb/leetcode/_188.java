package nb.leetcode;

public class _188 {
}
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;
        //奇数是第几次买入状态
        //偶数是第几次卖出状态
        int[][] dp=new int[prices.length][2*k+1];
        //初始化，第一天各次买入状态
        for (int i = 1; i < 2*k+1; i+=2) {
            dp[0][i]=-prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < 2*k+1; j+=2) {
                //买入状态
                dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1]-prices[i]);
                //卖出状态
                dp[i][j+1]=Math.max(dp[i-1][j+1],dp[i-1][j]+prices[i]);
            }
        }
        return dp[prices.length-1][2*k];
    }
}



// 版本一: 三维 dp数组
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;

        // [天数][交易次数][是否持有股票]
        int len = prices.length;
        int[][][] dp = new int[len][k + 1][2];

        // dp数组初始化
        // 初始化所有的交易次数是为确保 最后结果是最多 k 次买卖的最大利润
        for (int i = 0; i <= k; i++) {
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                // dp方程, 0表示不持有/卖出, 1表示持有/买入
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][k][0];
    }
}

// 版本二: 二维 dp数组
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;

        // [天数][股票状态]
        // 股票状态: 奇数表示第 k 次交易持有/买入, 偶数表示第 k 次交易不持有/卖出, 0 表示没有操作
        int len = prices.length;
        int[][] dp = new int[len][k*2 + 1];

        // dp数组的初始化, 与版本一同理
        for (int i = 1; i < k*2; i += 2) {
            dp[0][i] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < k*2 - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[len - 1][k*2];
    }
}

//版本三：一维 dp数组
class Solution {
    public int maxProfit(int k, int[] prices) {
        //在版本二的基础上，由于我们只关心前一天的股票买入情况，所以只存储前一天的股票买入情况
        if(prices.length==0)return 0;
        int[] dp=new int[2*k+1];
        for (int i = 1; i <2*k ; i+=2) {
            dp[i]=-prices[0];
        }
        for (int i = 0; i <prices.length ; i++) {
            for (int j = 1; j <2*k ; j+=2) {
                dp[j]=Math.max(dp[j],dp[j-1]-prices[i]);
                dp[j+1]=Math.max(dp[j+1],dp[j]+prices[i]);
            }
        }
        return dp[2*k];
    }
}
