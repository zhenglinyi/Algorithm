package nb.leetcode;

import java.util.PriorityQueue;

public class _313 {
}

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n==1) return 1;
        int[] dp=new int[n];
        dp[0]=1;
        int[] tmp=new int[primes.length];
        for (int i = 1; i < n; i++) {
            int min=Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min=Math.min(min,dp[tmp[j]]*primes[j]);
            }
            dp[i]=min;
            for (int j = 0; j < primes.length; j++) {
                if(min==dp[tmp[j]]*primes[j]){
                    tmp[j]++;
                }
            }
        }
        return dp[n-1];

    }
}

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(1);
        while (n-- > 0) {
            int x = q.poll();
            if (n == 0) return x;
            for (int k : primes) {
                if (k <= Integer.MAX_VALUE / x) q.add(k * x);
                if (x % k == 0) break;
            }
        }
        return -1; // never
    }
}

作者：AC_OIer
        链接：https://leetcode-cn.com/problems/super-ugly-number/solution/gong-shui-san-xie-yi-ti-shuang-jie-you-x-jyow/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
