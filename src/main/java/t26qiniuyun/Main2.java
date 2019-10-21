package t26qiniuyun;

import java.util.Scanner;

/**

 10 1 2 3 5 5 5 5 5 5 5 5

 10 5 5 5 5 5 5 5 6 7 8 5

 10 1 2 3 4 5 6 7 8 9 10 5

 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        long[] arr = new long[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextLong();
        }
        long num = scanner.nextLong();
        int idx = findNum(arr, num);
        printStartAndEnd(arr, num, idx);
    }

    private static void printStartAndEnd(long[] arr, long num, int idx) {
        int a = idx, b = idx;
        if (idx == -1) {
            System.out.println(a + " " + b);
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if (arr[i] != num) {
                b = i - 1;
                break;
            } else if (i == arr.length - 1) {
                b = i;
            }
        }
        for (int i = idx; i >= 0; i--) {
            if (arr[i] != num) {
                a = i + 1;
                break;
            } else if (i == 0) {
                a = i;
            }
        }
        System.out.println(a + " " + b);
    }

    private static int findNum(long[] arr, long num) {

        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

}
