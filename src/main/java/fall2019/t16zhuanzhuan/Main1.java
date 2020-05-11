package fall2019.t16zhuanzhuan;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] m = new int[200];
        for (int i = 0; i < 200; i++) {
            m[i] = in.nextInt();
        }

        Arrays.sort(m);
        System.out.println(m[198]);
    }
}
