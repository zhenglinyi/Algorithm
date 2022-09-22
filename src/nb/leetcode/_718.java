package nb.leetcode;

public class _718 {
}


class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        int res=0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i]==nums2[j]){
                    dp[i+1][j+1]=dp[i][j]+1;
                    res=Math.max(res,dp[i+1][j+1]);
                }

            }
        }
        return res;
    }
}

//滚动数组
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[] dp=new int[nums2.length];
        int res=0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = nums2.length; j >0 ; j--) {
                if(nums1[i]==nums2[j]){
                    dp[j]=dp[j-1]+1;
                    res=Math.max(res,dp[j]);
                }else{
                    dp[j]=0;
                }
            }
        }
        return res;

    }
}
