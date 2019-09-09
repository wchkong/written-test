package t3xiaomi;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^

    在某个存储介质以如下形式保存一棵二叉树

    1(2(3,4(,5)),6(7,))

    上述序列表示的二叉树如下


    观察后可以发现，每个节点的格式为

    X，X可以为空

    或者

    X(Y, Z)，其中X不为空

        3245176
    请编写程序将以上述格式输入的二叉树输出为中序遍历顺序
    ******************************开始写代码******************************/
    static String solution(String input) {
        StringBuilder stringBuffer = new StringBuilder();
        StringBuilder result = new StringBuilder();

        if (input.length() == 0) {
            return input;
        }
        Stack<Integer> stack = new Stack<>();
        char[] chars = input.toCharArray();
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < chars.length -2; i++) {
            char aChar = chars[i];
            char bChar = chars[i + 1];
            char cChar = chars[i + 2];

            stringBuffer.append(aChar);
            if (aChar >= '1' && aChar <= '9') {
                if (bChar != '(') {
                    stringBuffer.append(' ');
                    stringBuffer.append(' ');
                } else if (cChar == ',') {
                    stringBuffer.append(bChar);
                    stringBuffer.append(" ");
                    stringBuffer.append(cChar);
                    i = i + 2;
                }
            }

        }

        for (int i = 0; i < stringBuffer.length(); i++) {
            char aChar = stringBuffer.charAt(i);

            if (aChar >= '1' && aChar <= '9') {
                int i1 = aChar - '0';
                stack.push(i1);
            }
            if (aChar == ' ') {
                Integer pop = stack.pop();
                result.append(pop);
            }
        }
        return result.toString();
    }

    private static void updateIndex(List<Integer> index) {

        for (int i = 0; i < index.size(); i++) {
        }

    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        res = solution(_input);
        System.out.println(res);
    }
}
