package fall2019.t11kuaishou;

import java.util.Scanner;

/**
 * in
 * 5
 * 2 4 5 6 9
 *
 * out
 * 0
 */
public class Main2 {

    static Integer min = Integer.MAX_VALUE;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        process(array, 0, 0, 0);
        System.out.println(min);
    }

    private static void process(int[] array, int i, int left, int right) {

        if (i == array.length) {
            int abs = Math.abs(left - right);
            if (min > abs) {
                min = abs;
            }
            return;
        }
        process(array, i + 1, left + array[i], right);
        process(array, i + 1, left, right + array[i]);
    }
}
