package nb.leetcode;

public class _1456 {
    public int maxVowels(String s, int k) {
        int n=s.length();
        int count=0,result=0;
        int i=0;

        for(int j=0;j<n;j++){
            int flagj="aeiou".indexOf(String.valueOf(s.charAt(j)));
            int flagi="aeiou".indexOf(String.valueOf(s.charAt(i)));
            if(flagj!=-1){
                count++;
            }
            //够k个字符了，开始滑动
            if(j>k-1){
                if(flagi!=-1){
                    count--;
                }
                i++;
            }
            result=Math.max(result,count);


        }
        return result;

    }

    public static void main(String[] args) {

    }
}
