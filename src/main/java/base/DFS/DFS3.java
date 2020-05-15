package base.DFS;

import java.util.Scanner;

/**
 * 二维数组地图的寻路最短步数
 * <p>
 * （下标从1开始）
 * <p>
 0 0 1 0
 0 0 0 0
 0 0 1 0
 0 1 0 0
 0 0 1 0

 0 0 0 0
 0 0 0 0
 0 0 0 0
 0 0 0 0
 0 0 0 0
 * <p>
 * 这样的一个4*5的矩阵，1代表路障，0可以走，从（1，1）出发，到（4，3）的位置
 *
 * @Author: kongweichang
 * @Date: 2019/9/10 15:45
 */
public class DFS3 {

    /**
     * 地图
     */
    private static int[][] map;
    /**
     * 是否访问过
     */
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 长
        int n = sc.nextInt();
        // 宽
        int m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        // 目标固定为右下角(n-1, m-1)
        visited[0][0] = true;
        dfs(0, 0, 0);
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

        // 下一步的xy值
        int nx = 0, ny = 0;
        int next[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        if (x == map.length - 1 && y == map[0].length - 1) {
            // 到达目标
            if (step < min) {
                min = step;
            }
            return;
        }
        // 向4个方向尝试
        for (int i = 0; i < 4; i++) {
            nx = x + next[i][0];
            ny = y + next[i][1];

            // 检查边界
            if (nx > map.length - 1 || nx < 0 || ny < 0 || ny > map[0].length - 1) {
                continue;
            }
            // 障碍物判断 + 是否走过判断
            if (map[nx][ny] == 0 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, step + 1);
                visited[nx][ny] = false;
            }
        }
    }
}
