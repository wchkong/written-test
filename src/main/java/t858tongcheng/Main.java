package t858tongcheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String[] numberStr = s.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numberStr.length; i++) {
            String s1 = numberStr[i];
            Integer integer = Integer.valueOf(s1);
            list.add(integer);
        }
        int count = 0;
        int last = -1;
        for (int i = 0; i < list.size(); i++) {
            Integer now = list.get(i);
            if (now != last) {
                count ++;
            }
            last = now;
        }
        System.out.println(count);
    }

}
