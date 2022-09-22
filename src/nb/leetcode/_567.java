package nb.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _567 {
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> need=new HashMap();
        Map<Character,Integer> window=new HashMap();
        for (int i = 0; i < s1.length(); i++) {
            char tmp=s1.charAt(i);
            need.put(tmp,need.getOrDefault(tmp,0)+1);
        }
        int left=0;
        int right=0;

        int valid=0;
        while(right<s2.length()){
            char c=s2.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(need.get(c).equals(window.get(c)))
                    valid++;
            }

            while(right-left>=s1.length()){
                if(valid==need.size())
                    return true;
                char d=s2.charAt(left);
                left++;
                if(need.containsKey(d)){
                    //里面的顺序不能颠倒
                    if(need.get(d).equals(window.get(d)))
                        valid--;
                    window.put(d,window.get(d)-1);

                }
            }

        }
        return false;
    }
}
