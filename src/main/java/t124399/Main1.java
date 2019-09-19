package t124399;

/**
 * @Author: kongweichang
 * @Date: 2019/9/18 9:39
 */
public class Main1 {
    public static void main(String[] args) {

        test(null);

    }


    static void test(String s) {
        System.out.println(s);
    }

    static void test(Object o) {
        System.out.println("hello");
    }
}
