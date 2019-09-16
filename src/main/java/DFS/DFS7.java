package DFS;

import java.util.Stack;

/**
 * 栈实现？
 *
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
 * @Date: 2019/9/12 10:06
 */
public class DFS7 {

    static int count = 0;

    public static void main(String[] args) {

        dfs(4);
        System.out.println(count);
    }

    static void dfs(int N) {



        Stack<Bean> stack = new Stack<>();
        stack.push(new Bean(0, 1));

        while (!stack.empty()) {

            Bean peek = stack.peek();
            if (peek.sum > N) {
                stack.pop();
                continue;
            }
            if (peek.sum == N) {
                count ++;
                stack.pop();
                continue;
            }
            stack.push(new Bean(peek.sum + 1, 1));


            if (peek.sum > N) {
                stack.pop();
                continue;
            }
            if (peek.sum == N) {
                count ++;
                stack.pop();
                continue;
            }
            stack.push(new Bean(peek.sum + 2, 2));

        }
    }

    static class Bean{
        int sum;
        int v;
        boolean push;

        Bean(int sum, int v) {
            this.sum = sum;
            this.v = v;
            this.push = false;
        }
    }


}
