import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> names = new LinkedList();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String mail = sc.next();
            Pattern p = Pattern.compile(".+@gmail\\.com");
            Matcher m = p.matcher(mail);
            if (m.matches()) {
                names.add(name);
            }
        }
        Collections.sort(names);
        names.forEach(System.out::println);

    }
}
