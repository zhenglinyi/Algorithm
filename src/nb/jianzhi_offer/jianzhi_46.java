package nb.jianzhi_offer;

public class jianzhi_46 {
}


//动态规划
//本位和前一位可以组合，就是前一位和前两位之和
//若不能组合，就等于前一位
//用dp来代替dp数组节省空间
class Solution {
    public int translateNum(int num) {
        String s=String.valueOf(num);
        int a=1,b=1;//a是前一位，b是前两位
        for (int i = 2; i <= s.length(); i++) {
            String tmp=s.substring(i-2,i);//本位和前位组合
            int c=tmp.compareTo("10")>=0&&tmp.compareTo("25")<=0?a+b:a;
            b=a;
            a=c;
        }
        return a;
    }
}

class Solution {
    public int translateNum(int num) {
        String s=String.valueOf(num);
        int l=s.length();
        int[] dp=new int[l+1];//a是前一位，b是前两位
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <= l; i++) {
            String tmp=s.substring(i-2,i);//本位和前位组合
            dp[i]=tmp.compareTo("10")>=0&&tmp.compareTo("25")<=0?dp[i-2]+dp[i-1]:dp[i-1];
        }
        return dp[l];
    }
}

//由于对称性，可以从右到左，可以用求余和取整进一步节省空间
class Solution {
    public int translateNum(int num) {
        int a = 1, b = 1, x, y = num % 10;
        while(num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }
}


