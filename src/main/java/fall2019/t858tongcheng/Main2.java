package fall2019.t858tongcheng;

import java.util.Scanner;

/**
 * 3 3
1 3 4 2 1 2 4 3 1
 */
public class Main2 {

    /**
     * 地图
     */
    private static int[][] map;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 长
        int m = sc.nextInt();
        // 宽
        int n = sc.nextInt();
        map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        dfs(0, 0, map[0][0]);
        System.out.println(min);
    }

    /**
     * 输入起点
     * 终点：(n-1, m-1)
     *
     * @param x
     * @param y
     */
    private static void dfs(int x, int y, int step) {


        if (x == map.length - 1 && y == map[0].length - 1) {
            // 到达目标
            if (step < min) {
                min = step;
            }
            return;
        }
        // 检查边界
        if (x <= map.length - 2) {
            dfs(x + 1, y, step + map[x + 1][y]);
        }
        if (y <= map[0].length - 2) {
            dfs(x, y + 1, step + map[x][y + 1]);
        }
    }

}
