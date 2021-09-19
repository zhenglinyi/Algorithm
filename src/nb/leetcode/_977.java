package nb.leetcode;

public class _977 {
}
//由于前面可能是负数，所以前面一个指针，后面一个指针，比较前面后面的平方谁更大
class Solution {
    public int[] sortedSquares(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int[] res=new int[nums.length];
        for (int i = res.length-1; i >=0 ; i--) {
            if(nums[l]*nums[l]<nums[r]*nums[r]){
                res[i]=nums[r]*nums[r];
                r--;
            }else{
                res[i]=nums[l]*nums[l];
                l++;
            }
        }
        return res;
    }
}
