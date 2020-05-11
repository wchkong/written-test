package fall2019.t6toutiao;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        int highest = 0;
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            int count = 0;
            int flag = 0;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[i]) {
                    continue;
                }
                if (flag < array[j]) {
                    count ++;
                    flag = array[j];
                }

            }
            if (max < count) {
                max = count;
                highest = array[i];
            }
        }

        System.out.println(highest);
    }
}
