package nb.leetcode;

import java.util.Arrays;

public class _452 {
}

//根据有边界划分，有重叠就需要一根箭
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        //注意这里，不使用Integer.compare可能会越界
        Arrays.sort(points,(a,b)-> Integer.compare(a[0], b[0]));
        //不行
        /*Arrays.sort(points,(a,b)-> {
            return (int)((long)a[0]-(long)b[0]);
        });*/

        int res=1;
        for (int i = 1; i < points.length; i++) {
            if(points[i][0]>points[i-1][1]){
                res++;
            }else{
                //修改右边界
                points[i][1]=Math.min(points[i-1][1],points[i][1]);
            }
        }
        return res;
    }
}