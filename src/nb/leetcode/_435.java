package nb.leetcode;

import java.util.Arrays;

public class _435 {
}

//按右边界排序
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

//打气球一样，打气球需要几次说明有几个不重叠的区间，把不重叠的减出去就是移除的
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //注意这里，不使用Integer.compare可能会越界
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0], b[0]));
        //不行
        /*Arrays.sort(points,(a,b)-> {
            return (int)((long)a[0]-(long)b[0]);
        });*/

        int res=1;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]>=intervals[i-1][1]){
                res++;
            }else{
                //修改右边界
                intervals[i][1]=Math.min(intervals[i-1][1],intervals[i][1]);
            }
        }
        return intervals.length-res;
    }
}