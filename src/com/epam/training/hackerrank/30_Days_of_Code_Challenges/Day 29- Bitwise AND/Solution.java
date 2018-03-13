import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            Set<Integer> set = new HashSet();

            int n = sc.nextInt();
            int k = sc.nextInt();
            for (int j = 1; j <= n; j++) {
                for (int l = j + 1; l <= n; l++) {
                    int temp = j & l;
                    if (temp < k)
                        set.add(temp);
                }
            }
            System.out.println(Collections.max(set));

        }
    }
}
