package nb.leetcode;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class _912 {
}
//快速排序
public class Solution {

    public int[] sortArray(int[] nums) {
        randomizedQuiksort(nums,0,nums.length-1);
        return nums;
    }
    void randomizedQuiksort(int[] nums,int l,int r){
        if(l<r){
            int pos=randomizedPartition(nums,l,r);
            randomizedQuiksort(nums,l,pos-1);
            randomizedQuiksort(nums,pos+1,r);
        }
    }
    int randomizedPartition(int[] nums,int l,int r){
        //随机生成一个基准
        int rand=new Random().nextInt(r-l+1)+l;
        //基准数字和最右边的数字交换
        swap(nums,r,rand);
        //基准数字
        int pivot=nums[r];
        int i=l-1;
        for (int j = l; j <= r-1 ; j++) {
            if(nums[j]<=pivot){
                i++;
                //小于基准的放前面
                swap(nums,i,j);
            }
        }
        //把基准交换回去
        swap(nums,i+1,r);
        return i+1;

    }
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

//堆排序
class Solution {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }
    void heapSort(int[] nums){
        int len= nums.length;
        heapify(nums,len);
        swap(nums,0,len-1);
        for (int i = len-1; i >=1 ; i--) {
            siftDown(nums,0,i);
            swap(nums,0,i-1);
        }
    }
    void heapify(int[] nums,int len){
        for (int i = len/2-1; i >=0 ; i--) {
            siftDown(nums,i,len);
        }
    }
    void siftDown(int[] nums,int i,int len){
        //左右节点
        int left=i*2+1;
        int right=i*2+2;
        int maxIndex=i;
        //找出左右最大的
        if(left<len&&nums[maxIndex]<nums[left]){
            maxIndex=left;
        }
        if(right<len&&nums[maxIndex]<nums[right]){
            maxIndex=right;
        }
        if(maxIndex!=i){
            swap(nums,maxIndex,i);
            siftDown(nums,maxIndex,len);
        }
    }
    void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}

public class Solution {

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        // 将数组整理成堆
        heapify(nums);

        // 循环不变量：区间 [0, i] 堆有序
        for (int i = len - 1; i >= 1; ) {
            // 把堆顶元素（当前最大）交换到数组末尾
            swap(nums, 0, i);
            // 逐步减少堆有序的部分
            i--;
            // 下标 0 位置下沉操作，使得区间 [0, i] 堆有序
            siftDown(nums, 0, i);
        }
        return nums;
    }

    /**
     * 将数组整理成堆（堆有序）
     *
     * @param nums
     */
    private void heapify(int[] nums) {
        int len = nums.length;
        // 只需要从 i = (len - 1) / 2 这个位置开始逐层下移
        for (int i = (len - 1) / 2; i >= 0; i--) {
            siftDown(nums, i, len - 1);
        }
    }

    /**
     * @param nums
     * @param k    当前下沉元素的下标
     * @param end  [0, end] 是 nums 的有效部分
     */
    private void siftDown(int[] nums, int k, int end) {
        while (2 * k + 1 <= end) {
            int j = 2 * k + 1;
            if (j + 1 <= end && nums[j + 1] > nums[j]) {
                j++;
            }
            if (nums[j] > nums[k]) {
                swap(nums, j, k);
            } else {
                break;
            }
            k = j;
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}



//快速排序
public class Solution {

    public int[] sortArray(int[] nums) {
        quikSort(nums,0,nums.length-1);
        return nums;
    }
    void quikSort(int[] nums,int left,int right){
//        if(left>right) return;
        if(left<right){
            int poivt=partition(nums,left,right);
            quikSort(nums,left,poivt-1);
            quikSort(nums,poivt+1,right);
        }

    }
    int partition(int[] nums,int left,int right){

        int rand=new Random().nextInt(right-left+1)+left;
        swap(nums,rand,right);
        int i=left;
        int j=right-1;
        while(i<=j){
            if(nums[i]>nums[right]){
                swap(nums,i,j);
                j--;
            }
            else{
                i++;
            }
        }
        swap(nums,i,right);
        return i;
    }
    void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}

//归并排序
public class Solution {

    public int[] sortArray(int[] nums) {
        int length=nums.length;
        if(length<2){
            return nums;
        }
        int mid=length/2;
        int[] left=Arrays.copyOfRange(nums,0,mid);
        int[] right=Arrays.copyOfRange(nums,mid,nums.length);
        left=sortArray(left);
        right=sortArray(right);
        return merge(left,right);
    }
    int[] merge(int[] left,int[] right){
        int[] res=new int[left.length+right.length];
        for (int index = 0,i=0,j=0; index <res.length ; index++) {
            if(i>=left.length){
                res[index]=right[j++];
            }else if(j>=right.length){
                res[index]=left[i++];
            }else if(left[i]>right[j]){
                res[index]=right[j++];
            }else{
                res[index]=left[i++];
            }
        }
        return res;
    }
}
//选择排序
public class Solution {
    AtomicInteger

    // 选择排序：每一轮选择最小元素交换到未排定部分的开头

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        // 循环不变量：[0, i) 有序，且该区间里所有元素就是最终排定的样子
        for (int i = 0; i < len - 1; i++) {
            // 选择区间 [i, len - 1] 里最小的元素的索引，交换到下标 i
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        Solution solution = new Solution();
        int[] res = solution.sortArray(nums);
        System.out.println(Arrays.toString(res));
    }
}

//插入排序
public class Solution {

    // 插入排序：稳定排序，在接近有序的情况下，表现优异

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        // 循环不变量：将 nums[i] 插入到区间 [0, i) 使之成为有序数组
        for (int i = 1; i < len; i++) {
            // 先暂存这个元素，然后之前元素逐个后移，留出空位
            int temp = nums[i];
            int j = i;
            // 注意边界 j > 0
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }
}

