import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);
        int i1 = Integer.parseInt(scan.next());
        double d1 = Double.parseDouble(scan.next());
        System.out.println(i + i1);
        System.out.println(d + d1);
        System.out.print(s);
        while (scan.hasNext()) {
            System.out.print(scan.next() + " ");
        }
        scan.close();
    }
}
