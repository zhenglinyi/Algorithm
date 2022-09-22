package nb.leetcode;

import java.util.List;

public class _139 {
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                int wl=wordDict.get(j).length();
                if(i>=wl&&dp[i-wl]==true&& s.substring(i - wl, i).equals(wordDict.get(j))){
                    System.out.println();
                    dp[i]=true;
                }

            }
        }
        return dp[s.length()];
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for (int j = 1; j <=s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if(dp[i]==true&&wordDict.contains(s.substring(i,j)))
                    dp[j]=true;
            }
        }
        return dp[s.length()];
    }
}
