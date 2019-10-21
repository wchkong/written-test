package t26wanglong;

import java.util.Scanner;

/**
 * @Author: kongweichang
 * @Date: 2019/10/16 14:47
 */
public class Main {

    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // 行数
        int N = scanner.nextInt();
        int[][] triangle = new int[N][];
        for (int i = 0; i < N; i++) {
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            int[] a = new int[s1.length];
            for (int j = 0; j < s1.length; j++) {
                a[j] = Integer.parseInt(s1[j]);
            }
            triangle[i] = a;
        }

        process(triangle, 0, 0, 0);
        System.out.println(max);
    }

    private static void process(int[][] triangle, int sum, int x, int y) {

        if (x >= triangle.length) {
            if (sum > max) {
                max = sum;
            }
            return;
        }
        if (y >= triangle[x].length) {
            return;
        }
        process(triangle, sum + triangle[x][y], x + 1, y);
        process(triangle, sum + triangle[x][y], x + 1, y + 1);
    }
}
