package nb.leetcode;

public class _518 {
}

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        //完全背包
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <=amount ; j++) {
                //组合问题的dp写法
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <=amount; j++) {
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
