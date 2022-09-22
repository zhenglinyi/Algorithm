package nb.acm_io;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            if(sc.hasNext()){
                int num=sc.nextInt();
                if(num==0) break;
                int sum=0;
                for (int i = 0; i < num; i++) {
                    sum+=sc.nextInt();
                }
                System.out.println(sum);
            }
        }
    }


}

public class _4 {
}
