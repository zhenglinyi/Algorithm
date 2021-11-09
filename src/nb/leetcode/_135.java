package nb.leetcode;

import javax.swing.plaf.metal.MetalIconFactory;

public class _135 {
}


class Solution {
    public int candy(int[] ratings) {
        int[] res=new int[ratings.length];
        for (int i = 0; i < res.length; i++) {
            res[i]=1;
        }
        for (int i = 1; i < res.length; i++) {
            if(ratings[i]>ratings[i-1]){
                res[i]=res[i-1]+1;
            }
        }
        for (int i = res.length-2; i >=0 ; i--) {
            if(ratings[i]>ratings[i+1]){
                //注意这里，可能从前往后就已经满足了条件
                res[i]=Math.max(res[i],res[i+1]+1);
            }
        }
        int sum=0;
        for (int i = 0; i < res.length; i++) {
            sum+=res[i];
        }
        return sum;

    }
}