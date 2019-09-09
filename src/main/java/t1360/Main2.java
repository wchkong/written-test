package t1360;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] D = new int[M];
        for (int i = 0; i < M; i++) {
            int d = sc.nextInt();
            D[i] = d;
        }
        int sum = 0;
        for (int i = 1; i < N + 1; i++) {
            if (isRight(D, N, 0, i)) {
                sum++;
            }
        }
        System.out.println(sum);
    }

    public static boolean isRight(int[] D , int N, int i, int sum) {
        if (i == D.length) {
            if (sum > 1 && sum < N) {
                return true;
            }
        }
        if (sum > N) {
            return false;
        }
        return isRight(D, N, ++i, sum + D[i]) || isRight(D, N, ++i, sum - D[i]);
    }

}
