package nb.jianzhi_offer;

public class jianzhi_39 {
}

//摩尔投票法
class Solution {
    public int majorityElement(int[] nums) {
        int vote=0;//投票数
        int x=nums[0];
        for (int i = 0; i <nums.length; i++) {
            if(vote==0)
                x=nums[i];
            if(nums[i]==x)
                vote++;
            else
                vote--;
        }
        return x;
    }
}
