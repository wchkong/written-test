package t6toutiao;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        int k = in.nextInt();

        if (k > (x + y + z)) {
            System.out.println(-1);
            return;
        }


    }
}
