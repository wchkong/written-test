package spring2020.huawei.t20200416;

import java.util.Arrays;
import java.util.List;

public class Main1 {

    /**
     * 给出一个整数数组，找到一个具有最大和的连续子数组
     * 数字可能有正有负
     * 输入：[-2,1,-3,4,-1,2,1,-5,4]
     * 输出：[4,-1,2,1]
     *
     * @param args
     */
    public static void main(String[] args) {

        Integer[] arr = {-1, 1, -2, 2, 3, 4, 5, 6, 1};
        getMaxSumSubArray(arr);
    }

    private static void getMaxSumSubArray(Integer[] arr) {
        // 整个数组都是负数的特殊判断
        int maxValue = Integer.MIN_VALUE;
        int maxValueIdx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                maxValueIdx = i;
            }
        }
        if (maxValue < 0) {
            System.out.println(maxValue);
            List<Integer> integers = Arrays.asList(arr);
            List<Integer> subList = integers.subList(maxValueIdx, maxValueIdx + 1);
            System.out.println(subList);
            return;
        }

        // 当前和
        int sum = 0;
        // 最大和
        int maxSum = Integer.MIN_VALUE;
        // 当前和成员的左右下标
        int l = 0;
        int r = 0;
        // 最大和成员的左右下标
        int maxL = 0;
        int maxR = 0;
        for (int i = 0; i < arr.length; i++) {
            int now = arr[i];
            sum += now;
            r = i;
            if (sum < 0) {
                sum = 0;
                l = i + 1;
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxL = l;
                maxR = r;
            }

        }

        System.out.println(maxSum);
        List<Integer> integers = Arrays.asList(arr);
        List<Integer> subList = integers.subList( maxL, maxR + 1);
        System.out.println(subList);
    }


}
