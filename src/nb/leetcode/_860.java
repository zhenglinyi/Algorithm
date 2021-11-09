package nb.leetcode;

public class _860 {
}


class Solution {
    public boolean lemonadeChange(int[] bills) {
        int cash_5 = 0;
        int cash_10 = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                cash_5++;
            } else if (bills[i] == 10) {
                cash_5--;
                cash_10++;
            } else if (bills[i] == 20) {
                if (cash_10 > 0) {
                    cash_10--;
                    cash_5--;
                } else {
                    cash_5 -= 3;
                }
            }
            if (cash_5 < 0 || cash_10 < 0) return false;
        }

        return true;
    }
}