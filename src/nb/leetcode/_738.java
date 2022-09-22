package nb.leetcode;

public class _738 {
}


class Solution {
    public int monotoneIncreasingDigits(int n) {
        String[] strings=(n+"").split("");
        int start= strings.length;
        for(int i=strings.length-1;i>0;i--){
            if(Integer.parseInt(strings[i])<Integer.parseInt(strings[i-1])){
                strings[i-1]=(Integer.parseInt(strings[i-1])-1)+"";
                start=i;
            }
        }
        //后面的都要变成9
        for (int i = start; i < strings.length; i++) {
            strings[i]="9";
        }
        return Integer.parseInt(String.join("",strings));
    }
}

class Solution {
    public int monotoneIncreasingDigits(int n) {
        if (n==0)return 0;
        char[] chars= Integer.toString(n).toCharArray();
        int start=Integer.MAX_VALUE;//start初始值设为最大值，这是为了防止当数字本身是单调递增时，没有一位数字需要改成9的情况
        for (int i=chars.length-1;i>0;i--){
            if (chars[i]<chars[i-1]){
                chars[i-1]--;
                start=i;
            }
        }
        StringBuilder res=new StringBuilder();
        for (int i=0;i<chars.length;i++){
//            if (chars[i]=='0'&&i==0)continue;//防止出现09这样的情况
            if (i>=start){
                res.append('9');
            }else res.append(chars[i]);
        }
        return Integer.parseInt(res.toString());
    }
}

class Solution {
    public int monotoneIncreasingDigits(int n) {
        if(n==0) return n;
        char[] chars=String.valueOf(n).toCharArray();
        int length=chars.length;
        int start=Integer.MAX_VALUE;
        for (int i = length-1; i >0 ; i--) {
            if(chars[i]<chars[i-1]){
                chars[i]='9';
                chars[i-1]--;
                start=i;
            }
        }
        for (int i = start; i <length ; i++) {
            chars[i]='9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}