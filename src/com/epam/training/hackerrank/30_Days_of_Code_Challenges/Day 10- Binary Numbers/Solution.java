import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int sum = 0;
        int max = 0;

        while (i > 0) {
            if (i % 2 == 1) {
                sum++;
                if (sum > max) {
                    max = sum;
                }
            } else {
                sum = 0;
            }
            i = i / 2;
        }
        System.out.println(max);
    }
}
