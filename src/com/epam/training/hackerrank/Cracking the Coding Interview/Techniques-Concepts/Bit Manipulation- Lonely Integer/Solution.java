import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        Set<Integer> set = new HashSet(n / 2 + 1);
        for (int i : a)
            set.add(i);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (a[i] == a[j])
                        set.remove(a[i]);

                }
            }
        }
        Iterator iter = set.iterator();
        System.out.println(iter.next());
    }
}
