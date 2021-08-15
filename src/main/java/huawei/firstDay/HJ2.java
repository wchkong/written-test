package huawei.firstDay;

import java.util.Scanner;

/**
 * @author kongweichang
 * @date 2021/8/14 5:43 下午
 * @desc :
 * @wiki :
 **/
public class HJ2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        in = in.toLowerCase();
        String compareStr = sc.nextLine();
        String lowerCase = compareStr.toLowerCase();

        char[] chars = in.toCharArray();
        char compare = lowerCase.toCharArray()[0];
        int count = 0;
        for (char a : chars) {
            if (compare == a) {
                count++;
            }
        }
        System.out.println(count);
    }
}
