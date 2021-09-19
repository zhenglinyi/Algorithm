package nb.leetcode;

public class _34 {
    //方法 1：线性扫描
    /*public int[] searchRange(int[] nums, int target) {
        int[] targetRange={-1,-1};
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                targetRange[0]=i;
                break;
            }
        }
        if(targetRange[0]==-1){
            return targetRange;
        }
        for(int i=0;i<n;i++){
            if(nums[n-1-i]==target){
                targetRange[1]=n-1-i;
                break;
            }
        }
        return targetRange;

    }*/
    //2.二分查找
    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    /*private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        //寻找左边
        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length  || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        //找右边大于target的第一个节点，然后减一
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }*/
    public int binaryFind(int[] nums, int target,boolean left){
        int lo=0;
        int hi=nums.length;

        while(lo<hi){
            int mid=(lo+hi)/2;
            if(nums[mid]>target||(left&&nums[mid]==target)){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return lo;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange={-1,-1};
        int leftIndex=binaryFind(nums,target,true);
        if(leftIndex==nums.length||nums[leftIndex]!=target){
            return targetRange;
        }
        targetRange[0]=leftIndex;
        targetRange[1]=binaryFind(nums,target,false)-1;
        return targetRange;
    }




}

class Solution {
    int[] nums;
    int target;
    public int[] searchRange(int[] nums, int target) {
        int[] res={-1,-1};
        this.nums=nums;
        this.target=target;
        if(nums.length==0)
            return res;
        res[0]=left(0,nums.length-1);
        res[1]=right(0,nums.length-1);
        return res;
    }
    private int left(int l,int r){
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[m]==target){
                r=m-1;
            }else if(nums[m]>target){
                r=m-1;
            }else if(nums[m]<target){
                l=m+1;
            }
        }
        if(l>=nums.length||nums[l]!=target)
            return -1;
        return l;

    }
    private int right(int l,int r){
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[m]==target){
                l=m+1;
            }else if(nums[m]>target){
                r=m-1;
            }else if(nums[m]<target){
                l=m+1;
            }
        }
        if(r<0||nums[r]!=target)
            return -1;
        return r;

    }
}
