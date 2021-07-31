package nb.jianzhi_offer;

import java.util.Arrays;

public class jianzhi_60 {
}



class Solution {
    public double[] dicesProbability(int n) {
        //初始化，只有一个骰子
        double[] dp=new double[6];
        Arrays.fill(dp,1.0/6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp=new double[5*i+1];//加入一个新的骰子
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j+k]+=dp[j]/6.0;//用原来的概率计算新的概率
                }
            }
            dp=tmp;//

        }
        return dp;
    }
}