package 贪心;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入：
 * 参数1，正数数组costs
 * 参数2，正数数组profits
 * 参数3，正数k
 * 参数4，正数m
 * costs[i]表示i号项目的花费
 * profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
 * k表示你不能并行、只能串行的最多做k个项目
 * m表示你初始的资金
 * 说明：你每做完一个项目，马上获得的收益，可以支持你去做下一个
 * 项目。
 * 输出：
 * 你最后获得的最大钱数。
 */
public class IPO {
    public static class Node {
        public int p;
        public int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }

    }

    public static class MaxProfitComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }

    }

    static int ipo(int k, int w, int[] profits, int[] capital) {

        Node[] nodes = new Node[profits.length];
        for (int i = 0; i < profits.length; i++) {
            nodes[i] = new Node(profits[i], profits[i]);
        }
        // 代价小根堆
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        // 收益大根堆
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());

        for (int i = 0; i < nodes.length; i++) {
            minCostQ.add(nodes[i]);
        }


        for (int i = 0; i < k; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().c < w) {
                Node poll = minCostQ.poll();
                maxProfitQ.add(poll);
            }

            if (maxProfitQ.isEmpty()) {
                return w;
            }
            w += maxProfitQ.poll().p;
        }
        return w;
    }



}
