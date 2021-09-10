package nb.jianzhi_offer;

public class jianzhi_63 {

}
class Solution {
    public int maxProfit(int[] prices) {
        int cost=Integer.MAX_VALUE;
        int profit=0;
        for (int i = 0; i < prices.length; i++) {
            cost=Math.min(cost,prices[i]);
            profit=Math.max(profit,prices[i]-cost);
        }
        return profit;
    }
}
