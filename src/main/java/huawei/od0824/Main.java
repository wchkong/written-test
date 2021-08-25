package huawei.od0824;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author kongweichang
 * @date 2021/8/24 10:08 下午
 * @desc : 基于N进制的减法操作
 * @wiki :
 * <p>
 * 35 adhjadjkhajskjasdkjkhjkhasdjkhadadsjahjskdhjkaskhjaskjha ashjjadsajkskjlaskljaskljsakljdas
 * <p>
 * 35 ashjjadsajkskjlaskljaskljsakljdas adhjadjkhajskjasdkjkhjkhasdjkhadadsjahjskdhjkaskhjaskjha
 **/
public class Main {

    private static List<Character> values = Arrays.asList(
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
    );

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //输入三个参数 N 进制  a 被减数  b 减数
        String allIn = sc.nextLine();
        String[] s1 = allIn.split(" ");
        if (s1.length != 3) {
            System.out.println(-1);
            return;
        }
        int N = Integer.parseInt(s1[0].trim());
        String a = s1[1].trim();
        String b = s1[2].trim();
        // 参数校验
        if (N > 35 || N < 2 || a.startsWith("0") || b.startsWith("0") || a.length() > 100 || b.length() > 100 || a.length() <= 0 || b.length() <= 0) {
            System.out.println(-1);
            return;
        }
        // 转换进制成十进制
        try {
            // 1.按位补齐
            int max = Math.max(a.length(), b.length());
            if (a.length() < max) {
                StringBuilder aS = new StringBuilder();
                for (int i = 1; i <= max - a.length(); i++) {
                    aS.append('0');
                }
                aS.append(a);
                a = aS.toString();
            }
            if (b.length() < max) {
                StringBuilder bS = new StringBuilder();
                for (int i = 1; i <= max - b.length(); i++) {
                    bS.append('0');
                }
                bS.append(b);
                b = bS.toString();
            }
            // 2.比大小确定符号
            int signal = getSignal(a, b);
            // 3.大 - 小 按位相减
            String rst = signal == 0 ? strMinus(a, b, N) : strMinus(b, a, N);
            System.out.print(signal);
            System.out.print(" ");
            System.out.println(rst);
        } catch (Exception e) {
            System.out.println(-1);
            return;
        }
    }

    private static String strMinus(String big, String small, int N) {
        StringBuilder stringBuilder = new StringBuilder();
        int borrow = 0;
        int nextBorrow;
        for (int i = 0; i < big.length(); i++) {
            nextBorrow = 0;
            int idx = big.length() - 1 - i;
            int bigCur = values.indexOf(big.charAt(idx));
            int smallCur = values.indexOf(small.charAt(idx));
            if (bigCur < smallCur + borrow) {
                nextBorrow = 1;
                bigCur += N;
            }
            int minus = bigCur - smallCur - borrow;
            Character character = values.get(minus);
            stringBuilder.append(character);
            borrow = nextBorrow;
        }
        StringBuilder reverse = stringBuilder.reverse();
        String s = reverse.toString();
        while (s.startsWith("0") && s.length() > 1) {
            reverse.deleteCharAt(0);
            s = reverse.toString();
        }
        return s;
    }

    /**
     * 0 整数，1 负数
     *
     * @param a
     * @param b
     * @return
     */
    private static int getSignal(String a, String b) {
        char[] aC = a.toCharArray();
        char[] bC = b.toCharArray();
        for (int i = 0; i < aC.length; i++) {
            if (aC[i] > bC[i]) {
                return 0;
            } else if (aC[i] < bC[i]) {
                return 1;
            }
        }
        return 0;
    }
}
