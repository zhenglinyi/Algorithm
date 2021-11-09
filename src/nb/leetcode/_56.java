package nb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _56 {
}



class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res=new ArrayList<>();
        Arrays.sort(intervals,(o1,o2)->Integer.compare(o1[0],o2[0]));
        int tmp=intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]>intervals[i-1][1]){
                res.add(new int[]{tmp,intervals[i-1][1]});
                tmp=intervals[i][0];
            }else{
                intervals[i][1]=Math.max(intervals[i][1],intervals[i-1][1]);
            }
        }
        res.add(new int[]{tmp,intervals[intervals.length-1][1]});
        return res.toArray(new int[res.size()][]);
    }


}