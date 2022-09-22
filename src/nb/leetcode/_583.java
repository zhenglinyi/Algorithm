package nb.leetcode;

public class _583 {
}


class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i < word1.length(); i++) {
            dp[i+1][0]=i+1;
        }
        for (int i = 0; i < word2.length(); i++) {
            dp[0][i+1]=i+1;
        }
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i+1][j+1]=dp[i][j];
                }else{
                    dp[i+1][j+1]=Math.min(Math.min(dp[i][j+1]+1,dp[i+1][j]+1),dp[i][j]+2);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
//最长公共子序列，然后两个字符串总长度减去二倍公共子序列长度
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i+1][j+1]=dp[i][j]+1;
                }else {
                    dp[i+1][j+1]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return word1.length()+word2.length()-2*dp[word1.length()][word2.length()];
    }
}