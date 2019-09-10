package DFS;

/**
 * https://blog.csdn.net/MaxLykoS/article/details/73555329
 * <p>
 * 求岛屿面积
 * <p>
 * 1，2，1，0，0，0，0，0，2，3
 * 3，0，2，0，1，2，1，0，1，2
 * 4，0，1，0，1，2，3，2，0，1
 * 3，2，0，0，0，1，2，4，0，0
 * 0，0，0，0，0，0，1，5，3，0
 * 0，1，2，1，0，1，5，4，3，0
 * 0，1，2，3，1，3，6，2，1，0
 * 0，0，3，4，8，9，7，5，0，0
 * 0，0，0，3，7，8，6，0，1，2
 * 0，0，0，0，0，0，0，0，1，0
 * <p>
 * 在这张二维地图中，数字代表海拔，0代表大海，求某一个点（比如6，8）所在岛屿的面积
 *
 * @Author: kongweichang
 * @Date: 2019/9/10 17:17
 */
public class DFS4 {

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

    static boolean[][] visited = new boolean[11][11];
    /**
     * 面积和
     */
    static int sum;

    public static void main(String[] args) {
        visited[0][0] = true;
        if (map[0][0] <= 0) {
            sum = 0;
        } else {
            sum = 1;
        }
        dfs(0, 0);
        System.out.println(sum);
    }


    static void dfs(int x, int y) {

        int nx = 0, ny = 0;
        int[][] next = { {0,1},{1,0},{0,-1},{-1,0} };

        for (int i = 0; i < 4; i++) {
            nx = x + next[i][0];
            ny = y + next[i][1];

            if (nx > map.length - 1 || nx < 0 || ny < 0 || ny > map[0].length - 1){
                continue;
            }

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                if (map[nx][ny] > 0) sum ++;
                dfs(nx, ny);
                //visited[nx][ny] = false;
            }
        }
    }
}
