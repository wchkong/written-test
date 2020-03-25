package spring2020.huawei;

import java.util.Scanner;

/**
 *
 **/
public class Main1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // 行数
        int N = scanner.nextInt();
        char[][] matrix = new char[N][];

        for (int i = 0; i < N; i++) {
            String next = scanner.next();
            char[] chars = next.toCharArray();
            matrix[i] = chars;
        }

        int[][] matrixDp = new int[N][matrix[0].length];
        int max = 0;
        // 初始状态
        for (int i = 0; i < N; i++) {
            if (matrix[i][0] == '1') {
                matrixDp[i][0] = 1;
                max = 1;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1') {
                matrixDp[0][i] = 1;
                max = 1;
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                matrixDp[i][j] = Math.min(Math.min(matrixDp[i][j - 1], matrixDp[i - 1][j]), matrixDp[i - 1][j - 1]) + 1;
                if (matrixDp[i][j] > max) {
                    max = matrixDp[i][j];
                }
            }
        }
        System.out.println(max * max);
    }



}
