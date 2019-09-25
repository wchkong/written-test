package t19pdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 10 3 1 2 3 4 5 6 7 8 9 10
 * 20 4 1 2 3 4 5 6 7 8 9 10 11 12 33 21 12 16 17 18 19 20
 *
 * 求玩n次游戏后每次游戏选出的数乘积的和，最小值
 *
 * 排序之后把第i位和第2*m-1-i位相乘，乘出来的结果求和就行了
 *
 * @Author: kongweichang
 * @Date: 2019/9/25 14:39
 */
public class Main1 {

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 数据个数
        int N = sc.nextInt();
        // 游戏轮次
        int M = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        process(list, 0, M, new ArrayList<>());
        System.out.println(min);
    }

    private static void process(List<Integer> list, int i, int M, List<Integer> res) {

        if (i >= M || list.size() <= 1) {
            int count = 0;
            for (int j = 0; j < res.size(); j++) {
                count += res.get(j);
            }
            if (count < min ) {
                min = count;
            }
            return;
        }

        for (int j = 0; j < list.size(); j++) {
            for (int k = (list.size() - 1); k > j; k--) {
                //System.out.println(list);
                Integer int1 = list.get(j);
                Integer int2 = list.get(k);
                list.remove(int1);
                list.remove(int2);
                res.add(int1 * int2);

                process(list, ++i, M, res);

                Integer i1 = int1 * int2;
                res.remove(i1);
                list.add(j, int1);
                list.add(k, int2);
                --i;
            }
        }

    }
}
