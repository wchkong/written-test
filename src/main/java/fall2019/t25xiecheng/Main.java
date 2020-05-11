package fall2019.t25xiecheng;

import java.util.*;

/**
 * 在软件系统中，经常会使用到IP黑名单功能。例如如下的黑名单样例，条目可能是单个IP，也可能是一个子网，IP黑名单样例：
 *
 *      62.33.12.122
 *
 *      221.58.4.0/24
 *
 *      8.9.88.1
 *
 *      …
 *
 *  请构建数据结构，在加载黑名单后，能判定给定的IP是否命中指定的IP黑名单。
 *
 * 输入
 * 第一行输入指定IP地址，IPv4格式输入；
 *
 * 第二行输入指定的IP黑名单地址，可以是一个IPv4地址，或一个子网地址。
 *
 * 输出
 * 判断指定的IP是否否命中指定的IP黑名单。
 *
 *
 * 样例输入
 * 2.33.128.9
 * 2.33.128.0/24
 * 样例输出
 * 1
 */
public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static boolean CheckBlackList(String userIP, String blackIP) {

        if (blackIP == null || blackIP.length() == 0) {
            return false;
        }
        if (!blackIP.contains("/")) {
            return blackIP.equals(userIP);
        }
        String[] split = blackIP.split("/");
        if (split.length > 2) {
            return false;
        }
        String childNetIp = split[0];
        String s = split[1];

        String[] split2 = childNetIp.split("\\.");


        Integer integer = Integer.valueOf(s);
        int i = integer / 8;
        int i1 = integer % 8;

        int[] netSub = new int[4];
        byte[] a = new byte[4];

        for (int j = 0; j < i; j++) {
            netSub[j] = 255;
            a[j] = (byte) 255;
        }
        netSub[i] = ~(255 >> ( 8 - i1) ^ 255);
        a[i] = (byte) ~(255 >> ( 8 - i1) ^ 255);

        String[] split1 = userIP.split("\\.");
        for (int j = 0; j < 4; j++) {
            String s1 = split1[j];
            Integer integer1 = Integer.valueOf(s1);
            int i2 = integer1 & netSub[j];
            int integer2 = Integer.parseInt(split2[j]);
            if (integer2 != i2) {
                return false;
            }
        }

        return true;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean res;

        String _userIP;
        try {
            _userIP = in.nextLine();
        } catch (Exception e) {
            _userIP = null;
        }

        String _blackIP;
        try {
            _blackIP = in.nextLine();
        } catch (Exception e) {
            _blackIP = null;
        }

        res = CheckBlackList(_userIP, _blackIP);
        System.out.println(String.valueOf(res ? 1 : 0));
    }
}
