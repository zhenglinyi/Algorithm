package nb.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _93 {
}

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length()>12) return res;
        backTracking(s,0,0);
        return res;
    }
    // startIndex: 搜索的起始位置， pointNum:添加逗点的数量
    public void backTracking(String s,int startIndex,int pointNum){
        if(pointNum==3){// 逗点数量为3时，分隔结束
            // 判断第四段⼦字符串是否合法，如果合法就放进result中
            if(isValid(s,startIndex,s.length()-1)){
                res.add(s);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if(isValid(s,startIndex,i)){
                s=s.substring(0,i+1)+"."+s.substring(i+1); //在str的后⾯插⼊⼀个逗点
                pointNum++;
                backTracking(s,i+2,pointNum);// 插⼊逗点之后下⼀个⼦串的起始位置为i+2
                pointNum--;// 回溯
                s=s.substring(0,i+1)+s.substring(i+2);// 回溯删掉逗点
            }else{
                break;
            }
        }
    }
    public boolean isValid(String s,int start,int end){
        if(start>end){
            return false;
        }
        if((end-start)>=4) return false;
        //0开头的数字不合法
        if(s.charAt(start)=='0'&&start!=end){
            return false;
        }
        int num=0;
        for (int i = start; i <=end ; i++) {
            if(s.charAt(i)>'9'||s.charAt(i)<'0'){ // 遇到⾮数字字符不合法
                return false;
            }
            num=num*10+(s.charAt(i)-'0');
            if(num>255){
                return false;// 如果⼤于255了不合法
            }
        }
        return true;
    }
}
