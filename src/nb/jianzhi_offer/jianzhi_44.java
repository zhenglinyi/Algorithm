package nb.jianzhi_offer;

public class jianzhi_44 {

}


class Solution {
    public int findNthDigit(int n) {
        int digit=1;
        long start=1;
        long count=9;
        while(n>count){
            n-=count;
            digit+=1;
            start*=10;
            count=digit*start*9;
        }
        long sum=start+(n-1)/digit;
        //long->string->char
        return Long.toString(sum).charAt((n-1)%digit)-'0';
    }
}