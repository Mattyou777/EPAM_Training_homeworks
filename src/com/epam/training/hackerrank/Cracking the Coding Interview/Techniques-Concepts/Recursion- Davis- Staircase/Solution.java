import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    private static HashMap<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for (int a0 = 0; a0 < s; a0++) {
            int n = in.nextInt();
            System.out.println(f(n));

        }
    }

    static int f(int n) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int causes = f(n - 1) + f(n - 2) + f(n - 3);
        cache.put(n, causes);
        return causes;
    }
}
