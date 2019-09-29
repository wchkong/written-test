package t21duxiaoman;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 有 N 辆车要陆续通过一座最大承重为 W 的桥，其中第 i 辆车的重量为 w[i]，通过桥的时间为 t[i]。
 * 要求： 第 i 辆车上桥的时间不早于第 i - 1 辆车上桥的时间；
 * <p>
 * 任意时刻桥上所有车辆的总重量不超过 W。
 * <p>
 * 那么，所有车辆都通过这座桥所需的最短时间是多少？
 * <p>
 * 输入
 * 第一行输入两个整数 N、W（1 <= N、W <= 100000）。第二行输入 N 个整数 w[1]
 * 到 w[N]（1 <= w[i] <= W）。第三行输入 N 个整数 t[1] 到 t[N]（1 <= t[i] <= 10000）。
 * <p>
 * 输出
 * 输出一个整数，表示所有车辆过桥所需的最短时间。
 * <p>
 * <p>
 * 样例输入
 * 4 2
 * 1 1 1 1
 * 2 1 2 2
 * 样例输出
 * 4
 * <p>
 * 提示
 * 样例解释
 * 不妨设第 1 辆车在 0 时刻上桥，则：
 * 第 2 辆车也可以在 0 时刻上桥；
 * 第 2 辆车在 1 时刻下桥，此时第 3 辆车上桥；
 * 第 1 辆车在 2 时刻下桥，此时第 4 辆车上桥；
 * 第 3 辆车在 3 时刻下桥；
 * 第 4 辆车在 4 时刻下桥，此时所有车辆都通过这座桥。
 *
 * @Author: kongweichang
 * @Date: 2019/9/29 19:34
 */
public class Main {

    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 车辆个数
        int N = scanner.nextInt();
        // 桥总承重量
        int M = scanner.nextInt();
        int[][] cars = new int[N][2];

        for (int i = 0; i < N; i++) {
            cars[i][0] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            cars[i][1] = scanner.nextInt();
        }

        int process = process(cars, 0, 0, 0, M, N);

        System.out.println(process);

    }


    static int process(int[][] cars, int i, int time, int weigh, int m, int n) {

        if (i == n) {
            if (queue.isEmpty()) {
                return time;
            } else {
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    time += cars[poll][1];
                }
                return time;
            }
        }
        if (weigh > m) {
            return Integer.MAX_VALUE;
        }

        if (weigh + cars[i][0] < m) {
            queue.add(i);
            weigh += cars[i][0];
        } else {
            Integer poll = queue.poll();
            if (poll == null) {
                weigh = 0;
            } else {
                weigh -= cars[poll][0];
                time += cars[poll][1];
            }
        }

        return process(cars, ++i, time, weigh, m, n);
    }
}
