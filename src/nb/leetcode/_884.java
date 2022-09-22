package nb.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _884 {
}

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String,Integer> freq=new HashMap<>();
        insert(s1,freq);
        insert(s2,freq);
        List<String> ans=new ArrayList<>();
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if(entry.getValue()==1){
                ans.add(entry.getKey());
            }
        }
        return ans.toArray(new String[ans.size()]);

    }
    public void insert(String s,Map<String,Integer> freq){
        String[] arr=s.split(" ");
        for (String word : arr) {
            freq.put(word,freq.getOrDefault(word,0)+1);
        }
    }

}
