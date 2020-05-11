package Base.贪心;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *一块金条切成两半，是需要花费和长度数值一样的铜板的。比如长度为20的
 * 金条，不管切成长度多大的两半，都要花费20个铜板。一群人想整分整块金
 * 条，怎么分最省铜板？
 * 例如,给定数组{10,20,30}，代表一共三个人，整块金条长度为10+20+30=60.
 * 金条要分成10,20,30三个部分。
 * 如果，
 * 先把长度60的金条分成10和50，花费60
 * 再把长度50的金条分成20和30，花费50
 * 一共花费110铜板。
 * 但是如果，
 * 先把长度60的金条分成30和30，花费60
 * 再把长度30金条分成10和20，花费30
 * 一共花费90铜板。
 * 输入一个数组，返回分割的最小代价。
 */
public class LessMemory {


    static int lessMemory(int[] array, int cost) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new MinheapComparator());
        for (int i = 0; i < array.length; i++) {
            priorityQueue.add(array[i]);
        }

        while (priorityQueue.size() > 1) {
            Integer poll1 = priorityQueue.poll();
            Integer poll2 = priorityQueue.poll();
            int nowCost = poll1 + poll2;
            priorityQueue.add(nowCost);
            cost += nowCost;
        }

        return cost;
    }
    public static class MinheapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }

    }

    public static class MaxheapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }

    }

    public static void main(String[] args) {
        int[] array = {10, 20, 30};
        System.out.println(lessMemory(array, 0));
    }
}
