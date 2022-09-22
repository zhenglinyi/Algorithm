package nb.acm_io;

import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] strings=sc.nextLine().split(" ");
            Arrays.sort(strings);
            int length = strings.length;
            for (int i = 0; i < length-1; i++) {
               System.out.print(strings[i]+" ");
            }
            //最后输出最后一个，换行并且不多空格
            System.out.println(strings[length-1]);
        }
    }
}
public class _9 {
}
