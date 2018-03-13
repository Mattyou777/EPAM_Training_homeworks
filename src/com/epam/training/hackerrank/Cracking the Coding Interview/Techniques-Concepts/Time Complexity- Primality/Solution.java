import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        big:
        for (int a0 = 0; a0 < p; a0++) {
            int n = in.nextInt();
            BigInteger bigInteger = BigInteger.valueOf(n);
            if (bigInteger.isProbablePrime(n))
                System.out.println("Prime");
            else
                System.out.println("Not prime");
        }
    }
}
