package base.DFS;

/**
 * 寻找满足ABC+DEF=GHI的情况有多少
 *
 * 比如173+286=459
 *
 * @Author: kongweichang
 * @Date: 2019/9/10 15:26
 */
public class DFS2 {

    static int total;
    static boolean[] outHand = new boolean[9];
    static int[] list = new int[9];

    public static void main(String[] args) {

        dfs(0);
        System.out.println(total);
    }

    static void dfs(int step) {

        if (step == 9) {
            if ( (list[0] * 100 + list[1] * 10 + list[2] + list[3] * 100 + list[4] * 10 + list[5]) ==
                    (list[6] * 100 + list[7] * 10 + list[8])) {
                total ++;
                for (int i = 0; i < list.length; i++) {
                    System.out.print(list[i] + " - ");
                }
                System.out.println();
            }
        }

        for (int i = 0; i < list.length; i ++) {

            // outhand 此位置还没处理
            if (!outHand[i]) {
                list[step] = i + 1;
                outHand[i] = true;
                dfs(step + 1);
                outHand[i] = false;
            }
        }
    }

}
