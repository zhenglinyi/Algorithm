package nb.leetcode;

import java.util.Arrays;

public class _1005 {
}

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        if(nums.length==1) return k%2==0?nums[0]:-nums[0];
        //先排序
        Arrays.sort(nums);
        int sum=0;
        int idx=0;
        for (int i = 0; i < nums.length; i++) {
            //把负的取成正的
            if(nums[i]<0&&k>0){
                nums[i]=-nums[i];
                k--;
            }else{
                break;
            }
        }
        //取最小的变换正负
        if(k>0){
            //再进行一次排序
            Arrays.sort(nums);
            nums[0]=k%2==0?nums[0]:-nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        return sum;

    }
}