package nb.leetcode;

import java.util.Arrays;

public class _516 {
}


class Solution {
    public int longestPalindromeSubseq(String s) {
        int len=s.length();
        int[][] dp=new int[len+1][len+1];
        for (int i = 1; i <=len; i++) {
            dp[i][i]=1;
        }
        for (int i = len-1; i > 0 ; i--) {
            for (int j =i+1; j <= len; j++) {
                if(s.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }

        }
        return dp[1][len];
    }
}