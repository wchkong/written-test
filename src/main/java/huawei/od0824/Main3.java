package huawei.od0824;

import java.util.Scanner;

/**
 * @author kongweichang
 * @date 2021/8/25 12:39 上午
 * @desc :
 * @wiki :
 **/
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String error = scanner.nextLine();
        String right = scanner.nextLine();
        int count = 0;
        char[] chars = error.toCharArray();
        char[] rightChars = right.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (rightChars[i] == '1') {
                continue;
            }
            for (int j = chars.length - 1; j > i; j--) {
                if ((chars[j] == '1') || chars[i] == '1') {
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
