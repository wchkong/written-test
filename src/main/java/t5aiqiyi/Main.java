package t5aiqiyi;

import java.util.Scanner;

/**
 * 给定一个长度为N-1且只包含0和1的序列A1到AN-1，如果一个1到N的排列P1到PN满足对于1≤i<N，当Ai=0时Pi<Pi+1，当Ai=1时Pi>Pi+1，则称该排列符合要求，那么有多少个符合要求的排列？
 *
 * 输入
 * 第一行包含一个整数N，1<N≤1000。
 *
 * 第二行包含N-1个空格隔开的整数A1到AN-1，0≤Ai≤1
 *
 * 输出
 * 输出符合要求的排列个数对109+7取模后的结果。
 *
 *
 * 样例输入
 * 4
 * 1 1 0
 * 样例输出
 * 3
 *
 * 提示
 * 样例解释
 *
 * 符合要求的排列为{3 2 1 4}、{4 2 1 3}和{4 3 1 2}。
 */
public class Main {

    static int count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] A = new int[N - 1];
        int[] P = new int[N];

        for (int i = 0; i < N - 1; i++) {
            A[i] = in.nextInt();
        }
        for (int i = 0; i < N; i++) {
            P[i] = i + 1;
        }

        process1(P, 0, A);
        System.out.println(count);

    }

    public static boolean checkArray(int[] P, int[] A, int length) {

        for (int i = 0; i < length; i++) {
            int i1 = A[i];
            if (i1 == 1) {
                if (P[i] <= P[i + 1]) {
                    return false;
                }
            } else {
                if (P[i] >= P[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void swap(int[] P, int i, int j) {
        int tmp = P[i];
        P[i] = P[j];
        P[j] = tmp;
    }


    public static void process1(int[] P, int i, int[] A) {
        if (i == P.length) {
            if (checkArray(P, A, i - 1)) {
                count ++;
            }
        }
        for (int j = i; j < P.length; j++) {
            swap(P, i, j);
            if (i > 1) {
                if (!checkArray(P, A, i - 1)) {
                    swap(P, i, j);
                    continue;
                }
            }
            process1(P, i + 1, A);
            swap(P, i, j);
        }
    }


}
