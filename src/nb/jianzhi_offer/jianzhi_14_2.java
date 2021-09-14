package nb.jianzhi_offer;

public class jianzhi_14_2 {
}

class Solution {
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        long res=1L;
        int p=(int)1e9+7;
        //贪心算法，优先切三，其次切二
        while(n>4){
            res=res*3%p;
            n-=3;
        }
        //出来循环只有三种情况，分别是n=2、3、4
        return (int)(res*n%p);
    }
}

//循环取余
class Solution {
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;

        long rem = 1, x = 3 ,a = n / 3;
        //直接套循环求余公式
        for(int i = 0; i < ((b == 1)?a-1:a); i++) { //b == 1代表余数为1的时候，需要单独取出一个3出来凑成2*2达到最大值效果
            rem = (rem * x) % p;
        }
        if(b == 0) return (int)(rem % p);
        if(b == 1) return (int)(rem * 4 % p);
        return (int)(rem * 2 % p);
    }


}

//快速幂取余
class Solution {
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for(int a = n / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if(b == 0) return (int)(rem * 3 % p);
        if(b == 1) return (int)(rem * 4 % p);
        return (int)(rem * 6 % p);
    }
}


