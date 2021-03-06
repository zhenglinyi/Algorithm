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
