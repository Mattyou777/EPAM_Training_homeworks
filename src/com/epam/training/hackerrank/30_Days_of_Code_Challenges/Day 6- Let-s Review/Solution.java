import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < t; i++) {
            String s1 = sc.nextLine();
            String sa1 = "";
            for (int i1 = 0; i1 < s1.length(); i1 += 2) {
                sa1 += s1.charAt(i1);
            }
            sa1 += " ";
            for (int i1 = 1; i1 < s1.length(); i1 += 2) {
                sa1 += s1.charAt(i1);
            }
            System.out.println(sa1);
        }
    }
}
