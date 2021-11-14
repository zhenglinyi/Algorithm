package nb.leetcode;

import java.util.List;

public class _139 {
}

//class Solution {
//    public boolean wordBreak(String s, List<String> wordDict) {
//        boolean[] dp=new boolean[s.length()+1];
//        dp[0]=true;
//        for (int j = 1; j <=s.length(); j++) {
//            for (int i = 0; i < wordDict.size(); i++) {
//                int wl=wordDict.get(i).length();
//                if(j>=wl&&dp[j-wl]==true&&s.substring(j-wl,j)==wordDict.get(i))
//                    dp[j]=true;
//            }
//        }
//        return dp[s.length()];
//    }
//}

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
