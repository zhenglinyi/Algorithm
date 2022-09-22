package nb.leetcode;

public class _779 {
}

class Solution {
    public int kthGrammar(int n, int k) {
        //题目是从第一位开始，所以我们k-1
        return recur(n,k-1);

    }
    int recur(int n,int k){
        if(n==1) return 0;
        //为了保证k/2相邻两位相同，我们从第0位开始
        int num=recur(n-1,k/2);
        int res=0;
        if(k%2==0){
            if(num==0) res=0;
            else res=1;
        }else{
            if(num==1) res=0;
            else res=1;
        }
        return res;
    }
}
