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
        for (int i = start; i < strings.length; i++) {
            strings[i]="9";
        }
        return Integer.parseInt(String.join("",strings));
    }
}