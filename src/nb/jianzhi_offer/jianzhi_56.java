package nb.jianzhi_offer;

public class jianzhi_56 {
}



class Solution {
    public int[] singleNumbers(int[] nums) {
        int x=0,y=0,m=1,n=0;
        for (int num : nums) {
            n^=num;//1.遍历异或 相同的两个数异或为0
        }
        while((n&m)==0)
            m<<=1;//2.循环左移，计算m   第一位二进制不相同的位
        for (int num : nums) {//3.遍历nums分组
            if((num&m)!=0)// 4. 当 num & m != 0
                x^=num;
            else// 4. 当 num & m == 0
                y^=num;
        }
        return new int[]{x,y};// 5. 返回出现一次的数字
    }
}