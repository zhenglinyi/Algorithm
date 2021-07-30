package nb.jianzhi_offer;

public class jianzhi_65 {
}

//位运算
class Solution {
    public int add(int a, int b) {
        while(b!=0){
            int c=(a&b)<<1;
            a=a^b;
            b=c;
        }
        return a;
    }
}