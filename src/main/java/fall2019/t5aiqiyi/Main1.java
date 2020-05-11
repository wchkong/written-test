package fall2019.t5aiqiyi;

import java.util.Scanner;

/**
 * 有一个非常经典的概率问题，是一个袋子里面有若干个红球和若干个蓝球，两个人轮流取出一个球，谁先取到红球谁就赢了，
 * 当人的先后顺序和球的数量确定时，双方的胜率都可以由计算得到，这个问题显然是很简单的。
 *
 * 现在有一个进阶版的问题，同样是一个袋子里面有n个红球和m个蓝球，共有A，B，C三人参与游戏，
 * 三人按照A，B，C的顺序轮流操作，在每一回合中，A，B，C都会随机从袋子里面拿走一个球，
 * 然而真正分出胜负的只有A，B两个人，没错，C就是来捣乱的，他除了可以使得袋子里面减少一个球，
 * 没有其他任何意义，而A，B谁 先拿到红球就可以获得胜利，但是由于C的存在，两人可能都拿不到红球，此时B获得胜利。
 *
 * 输入
 * 输入仅包含两个整数n和m,表示红球和蓝球的数量，中间用空格隔开。(0<=n,m<=1000)
 *
 * 输出
 * 请你输出A获胜的概率，结果保留5位小数。（四舍五入）
 *
 *
 * 样例输入
 * 1 1
 * 样例输出
 * 0.50000
 *
 * 提示
 * 输入样例2
 * 3 4
 * 输出样例2
 * 0.62857
 */
public class Main1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 红球
        int n = in.nextInt();
        // 篮球
        int m = in.nextInt();


        double v = process1(n, m);
        if (v > 1) {
            v = v - 1;
        }
        System.out.println(String.format("%.5f", v));

    }

    public static double process1(int n, int m) {
        if (n + m <= 3) {
            if (n == 1 && m == 1) {
                return 0.5D;
            }
            if (n == 1 && m == 2) {
                return 1/3D;
            }
            if (n == 2 && m == 1) {
                return 2/3D;
            }
            if (n == 0) {
                return 0.0D;
            }
            if (m == 0) {
                return 1.0D;
            }
            return 0D;
        }

        return (n * 1.0D) / (n + m) + ((n * 1.0D) / (n + m -2)) * process1(n - 1, m-2)
                + (1.0D * (m - 2) / (n + m - 2)) * process1(n, m - 3);
    }
}
