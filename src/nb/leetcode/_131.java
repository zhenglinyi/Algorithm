package nb.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _131 {
}

class Solution {
    List<List<String>> res=new ArrayList<>();
    List<String> tmp=new LinkedList<>();
    public List<List<String>> partition(String s) {
        backTracking(s,0);
        return res;
    }

    public void backTracking(String s,int startIndex){
        if(startIndex>=s.length()){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            //如果是回文串则记录
            if(isPalindrome(s,startIndex,i)){
                String str=s.substring(startIndex,i+1);
                tmp.add(str);
            }else{
                //不是则继续
                continue;
            }
            backTracking(s,i+1);
            tmp.remove(tmp.size()-1);

        }
    }
    //判断是否为回文串
    public boolean isPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
