package nb.acm_io;


import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int linenum=sc.nextInt();
        for (int i = 0; i < linenum; i++) {
            int num=sc.nextInt();
            int sum=0;
            for (int j = 0; j < num; j++) {
                sum+=sc.nextInt();
            }
            System.out.println(sum);
        }

    }
}
public class _5 {
}
