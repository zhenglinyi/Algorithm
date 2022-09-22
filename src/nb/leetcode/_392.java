package nb.leetcode;

public class _392 {
}


class Solution {
    public boolean isSubsequence(String s, String t) {
        int[][] dp=new int[s.length()+1][t.length()+1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if(s.charAt(i)==t.charAt(j)){
                    dp[i+1][j+1]=dp[i][j]+1;
                }else {
//                    dp[i+1][j+1]=Math.max(dp[i+1][j],dp[i][j+1]);
                    //if (s[i - 1] != t[j - 1])，此时相当于t要删除元素，t如果把当前元素t[j - 1]删除，那么dp[i][j] 的数值就是 看s[i - 1]与 t[j - 2]的比较结果了，即：dp[i][j] = dp[i][j - 1];
                    //
                    dp[i+1][j+1]=dp[i+1][j];
                }
            }
        }
        return dp[s.length()][t.length()]==s.length()?true:false;
    }
}
