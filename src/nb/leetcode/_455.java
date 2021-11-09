package nb.leetcode;

import java.util.Arrays;

public class _455 {
}

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int res=0;
        int index=0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0; i <s.length; i++) {
            if(index<g.length&&g[index]<=s[i]){
                index++;
                res++;
            }
        }
        return res;
    }
}
