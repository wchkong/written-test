package t26qiniuyun;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        // a -() b - [] c - {} d - <>
        Stack<Integer> stacka = new Stack<>();
        Stack<Integer> stackb = new Stack<>();
        Stack<Integer> stackc = new Stack<>();
        Stack<Integer> stackd = new Stack<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            try {
                switch (aChar) {
                    case '(':
                        stacka.push(i);
                        break;
                    case ')':
                        Integer pop = stacka.pop();
                        if ((i - pop) % 2 == 0) {
                            System.out.print(0);
                            return;
                        }
                        break;
                    case '{':
                        stackb.push(i);
                        break;
                    case '}':
                        Integer pop1 = stackb.pop();
                        if ((i - pop1) % 2 == 0) {
                            System.out.print(0);
                            return;
                        }
                        break;
                    case '[':
                        stackc.push(i);
                        break;
                    case ']':
                        Integer pop2 = stackc.pop();
                        if ((i - pop2) % 2 == 0) {
                            System.out.print(0);
                            return;
                        }
                        break;
                    case '<':
                        stackd.push(i);
                        break;
                    case '>':
                        Integer pop3 = stackd.pop();
                        if ((i - pop3) % 2 == 0) {
                            System.out.print(0);
                            return;
                        }
                        break;
                    default:
                        System.out.print(0);
                        return;
                }
            } catch (EmptyStackException e) {
                System.out.print(0);
                return;
            }
        }

        if (stacka.isEmpty() && stackb.isEmpty() && stackc.isEmpty() && stackd.isEmpty()) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}
