package nb.leetcode;

import java.util.Arrays;

public class _322 {
}


class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp=new int[amount+1];
        for (int i = 1; i <=amount ; i++) {
            dp[i]=Integer.MAX_VALUE;
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <=amount ; j++) {
                //满足这个条件才可以往背包里装
                if(dp[j-coins[i]]!=Integer.MAX_VALUE)
                    dp[j]=Math.min(dp[j-coins[i]]+1,dp[j]);
            }
        }
        return (dp[amount]==Integer.MAX_VALUE)?-1:dp[amount];
    }
}

