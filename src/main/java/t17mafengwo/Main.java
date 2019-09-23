package t17mafengwo;

import java.util.*;

/**
 * 题目描述：
 * 马蜂窝大数据部门的同事需要根据用户签到记录，统计出十一假期热门旅游目的地排行榜
 *
 * 输入
 * 输入为用户ID及用户签到的城市名称
 *
 * 输出
 * 签到用户最多的前3个目的地及签到用户数
 *
 * -       同一个用户多次签到同一个城市，只记一次
 *
 * -       签到用户数相同的城市，优先展示拼音顺序靠前的城市名
 *
 *
 * 样例输入
 * 34839946-beijing 34839946-shanghai 42342124-hongkong 42342124-guilin 42342124-guilin 12312344-shanghai 12312344-shanghai 22341234-nanjing
 * 样例输出
 * shanghai 2
 * beijing 1
 * guilin 1
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String[] split = s.split(" ");
        TreeMap<String, Integer> map = new TreeMap<>();
        HashMap<String, List<String>> hashMap =  new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            String s1 = split[i];
            String[] split1 = s1.split("-");
            String uid = split1[0];
            String city = split1[1];
            List<String> strings = hashMap.get(uid);
            if (strings == null) {
                strings = new ArrayList<>();
                strings.add(city);
                hashMap.put(uid, strings);
                Integer orDefault = map.getOrDefault(city, 0);
                map.put(city, ++orDefault);
            } else {
                boolean contains = strings.contains(city);
                if (!contains) {
                    strings.add(city);
                    hashMap.put(uid, strings);
                    Integer orDefault = map.getOrDefault(city, 0);
                    map.put(city, ++orDefault);
                }
            }

        }

        PriorityQueue<City> queue = new PriorityQueue<>(new MinHeapComparator());
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            City city = new City(key, value);
            queue.add(city);
        }

        for (int i = 0; i < 3; i++) {
            City poll = queue.poll();
            if (poll == null) {
                return;
            }
            System.out.println(poll.city + " " + poll.count);
        }

    }

    public static class MinHeapComparator implements Comparator<City> {
        @Override
        public int compare(City o2, City o1) {

            if (City.compare(o1, o2)) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}

class City{
    public String city;
    public Integer count;

    public City(String city, Integer count) {
        this.city = city;
        this.count = count;
    }

    public static boolean compare(City o1, City o2) {
        if (o1.count.equals(o2.count)) {
            return o1.city.compareTo(o2.city) < 0;
        }
        return o1.count > o2.count;
    }
}