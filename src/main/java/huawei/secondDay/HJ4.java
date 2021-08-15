package huawei.secondDay;

import java.util.Scanner;

/**
 * @author kongweichang
 * @date 2021/8/15 6:41 下午
 * @desc :
 * @wiki :
 **/
public class HJ4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            char[] chars = s.toCharArray();
            int i = chars.length / 8;
            char[][] chars1 = new char[chars.length % 8 > 0 ? i + 1 : i][8];
            for (int j = 0; j < chars.length; j++) {
                chars1[j/8][j%8] = chars[j];
            }
            for (int j = 0; j < chars1.length; j++) {
                for (int k = 0; k < 8; k++) {
                    System.out.print(chars1[j][k]);
                }
                System.out.println();
            }
        }
    }
}
