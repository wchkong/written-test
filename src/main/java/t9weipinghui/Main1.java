package t9weipinghui;

import java.util.*;

public class Main1 {

    static LFU lfu;

    public static void main(String[] args) {
        LFUCache(3);

        lfu.set(2, 2);
        lfu.set(1, 1);
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(2));
        lfu.set(3, 3);
        lfu.set(4, 4);
        System.out.println(lfu.get(3));
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(4));

    }


    /**
     * 初始化
     * @param n
     */
    static void LFUCache(int n) {
        lfu = new LFU(n);
    }
}

class LFU{
    /**
     * 元素个数
     */
    int max;
    HashMap<Integer, Integer> map;
    PriorityQueue<KeySort> minHeap;

    LFU(int max) {
        this.max = max;
        this.map = new HashMap<>();
        this.minHeap = new PriorityQueue<>(new MinHeapComparator());
    }

    public void set(int key, int value) {
        int size = map.size();
        if (size == max) {
            removeLast();
        }
        map.put(key, value);
        update(key);
    }

    public int get(int key) {
        update(key);
        return map.getOrDefault(key, -1);
    }

    private void update(int key) {

        if (!minHeap.contains(new KeySort(key))) {
            minHeap.add(new KeySort(key));
            return;
        }
        int count = 0;
        for (KeySort next : minHeap) {
            if (next.equals(new KeySort(key))) {
                count = next.count;
                break;
            }
        }
        minHeap.remove(new KeySort(key));
        minHeap.add(new KeySort(key, count + 1));

    }
    private void removeLast(){
        KeySort poll = minHeap.poll();
        if (poll != null) {
            map.remove(poll.key);
        }
    }

}

class MinHeapComparator implements Comparator<KeySort> {
    @Override
    public int compare(KeySort o1, KeySort o2) {
        if (o2.count < o1.count) {
            return 1;
        } else {
            return -1;
        }
    }
}

class KeySort {
    int key;
    int count;
    KeySort(int key) {
        this.key = key;
        this.count = 0;
    }

    KeySort(int key, int count) {
        this.key = key;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeySort keySort = (KeySort) o;
        return key == keySort.key;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
