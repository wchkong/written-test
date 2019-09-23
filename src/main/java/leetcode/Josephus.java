package leetcode;

import java.util.Scanner;

/**
 * Josephus problem
 * 约瑟夫问题
 * 丢手绢问题
 *
 * 在一间房间总共有n个人（下标0～n-1），只能有最后一个人活命。
 *
 * 按照如下规则去杀人：
 * 所有人围成一圈
 * 顺时针报数，每次报到q的人将被杀掉
 * 被杀掉的人将从房间内被移走
 * 然后从被杀掉的下一个人重新报数，继续报q，再清除，直到剩余一人
 *
 *
 * 输入
 * 人的个数 : n
 * 每次报到q 就会被杀死 的 q
 *
 * 输出
 * 最终能够活下来的人的下标
 *
 * 參考：https://www.jianshu.com/p/b76d49462a46
 */
public class Josephus {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        // f(n) = (f(n - 1) + q) % n
        // 最後存活index為0的人 即 f(n) = 0; 倒推
        if (n == 0) {
            return;
        }
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + q) % i;
        }
        // 0 - n-1
        System.out.println(result);
    }

}
