package nb.acm_io;


import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
//        int num=sc.nextInt();
//        sc.nextLine();
        int num = Integer.parseInt(sc.nextLine());
        String[] strings=sc.nextLine().split(" ");
        Arrays.sort(strings);
        for (int i = 0; i < num; i++) {
            System.out.print(strings[i]+" ");
        }
    }
}
public class _8 {
}


