package fall2019.t2xiaohongshu;

import java.util.*;

public class Main1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String all = sc.nextLine();
        char[] chars = all.toCharArray();

        // 筆記内容
        StringBuffer stringBuffer = new StringBuffer();
        // 括號栈
        int kuohao = 0;

        for (int i = 0; i < chars.length; i++) {

            char aChar = chars[i];
            if (aChar == '(') {
                kuohao ++;
            } else if (aChar == ')') {
                kuohao --;
            }

            if (kuohao > 0) {
                continue;
            }
            if (aChar == '<' ) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
                continue;
            }
            if (aChar != ')') {
                stringBuffer.append(aChar);
            }
        }
        System.out.println(stringBuffer.toString());

    }
}
