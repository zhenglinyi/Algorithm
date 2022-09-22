package nb.leetcode;

import java.util.Arrays;

public class _1288 {
}

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(o1, o2) -> {
            if(o1[0]==o2[0])
                return o2[1]-o1[1];
            return o1[0]-o2[0];
        });
        int left=intervals[0][0];
        int right=intervals[0][1];
        //覆盖的区间总数
        int res=0;
        for (int i = 1; i < intervals.length; i++) {
            //覆盖
            if(left<=intervals[i][0]&&right>=intervals[i][1]){
                res++;
            }
            //有交集，可以合并为一个大区间
            if(intervals[i][0]<=right&&intervals[i][1]>=right){
                right=intervals[i][1];
            }
            //无交集
            if(intervals[i][0]>=right){
                left=intervals[i][0];
                right=intervals[i][1];
            }
        }
        return intervals.length-res;
    }
}
