package base.KMP;

/**
 * @Author: kongweichang
 * @Date: 2019/9/27 12:12
 */
public class Main {
    public static void main(String[] args) {


        System.out.println(findLongest("1AB2345CD", 9, "12345EF", 7));

    }

    public static int findLongest(String A, int n, String B, int m) {
        // write code here
        if (n == 0 || m == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int now = 0;
            for (int j = 0; j < m; j++) {
                int x = 0;
                int a = i;
                int b = j;
                while (A.charAt(a) == B.charAt(b)) {
                    x++;
                    a++;
                    b++;
                }
                if (now < x) {
                    now = x;
                }
            }
            if (now > max) {
                max = now;
            }
        }
        return max;
    }

}
