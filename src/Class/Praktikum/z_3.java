package Class.Praktikum;

import java.util.Scanner;

public class z_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean palindrom = true;
        String text = in.next();
        for (int i = 0; i < text.length()/2; i++)
            if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                palindrom = false;
                break;
            }
        System.out.println(text+" palindrom = "+palindrom);
    }
}
