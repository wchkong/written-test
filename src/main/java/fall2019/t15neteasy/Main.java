package fall2019.t15neteasy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] xA = new int[T];

        for (int i = 0; i < T; i++) {
            xA[i] = scanner.nextInt();
        }

        for (int i = 0; i < T; i++) {
            int x = xA[i];
            int length = x / 9;
            if (x % 9 != 0) {
                length ++;
            }
            int[] xL = new int[length];
            int j = 0;
            while (x > 9) {
                xL[j] = 9;
                j++;
                x -= 9;
            }
            if (x > 0) {
                xL[j] = x;
            }
            for (int k = length - 1; k >= 0; k--) {
                System.out.print(xL[k]);
            }
            System.out.println();
        }

    }


    static int S(int x) {
        if (x < 10) {
            return x;
        }
        int s = 0;
        while (x >= 10) {
            s += x % 10;
            x /=10;
        }
        s += x;
        return s;
    }



}