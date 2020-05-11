package fall2019.t17mafengwo;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int nextInt = in.nextInt();

        String[] split = s.split(",");
        int[] a = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            a[i] = Integer.valueOf(split[i]);
        }

        int index = -1;
        for (int i = 0; i < a.length; i++) {
            if (nextInt == a[i]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.print(-1);
        }

        System.out.print(a);

    }
}
