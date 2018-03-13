import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double meal_cost = in.nextDouble();
        int tip_percent = in.nextInt();
        int tax_percent = in.nextInt();
        in.close();
        double result = meal_cost * (1 + (double) (tip_percent + tax_percent) / 100);
        int res = (int) Math.round(result);
        System.out.println("The total meal cost is " + res + " dollars.");
    }
}
