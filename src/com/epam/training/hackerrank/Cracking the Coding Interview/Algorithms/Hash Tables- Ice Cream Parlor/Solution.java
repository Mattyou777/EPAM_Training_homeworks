import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    static void solve(int[] arr, int money) {

        if (arr == null || arr.length < 1) {
            System.out.println(-1 + " " + -1);
            return;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < money) {
                if (hashMap.containsKey(money - arr[i])) {
                    int index = hashMap.get(money - arr[i]);
                    System.out.println((index + 1) + " " + (i + 1));
                    return;
                }

                if (!hashMap.containsKey(arr[i])) {
                    hashMap.put(arr[i], i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int money = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }
            solve(arr, money);
        }
        in.close();
    }
}
