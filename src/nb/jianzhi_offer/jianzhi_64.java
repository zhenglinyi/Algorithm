package nb.jianzhi_offer;

public class jianzhi_64 {
}


class Solution {
    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
