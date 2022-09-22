package nb.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _202 {
}


class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        if(n==1) return true;
        set.add(n);
        while(n!=1){
            n=cal(n);
            if(set.contains(n)) return false;
            else set.add(n);
        }
        return true;
    }
    public int cal(int n){
        int res=0;
        while(n!=0){
            int tmp=n%10;
            res+=tmp*tmp;
            n/=10;
        }
        return res;
    }
}

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        set.add(n);
        while(n!=1){
            n=cal(n);
            if(set.contains(n))
                return false;
            else
                set.add(n);
        }
        return true;

    }
    int cal(int n){
        int res=0;
        while(n!=0){
            int tmp=n%10;
            res+=tmp*tmp;
            n/=10;
        }
        return res;
    }
}