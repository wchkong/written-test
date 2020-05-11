package fall2019.t24yitu;

import java.util.Arrays;
import java.util.Scanner;

// 3 4 2 3 5 6 10
// 4 5 1 4 2 2 3 3 4
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long[][] tower = new long[n][2];
        for (int i = 0; i < n; i++) {
            long h = scanner.nextLong();
            long v = scanner.nextInt();
            tower[i] = new long[]{h, v};
        }

        int[] lmax = new int[n];
        int[] rmax = new int[n];
        for (int i = 0; i < n; i++) {
            lmax[i] = rmax[i] = -1;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (tower[i][0] < tower[j][0]) {
                    rmax[i] = j;
                    break;
                }
            }
        }
        for (int i = n - 1; i > 0 ; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (tower[i][0] < tower[j][0]) {
                    lmax[i] = j;
                    break;
                }
            }
        }
        long[] receive = new long[n];
        for (int i = 0; i < n; i++) {
            if (lmax[i] >= 0) {
                receive[lmax[i]] += tower[i][1];
            }
            if (rmax[i] >= 0) {
                receive[rmax[i]] += tower[i][1];
            }

        }
        Arrays.sort(receive);
        System.out.print(receive[n - 1]);
    }

}
