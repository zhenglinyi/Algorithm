package nb.leetcode;

public class _509 {
}

class Solution {
    public int fib(int n) {
        if(n<=1){
            return n;
        }else{
            return fib(n-1)+fib(n-2);
        }
    }
}
class Solution {
    public int fib(int n) {
        if(n<=1){
            return n;
        }
        int a=0,b=1;
        int c=0;
        //i从1开始

        for (int i = 1; i < n; i++) {
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
