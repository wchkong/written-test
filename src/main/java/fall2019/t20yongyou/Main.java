package fall2019.t20yongyou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * [35, 34, 35, 31, 29, 32, 36, 33]
 *
 * @Author: kongweichang
 * @Date: 2019/9/26 15:42
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String s1 = s.replaceAll("\\[", "");
        String s2 = s1.replaceAll("\\]", "");
        String s3 = s2.replaceAll(" ", "");
        String[] split = s3.split(",");
        int[] tArray = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            tArray[i] = Integer.valueOf(split[i]);
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            int x = tArray[i];
            list.add(0);
            for (int j = i + 1; j <split.length; j++) {
                if (tArray[j] > x) {
                    list.set(i, j - i);
                    break;
                }
            }
        }
        System.out.println(list);
    }
}
