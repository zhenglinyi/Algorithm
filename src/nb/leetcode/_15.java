package nb.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _15 {
}
//先排序再双指针
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i>0&&nums[i]==nums[i-1])
                continue;
            //必大于零了
            if(nums[i]>0) return res;
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right&&nums[left]==nums[left+1])
                        left++;
                    left++;
                    while(left<right&&nums[right]==nums[right-1])
                        right--;
                    right--;
                }else if(nums[i]+nums[left]+nums[right]<0){
//                    while(left<right&&nums[left]==nums[left+1])
//                        left++;
                    left++;
                }else{
//                    while(left<right&&nums[right]==nums[right-1])
//                        right--;
                    right--;
                }
            }
        }
        return res;
    }
}
