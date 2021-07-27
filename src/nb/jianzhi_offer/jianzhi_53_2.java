package nb.jianzhi_offer;

public class jianzhi_53_2 {
}

//自己手写和答案一样
//跳出时，变量 i 和 j分别指向 “右子数组的首位元素” 和 “左子数组的末位元素” 。因此返回 i 即可。
class Solution {
    public int missingNumber(int[] nums) {
        int l=0,r=nums.length-1;
        int m;
        while(l<=r){
            m=(l+r)/2;
            if(nums[m]==m){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return l;
    }
}