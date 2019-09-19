package t12weizhong;

import java.util.Scanner;

/**
 * @Author: kongweichang
 * @Date: 2019/9/19 16:26
 */
public class Main1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long m = 1;
        int mod = 10*10*10*10*10*10 + 3;

        for (int j = 1; j <= n; j++) {
            m *= j;
        }

        System.out.println(m % mod);
    }
}
