import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for (int i = 0; i < a; i++) {
            int in = sc.nextInt();
            BigInteger bi = new BigInteger("" + in);
            if (bi.isProbablePrime(in))
                System.out.println("Prime");
            else
                System.out.println("Not prime");
        }
    }
}
