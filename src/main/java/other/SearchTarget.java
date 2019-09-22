package other;

import java.io.File;
import java.util.Scanner;

public class SearchTarget {

    public static void main(String[] args) {

        int[][] ints = new int[10][10];
        for (int i = 0; i < 10; i++) {
            ints[i][0] = i;
        }
        for (int j = 0; j < 10; j++) {
            ints[0][j] = j;
        }
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                ints[i][j] = ints[i - 1][j] + ints[i][j - 1] + (int) (Math.random() * 10);
            }
        }
        for (int i = 0; i < 100; i++) {
            boolean find = Find((int) (Math.random() * 100), ints);
            System.out.println(find);
        }
    }


    public static boolean Find(int target, int[][] array) {
        if (array.length == 0) {
            return false;
        }
        if (target < array[0][0]) {
            return false;
        } else if (target > array[array.length - 1][array[0].length - 1]) {
            return false;
        }
        int x = array[0].length - 1;
        int y = 0;
        while (x >= 0 && y < array.length && y >= 0 && x < array[0].length) {

            int now = array[x][y];
            if (now == target) {
                return true;
            } else if (now < target) {
                x--;
            } else if (now > target) {
                y++;
            }

        }
        return false;
    }
}
