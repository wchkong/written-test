package t4tujia;

import java.util.*;

/**
 * 守望者的逃离
 *
 * 法师住在喜马拉雅上脚下的一个村庄，突然一天，发生大雪崩，很快村庄就要被掩埋，所有人将会遇难。
 *
 * 法师的跑步的速度为13m/s,以这样的速度，是无法逃离雪崩的。但是，法师有闪跳技能，可在1s内移动50m,每次使用技能后，会消耗10点魔法值。魔法值的恢复速度为4点/s,只有在原地休息状态时才能够恢复。
 *
 * 现已知法师初始值为M,所在位置与安全区域的距离为S,雪崩到达村庄的时间为T。
 *
 * 编写一个程序，计算法师如何在最短的时间内到达安全区域，如不能够逃脱，输出法师在时间内走的最远距离。
 *
 * 输入
 * 输入一行，包括空格隔开的三个非负整数M，S，T。
 *
 * 输出
 * 输出两行:
 *
 *
 * 第1行为字符串"Yes"或"No" (区分大小写)，即守望者是否能逃离荒岛。
 *
 *
 * 第2行包含一个整数，第一行为"Yes" (区分大小写）时表示守望着逃离荒岛的最短时间
 *
 *
 * 第一行为"No" (区分大小写) 时表示守望者能走的最远距离。
 *
 *
 * 样例输入
 * 36 255 10
 * 样例输出
 * Yes
 * 10
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 魔法初始值
        int M = in.nextInt();
        // 距离
        long S = in.nextLong();
        // 所有时间
        int T = in.nextInt();
        // 速度
        //int v = 13;
        // 闪跳
        int s = 50;
        double a = M % 10;
        double maxDistance = (M / 10) * 50 + (T - M / 10 + a/4) * 100 / 7;

        double last = 0;
        if (S % 50 >= 45.5) {
            last = 3.5;
        } else {
            last = (S  % 50) / 13D;
        }

        double fast = (double) ((int)(S / 50) * 10 - M) / 4 + last + S / 50;

        if (maxDistance >= S) {
            System.out.println("Yes");
            System.out.println((int)Math.nextUp(fast));
        } else {
            System.out.println("No");
            System.out.println(maxDistance);
        }
    }

}
