package fall2019.t21duxiaoman;

import java.util.Scanner;

/**
 * 题目描述：
 * “你可曾听闻一招从天而降大掌法？”
 *
 *   在一部游戏中有这样一个技能，假设地图是一条直线，长度为n，人物所处的位置是x，则可以对x，2*x和2*x+1三格内的敌人分别造成一点伤害，要求2*x+1<=n。
 *
 *   设为这个地图的格子做标记为1-n，第i个格子中有一个血量为a_i的敌人。请问你至少使用多少次技能，可以杀死这个地图上所有敌人。
 *
 * 输入
 * 输入第一行包含一个正整数n,表示格子的数量(1<=n<=100)
 *
 * 输入第二行包含n个正整数a_i,表示第i个格子中敌人的血量。
 *
 * 输出
 * 输出仅包含一个正整数，即至少使用多少次技能。
 *
 *
 * 样例输入
 * 5
 * 1 2 3 4 5
 * 样例输出
 * 8
 * @Author: kongweichang
 * @Date: 2019/9/29 20:17
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 个数
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            while (a[i] != 0) {
                hit(a, i);
                count ++;
            }
            if (isSuccess(a)) {
                break;
            }
        }

        System.out.println(count);

    }


    static int[] hit (int[] a, int index) {
        if (index < a.length && a[index] > 0) {
            a[index] --;
        }
        if (2 * index < a.length && a[2 * index] > 0) {
            a[2 * index] --;
        }
        if (2 * index + 1 < a.length && a[2 * index + 1] > 0) {
            a[2 * index + 1] --;
        }

        return a;
    }

    static boolean isSuccess(int[] a) {
        boolean result = true;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}
