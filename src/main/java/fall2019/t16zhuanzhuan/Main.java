package fall2019.t16zhuanzhuan;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static List<Character> list = Arrays.asList(
            '0','1','2','3','4','5','6','7','8','9',
            '`', '!', '@', '#', '$', '%', '^', '&','*', '(', ')', '{', '}', '\\', '<', '>', '?'
    );

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long l = in.nextLong();

        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        while (l >= 27) {
            long i = l % 27;
            l /= 27;
            stack.push(list.get((int) i));
        }
        if (l > 0) {
            stringBuilder.append(list.get((int) l));
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        System.out.println(stringBuilder.toString());
    }

}
