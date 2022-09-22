package nb.acm_io;

import java.util.Scanner;

public class _1 {
}

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String[] strings=scanner.nextLine().split(" ");
            int a=Integer.parseInt(strings[0]);
            int b=Integer.parseInt(strings[1]);
            System.out.println(a+b);
        }
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] strings=sc.nextLine().split(" ");
            int a=Integer.parseInt(strings[0]);
            int b=Integer.parseInt(strings[1]);
            System.out.println(a+b);
        }
    }
}
