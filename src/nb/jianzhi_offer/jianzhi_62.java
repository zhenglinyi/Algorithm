package nb.jianzhi_offer;

public class jianzhi_62 {

}
//约瑟夫环，好难
class Solution {
    public int lastRemaining(int n, int m) {
        int res=0;
        for (int i = 2; i <=n; i++) {
            res=(res+m)%i;
        }
        return res;
    }
}