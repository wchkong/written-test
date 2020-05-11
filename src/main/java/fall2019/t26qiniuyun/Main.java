package fall2019.t26qiniuyun;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        int sum = scanner.nextInt();

        int a = -1, b = -1;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] + arr[j] == sum) {
                    a = i;
                    b = j;
                }
            }
        }
        System.out.println(a + " " + b);
    }
}
