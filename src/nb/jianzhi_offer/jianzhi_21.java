package nb.jianzhi_offer;

import java.time.temporal.Temporal;

public class jianzhi_21 {

}
//首尾指针
class Solution {
    public int[] exchange(int[] nums) {
        if(nums.length == 0)
            return nums;
        int left = 0;
        int right = nums.length - 1;
        while(left != right){
            if(nums[left] % 2 == 1){
                left++;
            }else if(nums[right] % 2 == 0){
                right--;
            }else{
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }
}
