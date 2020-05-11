package fall2019.t24yitu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
// 10 1 2 3 4 5 6 7 8 9 10
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Integer[] v = new Integer[n];
        for (int i = 0; i < n; i++) {
            v[i] = scanner.nextInt();
        }

        Arrays.sort(v);
        List<Integer> vl = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vl.add(v[i]);
        }
        int count = 0;
        int i = n - 1;
        while (i >= 0) {
            Integer integer = vl.get(i);
            int i1 = integer / 2;
            int i2 = binarySearch(vl, i1);
            if (i2 >= 0) {
                vl.remove(i);
                vl.remove(i2);
                count ++;
                i --;
            }
            i --;
        }
        count += vl.size();
        System.out.print(count);
    }

    public static int binarySearch(List<Integer> list, int tar) {
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = (end + start) >>> 1;
            if (tar == list.get(mid)) {
                return mid;
            } else if (tar < list.get(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        int start1 = 0;
        int end1 = list.size() - 1;
        while (start1 <= end1) {
            int mid = (end1 + start1) >>> 1;
            if (mid - 1 >= 0 && tar < list.get(mid) && tar > list.get(mid - 1)) {
                return mid - 1;
            } else if (mid + 1 < list.size() && tar > list.get(mid) && tar < list.get(mid + 1)) {
                return mid;
            } else if (tar < list.get(mid)) {
                end1 = mid - 1;
            } else {
                start1 = mid + 1;
            }
        }
        return -1;
    }


}
