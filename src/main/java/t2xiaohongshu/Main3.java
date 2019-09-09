package t2xiaohongshu;

import java.util.*;

public class Main3 {

    static class Baowu {
        long X;
        long Y;

        public Baowu() {
        }

        public Baowu(long x, long y) {
            X = x;
            Y = y;
        }

        public long getX() {
            return X;
        }

        public void setX(long x) {
            X = x;
        }

        public long getY() {
            return Y;
        }

        public void setY(long y) {
            Y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Baowu baowu = (Baowu) o;
            return X == baowu.X &&
                    Y == baowu.Y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(X, Y);
        }

        public static boolean compare(Baowu baowu1, Baowu baowu2) {
            return  Math.max(baowu1.X , baowu1.Y) <= Math.max(baowu2.X , baowu2.Y) && (baowu1.X <= baowu2.X || baowu1.Y <= baowu2.Y);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        PriorityQueue<Baowu> minHeap = new PriorityQueue<>(new MinHeapComparator());

        for (int i = 0; i < N; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            minHeap.add(new Baowu(x, y));
        }
        int count = 0;

        Baowu poll = minHeap.poll();
        long maxX  = 0;
        long maxY  = 0;

        while (poll != null) {
            if (poll.getX() >= maxX && poll.getY() >= maxY) {
                maxX = poll.getX();
                maxY = poll.getY();
                count ++;
            }
            boolean empty = minHeap.isEmpty();
            if (empty) {
                System.out.println(count);
            }
            poll = minHeap.poll();
        }
    }

    public static class MinHeapComparator implements Comparator<Baowu> {
        @Override
        public int compare(Baowu o2, Baowu o1) {

            if (Baowu.compare(o1, o2)) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
