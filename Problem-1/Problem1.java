import java.util.*;

public class Problem1 {
    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            try {
                long n = sc.nextLong();
                if (n >= -128 && 127 >= n) {
                    System.out.println(n + " " + "can be fitted in");
                    System.out.println("* byte");
                    System.out.println("* short");
                    System.out.println("* int");
                    System.out.println("* long");
                } else if (n >= -32768 && 32767 >= n) {
                    System.out.println(n + " " + "can be fitted in");
                    System.out.println("* short");
                    System.out.println("* int");
                    System.out.println("* long");

                } else if (n >= -2147483648 && 2147483647 >= n) {
                    System.out.println(n + " " + "can be fitted in");
                    System.out.println("* int");
                    System.out.println("* long");

                } else if (n >= -9223372036854775808L && 9223372036854775807L >= n) {
                    System.out.println(n + " " + "can be fitted in");
                    System.out.println("* long");
                }
            } catch (Exception e) {
                System.out.println(sc.next() + "can't be fitted anywhere.");
            }
        }
        sc.close();
    }
}
      
