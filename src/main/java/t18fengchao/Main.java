package t18fengchao;

import java.util.*;

/**
 * @Author: kongweichang
 * @Date: 2019/9/24 16:59
 */
public class Main {
    public static void main(String[] args) {
    }

    /**
     用户第一次取件时间，取件次数
     **/
    public List<User> getUserList(List<User> map) {

        PriorityQueue<User> queue = new PriorityQueue<>(new User());
        for(int i = 0; i < map.size(); i++) {
            User user = map.get(i);
            queue.add(user);
        }
        List<User> result = new ArrayList<>();
        int i = 1;
        while(i < 66 && !queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }
}

class User implements Comparator<User> {
    // 取件最早时间戳
    public int time;
    // 累计取件次数
    public int count;

    public User () {}

    public User(int time, int count) {
        this.time = time;
        this.count = count;
    }
    @Override
    public int compare(User u1, User u2) {
        if(u1.count == u2.count) {
            if(u1.time > u2.time) {
                return 1;
            } else {
                return -1;
            }
        } else if (u1.count > u2.count) {
            return 1;
        } else {
            return -1;
        }
    }
}

