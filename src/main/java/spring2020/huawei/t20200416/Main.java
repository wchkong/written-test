package spring2020.huawei.t20200416;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Integer[] a = {5,6,7,8,9,0,0};
        int[] b = {4,5,6};
        mergeArr(a, b, 5,2);
    }


    private static void mergeArr(Integer[] nums1, int[] nums2, int m, int n) {
        // 两个数组对应的指针
        int f1 = 0;
        int f2 = 0;
        while (f2 < n) {
            int i1 = nums1[f1];
            int i2 = nums2[f2];
            if (i1 <= i2 && f1 < m) {
                f1++;
            } else if (f1 >= m) {
                nums1[f1] = i2;
                f2 ++;
                f1 ++;
                m ++;
            } else {
                mergeOne(nums1, f1, i2, m);
                f2 ++;
                f1 ++;
                m ++;
            }
        }
        System.out.println(Arrays.asList(nums1));
    }

    private static void mergeOne(Integer[] nums1, int f1, int i2, int m) {

        if (m < nums1.length) {
            for (int i = m - 1;  i >= f1; i --) {
                nums1[i + 1] = nums1[i];
            }
            nums1[f1] = i2;
        }
    }
}
