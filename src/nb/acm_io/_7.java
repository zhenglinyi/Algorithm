package nb.acm_io;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] strings=sc.nextLine().split(" ");
            int sum=0;
            for (int i = 0; i < strings.length; i++) {
                sum+=Integer.parseInt(strings[i]);
            }
            System.out.println(sum);
        }
    }
}
public class _7 {
}
