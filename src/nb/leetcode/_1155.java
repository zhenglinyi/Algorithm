package nb.leetcode;

import java.util.Arrays;

public class _1155 {
}

class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[] dp=new int[k];
        Arrays.fill(dp,1);
        for (int i = 2; i <=n ; i++) {
            int[] tmp=new int[6*i-i+1];
            for (int j = 0; j <tmp.length ; j++) {
                for (int l = 0; l < 6; l++) {
                    tmp[j+l]+=dp[j];
                }
            }
            dp=tmp;
        }
        return dp[target-n];
    }
}
