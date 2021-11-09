package nb.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _763 {
}


class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res=new ArrayList<>();
        int[] edge=new int[26];
        char[] chars=s.toCharArray();
        //统计每个字母最后的位置
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i]-'a']=i;
        }
        int idx=0;
        int last=0;
        //遍历找每一段的最后一个位置
        for (int i = 0; i < chars.length; i++) {
            idx=Math.max(idx,edge[chars[i]-'a']);
            //当前正好是最后一个
            if(i==idx){
                res.add(i-last+1);
                last=i+1;
            }
        }
        return res;
    }
}
