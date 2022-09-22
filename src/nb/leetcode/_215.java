package nb.leetcode;

import java.util.PriorityQueue;
import java.util.Random;

public class _215 {
}

class Solution
{
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        for (int num : nums) {
            maxHeap.add(num);
        }
        for (int i = 0; i < k-1; i++) {
            maxHeap.remove();
        }
        return maxHeap.peek();
    }
}
//快排
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        int target=n-k;
        int start=0;
        int end=nums.length-1;
        int p=getP(nums,start,end);
        while(p!=target){
            if(p<target){
                start=p+1;
            }else{
                end=p-1;
            }
            p=getP(nums,start,end);
        }
        return nums[p];


    }

    int getP(int[] nums,int start,int end){
        int random=new Random().nextInt(end-start+1)+start;
        swap(nums,random,end);
        int index=start-1;
        for(int i=start;i<end;i++){
            if(nums[i]<nums[end]){
                swap(nums,i,++index);
            }
        }
        swap(nums,end,++index);
        return index;

    }

    void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
