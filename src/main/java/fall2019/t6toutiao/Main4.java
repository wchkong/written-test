package fall2019.t6toutiao;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main4 {

    static List list = Arrays.asList(
            'A', 'B', 'C', 'D','E', 'F', 'G', 'H','I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P','Q', 'R', 'S', 'T','U','V', 'W', 'X',
            'Y', 'Z'
    );

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String string = in.nextLine();
        char[] chars = string.toCharArray();
        printStr(chars, 0, new StringBuffer());
    }


    public static void printStr(char[] chars, int i, StringBuffer stringBuffer) {

        if (i == chars.length) {
            System.out.println(stringBuffer.toString());
            return;
        }

        if (chars[i] == '0') {
            printStr(chars, i + 1, stringBuffer);
        }
        if (chars[i] == '1') {
            StringBuffer temp = copyBuffer(stringBuffer);
            printStr(chars, i + 1, stringBuffer.append('A'));
            //stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            if (i + 1 < chars.length) {
                int a = chars[i + 1] - '0';
                printStr(chars, i + 2, temp.append(list.get(9 + a)));
            }
        }
        if (chars[i] == '2') {
            StringBuffer temp = copyBuffer(stringBuffer);
            printStr(chars, i + 1, stringBuffer.append('B'));
            //stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            if (i + 1 < chars.length && (chars[i + 1] >= '0' && chars[i + 1] <= '6')) {
                int a = chars[i + 1] - '0';
                printStr(chars, i + 2, temp.append(list.get(19 + a)));
            }
        }
        if (chars[i] >= '3') {
            printStr(chars, i + 1, stringBuffer.append(list.get(chars[i] - '1')));
        }
    }

    private static StringBuffer copyBuffer(StringBuffer stringBuffer) {
        StringBuffer newBuffer = new StringBuffer();
        for (int i = 0; i < stringBuffer.length(); i++) {
            newBuffer.append(stringBuffer.charAt(i));
        }
        return newBuffer;
    }
}
