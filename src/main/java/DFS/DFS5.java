package DFS;

/**
 *
 * 接上题，判断图中有几个小岛
 *
 * 具体思路，通过双重循环，从左上角开始遍历整个地图，比如先遍历的1,1,
 * 那么就从1，1调用深搜把1，1所在的小岛的9块陆地所在的map数组数值全部改为-1,
 * 继续遍历地图，1，2为-1，跳过，1，3为-1，跳过，1，4为0，跳过，一直到1，9满足，
 * 对1，9调用深搜把1，9所在的5块陆地所在的map数组数值全部改为-2，依次类推，
 * 对地图全部遍历完毕后，将分为几大块不同标记的陆地，
 * 之前用的用num标记陆地上的标记，输出-num就可以了。
 *
 *
 * @Author: kongweichang
 * @Date: 2019/9/10 17:47
 */
public class DFS5 {

    static int[][] map = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 2, 1, 0, 0, 0, 0, 0, 2, 3},
            {0, 3, 0, 2, 0, 1, 2, 1, 0, 1, 2},
            {0, 4, 0, 1, 0, 1, 2, 3, 2, 0, 1},
            {0, 3, 2, 0, 0, 0, 1, 2, 4, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 5, 3, 0},
            {0, 0, 1, 2, 1, 0, 1, 5, 4, 3, 0},
            {0, 0, 1, 2, 3, 1, 3, 6, 2, 1, 0},
            {0, 0, 0, 3, 4, 8, 9, 7, 5, 0, 0},
            {0, 0, 0, 0, 3, 7, 8, 6, 0, 1, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}};

    static int[][] flag = new int[11][11];

    static int sum = 0;

    public static void main(String[] args) {

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0 && flag[i][j] == 0) {
                    sum ++;
                    flag[i][j] = -sum;
                    dfs(i, j);
                }
            }
        }
        System.out.println(sum);
    }


    static void dfs(int x, int y) {

        int nx = 0, ny = 0;
        int[][] next = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        // || flag[x][y] < 0
        if (map[x][y] <= 0) {
            return;
        }

        for (int i = 0; i < 4; i++) {

            nx = next[i][0] + x;
            ny = next[i][1] + y;

            if (nx < 0 || nx > map.length - 1 || ny < 0 || ny > map[0].length - 1) {
                continue;
            }

            if (map[nx][ny] > 0 && flag[nx][ny] == 0) {
                flag[nx][ny] = - sum;
                dfs(nx, ny);
            }
        }

    }
}
