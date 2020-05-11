package Base.DFS;

/**
 * 有一长度为N(1 <= Ｎ <= 10)的地板，给定两种不同瓷砖：一种长度为1，另一种长度为2，数目不限。
 * 要将这个长度为N的地板铺满，一共有多少种不同的铺法？
 * 例如，长度为4的地面一共有如下5种铺法：
 * 4 = 1 + 1 + 1 + 1
 * 4 = 2 + 1 + 1
 * 4 = 1 + 2 + 1
 * 4 = 1 + 1 + 2
 * 4 = 2 + 2
 *
 * @Author: kongweichang
 * @Date: 2019/9/10 18:02
 */
public class DFS6 {

    static int count = 0;

    public static void main(String[] args) {

        dfs(0, 4);
        System.out.println(count);
    }

    static void dfs(int n, int N) {

        if (n > N) {
            return;
        }
        if (n == N) {
            count ++;
        }
        dfs(n + 1, N);
        dfs(n + 2, N);
    }
}
