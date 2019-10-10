package t23mihoyo;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            int nextInt = scanner.nextInt();
            arr[i] = nextInt;
            if (nextInt == 0) {zeroCount ++;}
        }
        Arrays.sort(arr);
        int count = 0;
        for (int i = zeroCount; i < n - 1; i++) {
            count += arr[i + 1] - arr[i] - 1;
        }
        if (n == 1) {
            if (arr[0] == 0) {
                System.out.print("YES+" + 1);
                return;
            } else {
                System.out.print("YES+" + 0);
                return;
            }
        } else if(n == zeroCount) {
            System.out.print("YES+" + zeroCount);
            return;
        }
        if (count == zeroCount) {
            System.out.print("YES+" + zeroCount);
        } else {
            System.out.print("NO+" + zeroCount);
        }

    }
}
