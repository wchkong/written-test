package t7bilibili;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        if (split.length != 3) {
            return;
        }
        List<String> keyValue = new ArrayList<>();
        String pairsDelimiter = split[0];
        String delimiter = split[1];
        String str = split[2];

        String[] pairs = str.split(pairsDelimiter);
        for (int i = 0; i < pairs.length; i++) {
            String pair = pairs[i];
            String[] subStr = pair.split(delimiter);
            if (subStr.length != 2) {
                continue;
            }
            keyValue.add(subStr[0] + ' ' + subStr[1]);
        }

        System.out.println(keyValue.size());
        for (String kv : keyValue) {
            System.out.println(kv);
        }
    }
}
