import java.util.*;

public class Problem2 {
    
    public static void printPattern(int a, int b, int n) {
        int currElement = a + b;
        System.out.print(currElement + " ");
        for (int j = 1; j < n; j++) {
            currElement += Math.pow(2, j) * b;
            System.out.print(currElement + " ");
        }

    }
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for(int i=0;i<q;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            printPattern(a,b,n);
        }
        sc.close();
    }
}
