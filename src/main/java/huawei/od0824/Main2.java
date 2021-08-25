package huawei.od0824;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author kongweichang
 * @date 2021/8/24 10:59 下午
 * @desc :
 * @wiki :
 **/
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        int max = 0;
        for (int i = 0; i < split.length; i++) {
            for (int j = split.length - 1; j > i; j--) {
                int max1 = getMax(split[i], split[j]);
                if (max < max1) {
                    max = max1;
                }
            }
        }
        System.out.print(max);
    }

    private static int getMax(String s, String s1) {
        char[] chars = s.toCharArray();
        char[] chars1 = s1.toCharArray();
        List<Character> characters = new ArrayList<>();
        for (char aChar : chars) {
            characters.add(aChar);
        }
        for (char c : chars1) {
            if (characters.contains(c)) {
                return 0;
            }
        }
        return chars.length * chars1.length;
    }


}
