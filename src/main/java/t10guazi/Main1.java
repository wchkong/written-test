package t10guazi;

import java.util.Scanner;

/**
 * @Author: kongweichang
 * @Date: 2019/9/16 14:43
 */
public class Main1 {

    static Integer count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String string = in.nextLine();
        char[] chars = string.toCharArray();
        getCount(chars, 0);
        System.out.println(count);
    }


    public static void getCount(char[] chars, int i) {

        if (i == chars.length) {
            count ++;
            return;
        }

        if (chars[i] == '0') {
            getCount(chars, i + 1);
        }
        if (chars[i] == '1') {
            getCount(chars, i + 1);
            if (i + 1 < chars.length) {
                getCount(chars, i + 2);
            }
        }
        if (chars[i] == '2') {
            getCount(chars, i + 1);
            if (i + 1 < chars.length && (chars[i + 1] >= '0' && chars[i + 1] <= '6')) {
                getCount(chars, i + 2);
            }
        }
        if (chars[i] >= '3') {
            getCount(chars, i + 1);
        }
    }
}
