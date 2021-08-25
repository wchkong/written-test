package huawei.od0824;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kongweichang
 * @date 2021/8/24 11:58 下午
 * @desc : 200分 出错的或电路
 * @wiki :
9
010
110
 **/
public class Main1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String error = scanner.nextLine();
        String right = scanner.nextLine();
        if (N > 8) {
            int count = 0;
            char[] chars = error.toCharArray();
            char[] rightChars = right.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                for (int j = chars.length - 1; j > i; j--) {
                    if ((rightChars[i] == '0' && chars[j] == '1') || (
                            rightChars[j] == '0' && chars[i] == '1'
                    )) {
                        count++;
                    }
                }
            }
            System.out.print(count);
        } else {
            int count = 0;
            try {
                Byte errorB = Byte.parseByte(error, 2);
                Byte rightB = Byte.parseByte(right, 2);
                int rightValue = errorB | rightB;

                char[] chars = error.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (int j = chars.length - 1; j > i; j--) {
                        char tmp = chars[i];
                        chars[i] = chars[j];
                        chars[j] = tmp;
                        StringBuilder s = new StringBuilder();
                        s.append(chars);
                        byte curByte = Byte.parseByte(s.toString(), 2);
                        int i1 = curByte | rightB;
                        if (i1 != rightValue) {
                            count++;
                        }
                        tmp = chars[i];
                        chars[i] = chars[j];
                        chars[j] = tmp;
                    }
                }
                System.out.print(count);
            } catch (Exception e) {
                System.out.print(count);
            }
        }
    }

    private static String orFunction(String a, String b) {
        int max = Math.max(a.length(), b.length());
        if (a.length() < max) {
            StringBuilder aS = new StringBuilder();
            for (int i = 1; i <= max - a.length(); i++) {
                aS.append('0');
            }
            aS.append(a);
            a = aS.toString();
        }
        if (b.length() < max) {
            StringBuilder bS = new StringBuilder();
            for (int i = 1; i <= max - b.length(); i++) {
                bS.append('0');
            }
            bS.append(b);
            b = bS.toString();
        }
        StringBuilder ss = new StringBuilder();
        for (int i = 0; i < max; i++) {
            char ac = a.charAt(i);
            char bc = b.charAt(i);
            if (ac == '1' || bc == '1') {
                ss.append('1');
            }
        }
        return ss.toString();
    }
}
