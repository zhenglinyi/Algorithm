package nb.leetcode;

public class _43 {
}

//力扣官方题解1
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuffer curr = new StringBuffer();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = addStrings(ans, curr.reverse().toString());
        }
        return ans;
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
}

class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int m=num1.length();
        int n=num2.length();
        //两个数相乘可能是m+n位也可能是m+n+1位
        int[] ansArr=new int[m+n];
        //最高位存个位，和字符串相同
        for (int i = m-1; i >=0 ; i--) {
            int x=num1.charAt(i)-'0';
            for (int j = n-1; j >=0 ; j--) {
                int y=num2.charAt(j)-'0';
                //累加到对应的位上
                ansArr[i+j+1]+=x*y;
            }
        }
        //从哥位开始进位
        for (int i = m+n-1; i >0 ; i--) {
            ansArr[i-1]+=ansArr[i]/10;
            ansArr[i]%=10;
        }
        //判断最高位是否位0
        int index=ansArr[0]==0?1:0;
        StringBuffer ans=new StringBuffer();
        while(index<m+n){
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }
}