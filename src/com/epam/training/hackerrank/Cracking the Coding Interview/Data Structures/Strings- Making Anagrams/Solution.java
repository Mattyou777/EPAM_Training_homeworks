import java.util.Scanner;

public class Solution {
    public static int numberNeeded(String first, String second) {
        int[] alph = new int[26];
        char[] firstArr = first.toCharArray();
        for (char c : firstArr) {
            alph[c - 'a']++;
        }
        char[] secondArr = second.toCharArray();
        for (char c : secondArr) {
            alph[c - 'a']--;
        }
        int del = 0;
        for (int i = 0; i < 26; i++) {
            del += Math.abs(alph[i]);
        }
        return del;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
