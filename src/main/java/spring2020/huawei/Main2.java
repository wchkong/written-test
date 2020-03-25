package spring2020.huawei;

import java.util.*;

/**
 * 3 5
 * 8 4 3 1 10
 *
 *
 **/
public class Main2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // 处理器个数
        int m = scanner.nextInt();
        // 作业数
        int n = scanner.nextInt();
        // 任务时间排序
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MinHeapComparator());
        for (int i = 0; i < n; i++) {
            minHeap.add(scanner.nextInt());
        }
        // cpu时间排序
        List<Integer> cpuTime = new ArrayList<>();
        int[] cpuTimeArray = new int[m];

        while (!minHeap.isEmpty()) {
            Arrays.sort(cpuTimeArray);
            cpuTimeArray[0] += minHeap.poll();
        }
        Arrays.sort(cpuTimeArray);
        System.out.println(cpuTimeArray[m - 1]);
    }

    public static class MinHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o2, Integer o1) {

            if (o2 > o1) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
