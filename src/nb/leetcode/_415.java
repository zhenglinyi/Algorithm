package nb.leetcode;

public class _415 {
}

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb=new StringBuilder();
        String rev1=new StringBuilder(num1).reverse().toString();
        String rev2=new StringBuilder(num2).reverse().toString();
        int c=0;
        int i=0;
        int j=0;
        for (; i < rev1.length()&&j<rev2.length(); i++,j++) {
            int a=(rev1.charAt(i))-'0';
            int b=(rev2.charAt(j))-'0';
            int sum=a+b+c;
            int tmp=sum%10;
            c=sum/10;
            sb.append(tmp);
        }
        while(i<rev1.length()){
            int a=(rev1.charAt(i))-'0';
            int sum=a+c;
            int tmp=sum%10;
            c=sum/10;
            sb.append(tmp);
            i++;
        }
        while(j<rev2.length()){
            int b=(rev2.charAt(j))-'0';
            int sum=b+c;
            int tmp=sum%10;
            c=sum/10;
            sb.append(tmp);
            j++;
        }
        if(c>0)
            sb.append(c);
        return sb.reverse().toString();

    }
}

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i=num1.length()-1;
        int j=num2.length()-1;
        int c=0;
        while(i>=0||j>=0){
            int a=i>=0?num1.charAt(i)-'0':0;
            int b=j>=0?num2.charAt(j)-'0':0;
            int sum=a+b+c;
            c=sum/10;
            sb.append(sum%10);
            i--;j--;
        }
        if(c==1) sb.append(c);
        return sb.reverse().toString();

    }
}