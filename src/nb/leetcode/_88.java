package nb.leetcode;

public class _88 {
}


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int fina=m+n-1;
        while(i>=0&&j>=0){
            if(nums1[i]>nums2[j]){
                nums1[fina]=nums1[i];
                i--;
            }else{
                nums1[fina]=nums2[j];
                j--;
            }
            fina--;

        }
        while(i>=0){
            nums1[fina]=nums1[i];
            fina--;
            i--;
        }
        while(j>=0){
            nums1[fina]=nums2[j];
            fina--;
            j--;
        }

    }
}