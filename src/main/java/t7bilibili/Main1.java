package t7bilibili;

import java.util.Scanner;

/**
 *
 * 输入一个正整数N  1=<N<=10^9
 * 输出
 *
 * @Author: kongweichang
 * @Date: 2019/9/10 15:06
 */
public class Main1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        if (N == 0) {
            System.out.println(0);
            return;
        }
        int count = 1;
        long a = 2;
        long now = N;
        while (now > 1) {
            long l = N / a;
            if (checkPoint(l, N, a)) {
                count ++;
            }
            now /= 2;
            //a *= 2;
            a ++;
        }
        System.out.println(count);
    }

    static boolean checkPoint(long mid, long N, long a) {

        long sum = 0;
        long sum2 = 0;
        for (long i = mid - a/2; i <= mid + a/2; i ++) {
            sum = sum + i;
        }
        for (long i = mid - a/2 + 1; i <= mid + a/2; i ++) {
            sum2 = sum2 + i;
        }
        return sum == N || sum2 == N;
    }

}
