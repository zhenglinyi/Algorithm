package nb.leetcode;

public class _283 {
    public void moveZeroes(int[] nums) {
        int n= nums.length;
        int left=0;
        int right=0;
        while(right<n){
            if(nums[right]!=0){
                swap(nums,left,right);
                left++;
            }
            right++;
        }
    }
    public void swap(int[] nums,int left,int right){
        nums[right]=nums[right]+nums[left];
        nums[left]=nums[right]-nums[left];
        nums[right]=nums[right]-nums[left];
    }

    public static void main(String[] args) {
        //神奇的交换代码
        int A=1;
        int B=1;
        B=B+A;
        A=B-A;
        B=B-A;
        System.out.println(A);
        System.out.println(B);
    }
}
