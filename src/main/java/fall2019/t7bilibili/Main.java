package fall2019.t7bilibili;

import java.util.Scanner;

/**
 * 两个字符串 word1 Word2
 *
 * word1 最少经过多少操作（插入，替换，删除一个字符）变成 word2
 * 打印最少次数
 *
 *
 * @Author: kongweichang
 * @Date: 2019/9/10 15:06
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();
        int count = 0;
        int length1 = word1.length();
        int length2 = word2.length();
        int rm = length2 > length1 ? 0 : length1 - length2;
        int add = length2 > length1 ? length2 - length1 : 0;
        int j = 0;
        for (int i = 0; i < length2 ; i++, j++) {
            if (j >= length1) {
                break;
            }
            char a = word1.charAt(j);
            char b = word2.charAt(i);
            if (a != b) {
                if (rm > 0) {
                    count ++;
                    rm --;
                    i --;
                } else if (add > 0) {
                    count ++;
                    add --;
                    j --;
                } else {
                    count ++;
                }
            }
        }
        if (rm > 0) {
            count += rm;
        }
        if (add > 0) {
            count += add;
        }
        System.out.println(count);
    }
}
