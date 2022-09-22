package nb.leetcode;

public class _26 {
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=nums[j]){
                nums[++j]=nums[i];
            }
        }
        return j+1;
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<2) return nums.length;
        int first;
        int last=0;
        for (first = 1; first < nums.length; first++) {
            if(nums[last]!=nums[first]){
                last++;
                nums[last]=nums[first];
            }
        }
        return last;
    }

}
