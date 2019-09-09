package t6toutiao;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        String s = in.nextLine();
        String[] s1 = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            stringBuilder.append(s1[i]);
        }
        char[] chars = stringBuilder.toString().toCharArray();

        for (int i = 0; i < q; i++) {
            int l = in.nextInt();
            int r = in.nextInt();

            printScore(l, r, chars);
        }

    }

    private static void printScore(int l, int r, char[] chars) {
        int score = 0;
        int count = r - l + 1;

        while (count <= 0) {
            char lChar = chars[l];
            char rChar = chars[r];
            char now = lChar;
            if (now == '0') {
                count --;
            } else if (now == '>') {

            } else if (now >= '1' && now >= '9') {
                score += now - '0';
            }
            now = chars[l + 1];
            count --;
        }


        System.out.println(score);
    }
}
