package fall2019.t14didi;

import java.util.Scanner;

/**
 * 第一行包含一个正整数n，m,表示数组的大小和所选区间的最小长度。(1<=n<100000)第二行包含n个整数，中间用空格隔开0<=|ai|<=1000。
 *
 * 输出
 * 输出仅包含一个正整数，表示所选区间的和。
 *
 *
 * 样例输入
 * 5 3
 * 1 2 3 4 5
 * 样例输出
 * 6
 *
 * 提示
 * 补充样例
 * 输入样例2
 * 5 3
 * -2 1 -1 -1 -1
 * 输出样例2
 * -4
 *
 * 10 5 1 2 -4 3 5 -8 -9 -10 5 -11
 */
public class Main1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int sum = 0;

        int l = 0,r = 0;
        for (int i = 0; i < n; i++) {

            if (r - l < m) {
                sum += array[r];
                r ++;
                continue;
            }
            int s = 0;
            for (int j = 0; j < m; j++) {
                s += array[r - m];
            }
            if (s < sum + array[r]) {
                l = r - m;
                sum = s;
                r++;
                continue;
            }
            if (array[r] <= 0) {
                if (array[l] <= 0) {
                    sum += array[r];
                    r ++;
                } else {
                    sum += array[r];
                    r ++;
                    sum -= array[l];
                    l ++;
                }
            } else if (array[r] <= array[l]){
                sum += array[r];
                r ++;
                sum -= array[l];
                l ++;
            }
        }

        System.out.println(sum);
    }
}
