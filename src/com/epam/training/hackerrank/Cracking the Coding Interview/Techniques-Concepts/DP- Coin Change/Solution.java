import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static long count(int S[], int m, int n) {
        if (n == 0)
            return 1;

        // If n is less than 0 then no 
        // solution exists
        if (n < 0)
            return 0;

        // If there are no coins and n 
        // is greater than 0, then no
        // solution exist
        if (m <= 0 && n >= 1)
            return 0;
        long[] table = new long[n + 1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i = 0; i < m; i++)
            for (int j = S[i]; j <= n; j++)
                table[j] += table[j - S[i]];

        return table[n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for (int coins_i = 0; coins_i < m; coins_i++) {
            coins[coins_i] = in.nextInt();
        }
        System.out.println(count(coins, m, n));
    }
}
