package fall2019.maoyan;

import java.util.ArrayList;
import java.util.List;

public class Test {

    /**
     * 1.求链表的中间结点
     * 思路：两个指针，一个一次走一步，一个一次走两步，走得快的到底了，走得慢的正好在中间
     * startTime 2019/10/16 19:11
     * endTime 2019/10/16 19:20
     *
     */
    public static Node midNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast == null) {
            // 偶数个元素，返回中间两个的前一个
            return slow;
        } else {
            // 奇数个元素，返回中间的节点
            return slow;
        }

    }

    class Node {
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


    /**
     *  2.计算M的N次方，M、N是正整数，考虑算法的性能
     *  思路：不考虑数字越界的情况下
     *  尽量少的使用乘法，既使用动态规划的思想把前面乘过的保存下来,然后使用
     *  startTime 2019/10/16 19:20
     *  endTime 2019/10/16 19:57
     */
    public static long getProduct(long M, long N) {

        if (N == 0) {
            return 1;
        }
        if (N == 1) {
            return M;
        }

        List<Long> list = new ArrayList<>();
        long a = N;
        long s = 2;
        while (a / 2 != 0) {
            if (list.size() >= 1) {
                Long aLong = list.get(list.size() - 1);
                list.add(aLong * aLong);
            } else {
                list.add(M * M);
            }
            a /= 2;
            s *= 2;
        }
        s = N - s;
        long result = list.get(list.size() - 1);
        while (s / 2 != 0) {
            result *= list.get(0);
            s /= 2;
        }
        if (s == 1) {
            result *= M;
        }
        return result;
    }

    public static void main(String[] args) {
        long product = getProduct(10, 12);
        System.out.print(product);
    }
}
