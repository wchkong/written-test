package t19pdd;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: kongweichang
 * @Date: 2019/9/25 16:08
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a的数量
        int N = sc.nextInt();
        // b的数量
        int M = sc.nextInt();
        long K = sc.nextLong();

        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int acount = 0;
        int bcount = 0;
        while (true) {
            if (i == K) {
                break;
            }

            if (i < N) {
                stack.add('a');
                acount ++;
            } else if (i < N + M) {
                stack.add('b');
                bcount ++;
            } else if (i == N + M){
                while(stack.peek() != 'a') {
                    char x = stack.pop();
                    if (x == 'a') {
                        acount --;
                    }
                    if (x == 'b') {
                        bcount --;
                    }
                }
                stack.pop();
                acount --;
                stack.add('b');
                bcount ++;
            } else {
                if (acount < N) {
                    stack.add('a');
                } else if (bcount < M){
                    stack.add('b');
                } else {

                }

            }

            i ++;

        }
        int size = stack.size();
        for (int j = 0; j > size; j++) {
            Character pop = stack.pop();
            stringBuilder.append(pop);
        }
        StringBuilder reverse = stringBuilder.reverse();
        System.out.println(reverse.toString());
    }

}
