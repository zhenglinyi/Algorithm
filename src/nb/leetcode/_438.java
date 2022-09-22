package nb.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _438 {
}


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> need=new HashMap<>();
        Map<Character,Integer> window=new HashMap<>();
        List<Integer> resList=new LinkedList<>();
        for (int i = 0; i < p.length(); i++) {
            char tmp=p.charAt(i);
            need.put(tmp,need.getOrDefault(tmp,0)+1);
        }
        int left=0;
        int right=0;

        int valid=0;
        while(right<s.length()){
            char c=s.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(need.get(c).equals(window.get(c))){
                    valid++;
                }
            }
            while(right-left>=p.length()){
                if(valid==need.size()){
                    resList.add(left);
                }
                char d=s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d))){
                        valid--;
                    }
                    window.put(d,window.get(d)-1);
                }

            }

        }
        return resList;

    }
}
