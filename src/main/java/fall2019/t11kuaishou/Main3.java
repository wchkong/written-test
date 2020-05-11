package fall2019.t11kuaishou;

import java.util.*;

/**
 * 求一组数中，最长等差序列长度
 */
public class Main3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else if (o1.equals(o2)) {
                    return 0;
                }
                return -1;
            }
        });

        int size = list.size();
        int max = 0;
        if (size == 0) {
            System.out.println(max);
        }

        int[][] dp = new int[size][list.get(size - 1) - list.get(0) + 1];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < list.get(size - 1) - list.get(0) + 1; j++) {
                dp[i][j] = 1;
            }
        }

        for (int i = 1; i < size; i++) {
            for (int j = i - 1; j >= 0 ; j--) {
                int i1 = list.get(i) - list.get(j);
                dp[i][i1] = dp[j][i1] + 1;
                if (dp[i][i1] > max) {
                    max = dp[i][i1];
                }
            }
        }

        System.out.println(max);
    }

}
