import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1; i < 11; i++) {
            System.out.println(n + " x " + i + " = " + (i * n));
        }
    }
}
