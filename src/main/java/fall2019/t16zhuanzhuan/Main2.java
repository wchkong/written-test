package fall2019.t16zhuanzhuan;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String[] split = s.split("@");
        if (split.length < 2) {
            System.out.println("");
            return;
        }

        String head = split[0];
        char[] chars = head.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        char[] mask = {'M', 'A', 'S', 'K'};

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            stringBuilder.append(aChar);
            if (i == chars.length - 1) {
                continue;
            }
            char c = mask[i % 4];
            stringBuilder.append(c);
        }
        stringBuilder.append('@');
        stringBuilder.append(split[1]);

        System.out.println(stringBuilder.toString());
    }

}
