package t12weizhong;

import java.util.Scanner;

/**
 * 递归求第一个不位0的数
 *
 *
 * @Author: kongweichang
 * @Date: 2019/9/19 16:26
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        long[] array = new long[1000];
        array[0] = 1;

        for (int j = 1; j <= i; j++) {
            for (int k = 0; k < array.length; k++) {
                array[k] *= j;
                if (array[k] > 100000000L && k + 1< array.length) {
                    long l = array[k] / 100000000L;
                    array[k + 1] += l ;
                    array[k] -= l*100000000L;
                }
            }
        }

        for (int j = 0; j < array.length; j++) {
            long l = array[j];
            while (l> 10) {
                long a = l % 10;
                if (a != 0) {
                    System.out.println(a);
                    return;
                }
                l = l / 10;
            }
        }
    }
}
