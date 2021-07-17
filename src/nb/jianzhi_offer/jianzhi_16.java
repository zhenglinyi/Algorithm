package nb.jianzhi_offer;

public class jianzhi_16 {
}

//快速幂
class Solution {
    public double myPow(double x, int n) {
        if (x == 0)
            return 0;
        long b = n;//int 最小值取负号会越界
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        double res = 1.0;
        while (b > 0) {
            if ((b & 1) == 1)//奇数
                res *= x;
            x *= x;//平方
            b >>= 1;//整除二
        }
        return res;

    }
}
//    向下整除n//2 等价于 右移一位 n>>1 ；
//    取余数n%2 等价于 判断二进制最右一位值 n&1 ；
