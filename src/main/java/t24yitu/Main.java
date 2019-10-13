package t24yitu;

import java.util.Scanner;

/**
 3 5 10000000
 100 60000 6000000
 120 40000 10000000
 200 100000 9000000
 100 50000
 200 1000000
 250 5000000
 240 5000000
 180 400000
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 房子数
        int n = scanner.nextInt();
        // 车子数
        int m = scanner.nextInt();
        // 总钱数
        int b = scanner.nextInt();

        int[][] house = new int[n][3];
        int[][] car = new int[m][2];
        for (int i = 0; i < n; i++) {
            int area = scanner.nextInt();
            int dist = scanner.nextInt();
            int price = scanner.nextInt();
            house[i] = new int[]{area, dist, price};
        }
        for (int i = 0; i < m; i++) {
            int speed = scanner.nextInt();
            int price = scanner.nextInt();
            car[i] = new int[]{speed, price};
        }

        // 幸福度 = 10 * area - floor(dist/speed)
        long max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (house[i][2] + car[j][1] <=  b) {
                    double v = 10 * house[i][0] - Math.floor(house[i][1] / car[j][0]);
                    if (v > max) {
                        max = (long) v;
                    }
                }
            }
        }
        System.out.print(max);
    }

}
