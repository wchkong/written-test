package huawei.firstDay;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author kongweichang
 * @date 2021/8/14 6:09 下午
 * @desc :
 * @wiki :
 **/
public class HJ3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            TreeSet<Integer> set = new TreeSet<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                set.add(sc.nextInt());
            }
            for (Integer integer : set) {
                System.out.println(integer);
            }
        }
    }
}
