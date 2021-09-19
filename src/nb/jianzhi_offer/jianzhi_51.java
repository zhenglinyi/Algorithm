package nb.jianzhi_offer;

public class jianzhi_51 {
}
//归并排序
class Solution {
    int[] nums,tmp;
    public int reversePairs(int[] nums) {
        this.nums=nums;
        tmp=new int[nums.length];
        return mergeSort(0,nums.length-1);
    }
    private int mergeSort(int l,int r){
        //终止条件
        if(l>=r) return 0;
        //递归划分
        int m=(l+r)/2;
        int res=mergeSort(l,m)+mergeSort(m+1,r);
        //合并阶段
        int i=l,j=m+1;
        for (int k = l; k <=r ; k++) {
            tmp[k]=nums[k];//辅助数组
        }
        for (int k = l; k <=r ; k++) {
            if(i==m+1)
                nums[k]=tmp[j++];
            else if(j==r+1||tmp[i]<=tmp[j])
                nums[k]=tmp[i++];
            else{//tmp[i]>tmp[j]
                nums[k]=tmp[j++];
                res+=m-i+1;
            }
        }
        return res;
    }
}