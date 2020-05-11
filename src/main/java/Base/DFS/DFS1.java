package Base.DFS;

import java.util.Scanner;

/**
 * 输入一个数n，输入1~n的全排列
 *
 * 比如123 132 213 231 312 321
 *
 * @Author: kongweichang
 * @Date: 2019/9/10 15:05
 */
public class DFS1 {

    static class Node {
        int num = 0;
        boolean outHand = false;
    }
    static int n;
    static Node[] nodes;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
        dfs(0);
    }

    static void dfs(int step) {
        // 判断边界，此时所有数都放到了容器中
        if (step == n ) {
            for (int i = 0; i < n; i++) {
                // 输出容器中的状态
                System.out.print(nodes[i].num);
            }
            System.out.println();
            // 返回到堆栈中上一个递归状态
            return;
        }
        // 尝试每一种可能
        for (int i = 0; i < n ; i++) {
            // 前提是这个n还没有放入
            if (!nodes[i].outHand) {
                // 把1-n放入容器nodes中
                nodes[step].num = i + 1;
                // 改变状态
                nodes[i].outHand = true;
                // 递归下一步
                dfs(step + 1);
                // 下一步昨晚后，恢复之前状态
                nodes[i].outHand = false;
            }
        }
        return;
    }

}
