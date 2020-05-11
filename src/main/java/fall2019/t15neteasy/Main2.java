package fall2019.t15neteasy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//2 5 1 3 9 2 6 5 4 2 9 16 7
//1 6 1 2 1 4 9 18
// 1 10 1 2 4 8 16 32 64 128 256 512
//1 12 1 2 3 4 12 24 10 100 200 400 1000 10000

public class Main2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            list.add(a);
        }

        for (int[] a : list){
            int l = getMaxSub(a);
            System.out.println(l);
        }

    }

    private static int getMaxSub(int[] a) {

        if (a.length == 0) {
            return 0;
        }
        if (a.length == 1) {
            return 1;
        }

        int[] sum = new int[a.length];
        sum[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            sum[i] = a[i] + sum[i - 1];
        }
        int maxl = 1;
        int nowl = 1;
        for (int i = 1; i < sum.length; i++) {
            if (a[i] >= sum[i-1]) {
                nowl ++;
            } else {
                nowl = 0;
            }
            if (nowl > maxl) {
                maxl = nowl;
            }
        }
        return maxl;
    }
}
