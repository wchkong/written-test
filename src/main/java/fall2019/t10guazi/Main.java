package fall2019.t10guazi;

import java.util.Scanner;

/**
 * @Author: kongweichang
 * @Date: 2019/9/16 15:56
 */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int K = sc.nextInt();

        String min = S;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            String newStr = move(S, getMaxCharAt(S, K));
            int compare = compare(newStr, min);
            if (compare == 1) {
                min = newStr;
            }
            S = newStr;
        }
        System.out.println(min);

    }

    public static int getMaxCharAt(String str, int K) {

        if (K > str.length()) {
            K = str.length();
        }
        int maxIndex = 0;
        char charMax = 'a' - 1;
        for (int i = 0; i < K; i++) {
            if (str.charAt(i) > charMax) {
                charMax = str.charAt(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }


    public static String move(String str, int charAt) {
        StringBuilder stringBuilder = new StringBuilder(str);
        char c = stringBuilder.charAt(charAt);
        stringBuilder.deleteCharAt(charAt);
        stringBuilder.append(c);
        return stringBuilder.toString();
    }

    public static int compare(String s1, String s2) {

        char[] chars = s1.toCharArray();
        char[] chars1 = s2.toCharArray();
        if (chars.length != chars1.length) {
            throw new RuntimeException("长度不同");
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars1[i] > chars[i]) {
                return 1;
            } else if (chars1[i] < chars[i]) {
                return -1;
            }
        }
        return 0;
    }
}
