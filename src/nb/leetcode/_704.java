package nb.leetcode;

public class _704 {
}
class Solution {
    int[] nums;
    int target;
    public int search(int[] nums, int target) {
        this.nums=nums;
        this.target=target;
        return recur(0,nums.length-1);
    }
    public int recur(int l,int r){
        if(l>r) return -1;
        int m=(l+r)/2;
        if(nums[m]==target)
            return m;
        else if(nums[m]<target)
            return recur(m+1,r);
        else
            return recur(l,m-1);
    }
}



class Solution {

    public int search(int[] nums, int target) {
        int len=nums.length;
        int l=0;
        int r=len-1;
        while(l<=r){
            int m=(l+r)/2;
            if(nums[m]==target){
                return m;
            }else if(nums[m]>target){
                r=m-1;
            }else if(nums[m]<target){
                l=m+1;
            }
        }
        return -1;
    }

    }