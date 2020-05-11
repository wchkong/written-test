package fall2019.t2xiaohongshu;

import java.util.*;
import java.util.Scanner;

public class Main {

    static class Point {
        int x;
        int y;

        Point() {}

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        List<Point> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.add(new Point(x, y));
        }

        Stack<Point> stack = new Stack<>();
        List<Point> hasPass = new ArrayList<>();
        stack.push(new Point(0,0));
        int stepCount = 0;
        while (!stack.empty()) {
            Point pop = stack.pop();
            hasPass.add(pop);
            boolean b = hasNextStep(null, pop, list, n, m, stack, hasPass);
            if (b) {
                stepCount ++;
            }
            boolean contains = stack.contains(new Point(n - 1, m - 1));
            if (contains) {
                System.out.println(stepCount);
                return;
            }
        }



        System.out.println(0);

    }

    public static boolean hasNextStep(Point perPoint, Point point, List<Point> points, int n, int m, Stack<Point> stack, List<Point> hasPass) {
        boolean result = false;
        int x = point.getX();
        int y = point.getY();
        if (x > 0) {
            Point point1 = new Point(x - 1, y);
            if (!hasPass.contains(point1)) {
                result = !points.contains(point1);
                if (result) {
                    stack.push(point1);
                }
            }
        }
        if (y > 0) {
            Point point1 = new Point(x, y - 1);
            if (!hasPass.contains(point1)) {
                boolean contains = !points.contains(point1);
                result = result || contains;
                if (contains) {
                    stack.push(point1);
                }
            }
        }
        if (x < n) {
            Point point1 = new Point(x + 1, y);
            if (!hasPass.contains(point1)) {
                boolean contains = !points.contains(point1);
                result = result ||  contains;
                if (contains) {
                    stack.push(point1);
                }
            }
        }
        if (y < n) {
            Point point1 = new Point(x, y + 1);
            if (!hasPass.contains(point1)) {
                boolean contains = !points.contains(point1);
                result = result || contains;
                if (contains) {
                    stack.push(point1);
                }
            }
        }

        return result;
    }


}
