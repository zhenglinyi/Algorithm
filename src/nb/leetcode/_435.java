package nb.leetcode;

import java.util.Arrays;

public class _435 {
}


class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length<2) return 0;
        Arrays.sort(intervals,(o1,o2)->{
            if(o1[1]!=o2[1]){
                return Integer.compare(o1[1],o2[1]);
            }else {
                return Integer.compare(o1[0],o2[0]);
            }
        });
        int count=1;
        int curEdge=intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(curEdge<=intervals[i][0]){
                count++;
                curEdge=intervals[i][1];
            }
        }
        return intervals.length-count;
    }
}