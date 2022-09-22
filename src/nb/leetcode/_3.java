package nb.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _3 {
}


class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> need=new HashMap<>();
        Map<Character,Integer> window=new HashMap<>();
        int left=0;
        int right=0;

        int res=0;
        while(right<s.length()){
            char c=s.charAt(right);
            right++;
            window.put(c,window.getOrDefault(c,0)+1);
            while(window.get(c)>1){
                //在这里判断不对
//                if(res<right-left-1){
//                    res=right-left-1;
//                }
                char d=s.charAt(left);
                left++;
                window.put(d,window.get(d)-1);
            }
            res=Math.max(res,right-left);
        }
        return res;
    }
}