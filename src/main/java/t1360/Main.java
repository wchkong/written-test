package t1360;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    //private static ConcurrentHashMap<String, Integer> subStringMap = new ConcurrentHashMap<String, Integer>();
    private static HashMap<String, Integer> subStringMap = new HashMap<String, Integer>();

    public static void process(char[] chs, int i) {
        if (i == chs.length) {
            addToMap(chs);
            return;
        }
        process(chs, i + 1);
        char tmp = chs[i];
        chs[i] = 0;
        process(chs, i + 1);
        chs[i] = tmp;
    }

    private static void addToMap(char[] chs) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] != '\0') {
                buffer.append(chs[i]);
            }
        }
        Integer integer = subStringMap.get(buffer.toString());
        if (integer == null) {
            subStringMap.put(buffer.toString(), 1);
        } else {
            subStringMap.put(buffer.toString(), ++ integer);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        process(chars, 0);

        AtomicInteger max = new AtomicInteger(0);
        Collection<Integer> values = subStringMap.values();
        values.forEach(v -> {
            if (v > max.get()) {
                max.set(v);
            }
        });
        System.out.println(max.get());
    }


}
