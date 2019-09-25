package t19pdd;

import java.util.Scanner;

/**
 * 线段树
 * https://blog.csdn.net/yyl424525/article/details/77859911
 *
 *
 * @Author: kongweichang
 * @Date: 2019/9/25 14:39
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 植树点个数
        int N = sc.nextInt();
        // 小伙伴人数
        int M = sc.nextInt();
        int[][] array = new int[M][2];

        for (int i = 0; i < M; i++) {
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }
        // 位置i上的树是否已种植
        boolean[] bools = new boolean[N];
        int count = 0;
        for (int i = 0; i < M; i++) {
            if (count == N) {
                System.out.println(N);
                continue;
            }
            addTree(bools, array[i][0], array[i][1]);
            count = count(bools);
            System.out.println(count);
        }


    }

    static void addTree(boolean[] booleans, int l, int r) {
        if (l < 0) l = 0;
        if (r > booleans.length) {
            r = booleans.length;
        }
        for (int i = l - 1; i < r; i++) {
            booleans[i] = true;
        }
    }

    static int count(boolean[] booleans) {
        int count = 0;
        for (int i = 0; i < booleans.length; i++) {
            if (booleans[i]) {
                count ++;
            }
        }
        return count;
    }
}
