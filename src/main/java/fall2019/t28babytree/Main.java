package fall2019.t28babytree;


/**
 * 题目描述：
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 * <p>
 * 说明：
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，
 * 则他们的身高满足存在i（1<=i<=K）使得Ti<T2<......<Ti-1<Ti>Ti+1>......>TK。
 * <p>
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 * <p>
 * 输入
 * 整数N，一行整数 ，空格分开 ，N位同学身高
 * <p>
 * 输出
 * 最少需要几位同学出列
 * <p>
 * 样例输入
 * 8 186 186 150 200 160 130 197 200
 * 样例输出
 * 4
 * 解释：
 * 队形如下
 * 150 200 160 130
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int minCount = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] heightArray = new int[n];
        for (int i = 0; i < n; i++) {
            heightArray[i] = scanner.nextInt();
        }

        process(heightArray, 0, 0, new ArrayList<>());
        System.out.println(minCount);
    }

    public static boolean checkQueue(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        int max = -1;
        for (int i = 0; i < array.length - 1; i++) {
            int now = array[i];
            int next = array[i + 1];
            if (max < 0) {
                if (now > next) {
                    if (i == 0) {
                        return false;
                    } else {
                        max = now;
                    }
                }
            } else {
                if (now < next) {
                    return false;
                }
            }
        }

        return max > 0;
    }

    public static void process(int[] array, int idx, int length, List<Integer> now) {
        if (array == null || array.length == 0) {
            return ;
        }
        if (array.length == idx) {
            if (array.length - length  < minCount)
                minCount = array.length - length;
            return ;
        }
        process(array, idx + 1, length, now);
        now.add(array[idx]);
        Integer[] integers = new Integer[now.size()];
        Integer[] objects = now.toArray(integers);
        if (checkQueue(objects)) {
            process(array, idx + 1, length + 1, now);
        }
    }

    private static boolean checkQueue(Integer[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return checkQueue(newArray);
    }
}
