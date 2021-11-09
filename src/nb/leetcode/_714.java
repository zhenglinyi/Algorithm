package nb.leetcode;

public class _714 {
}

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int res=0;
        int buy=prices[0]+fee;
        for (int i = 1; i < prices.length; i++) {
            //找到买入时机
            if(prices[i]+fee<buy){
                buy=prices[i]+fee;
            }
            //持有时机加利润
            if(prices[i]>buy){
                res+=prices[i]-buy;
                //这里就不加手续费了，手续费只需要减一次
                buy=prices[i];
            }

        }
        return res;
    }
}
