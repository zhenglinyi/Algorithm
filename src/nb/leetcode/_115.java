package nb.leetcode;

public class _115 {
}

class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp=new int[s.length()+1][t.length()+1];
        //s中随便删除，匹配空序列，肯定有一个
        for (int i = 0; i < s.length(); i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if(s.charAt(i)==t.charAt(j)){
                    //用i还是不用i
                    dp[i+1][j+1]=dp[i][j]+dp[i][j+1];
                }else{
                    //只能不用
                    dp[i+1][j+1]=dp[i][j+1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
