package t3xiaomi;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main1 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^


    ******************************开始写代码******************************/
    static int solution(int[] prices, int budget) {

        PriorityQueue<Integer> priceQueue = new PriorityQueue<>(new MaxHeapComparator());
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            priceQueue.add(price);
        }
        int count = 0;
        while (true) {
            Integer poll = priceQueue.poll();
            if (poll == null) {
                break;
            }
            if (poll > budget) {
                continue;
            }
            budget = budget - poll;
            if (budget >= 0) {
                count ++;
            } else {
                break;
            }

        }
        return count;
    }
    /******************************结束写代码******************************/

    /*
    5
    10000
    2000
    600
    400
    1
    1

    */

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _prices_size = 0;
        _prices_size = Integer.parseInt(in.nextLine().trim());
        int[] _prices = new int[_prices_size];
        int _prices_item;
        for(int _prices_i = 0; _prices_i < _prices_size; _prices_i++) {
            _prices_item = Integer.parseInt(in.nextLine().trim());
            _prices[_prices_i] = _prices_item;
        }

        int _budget;
        _budget = Integer.parseInt(in.nextLine().trim());

        res = solution(_prices, _budget);
        System.out.println(String.valueOf(res));

    }

    public static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 > o1) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}

