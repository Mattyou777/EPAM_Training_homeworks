import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ad = sc.nextInt();
        int am = sc.nextInt();
        int ay = sc.nextInt();
        int ed = sc.nextInt();
        int em = sc.nextInt();
        int ey = sc.nextInt();
        if (ay > ey) {
            System.out.println(10000);
        } else if (am == em && ad > ed && ay == ey)
            System.out.println(15 * (ad - ed));
        else if (am > em && ay == ey)
            System.out.println(500 * (am - em));
        else
            System.out.println(0);
    }
}
