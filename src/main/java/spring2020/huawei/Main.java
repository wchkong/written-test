package spring2020.huawei;

import java.util.Scanner;

/**
 * 判断Ip
 *
 * 192.168.1.1 192.168.1.2 255.255.255.0
 * 192.168.1.1 192.168.2.1 255.255.255.0
 */
public class Main {

    public static void main(String[] args) {

        boolean oneNet = true;
        Scanner scanner = new Scanner(System.in);
        String ip1 = scanner.next();
        String ip2 = scanner.next();
        String subnetMark = scanner.next();

        String[] ip1Array = ip1.split("\\.");
        String[] ip2Array = ip2.split("\\.");
        String[] markArray = subnetMark.split("\\.");

        if (ip1Array.length != 4 || ip2Array.length != 4 || markArray.length != 4 ) {
            System.out.println(0);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            int i1 = Integer.parseInt(ip1Array[i]);
            int i2 = Integer.parseInt(ip2Array[i]);
            int i3 = Integer.parseInt(markArray[i]);

            if (((char)i3 & (char)i2) != ((char)i3 & (char)i1)) {
                oneNet = false;
            }
            stringBuffer.append(((char)i3 & (char)i1));
            if (i < 3) {
                stringBuffer.append(".");
            }
        }
        if (oneNet) {
            System.out.print(1);
            System.out.print(" ");
        } else {
            System.out.print(0);
            System.out.print(" ");
        }
        System.out.print(stringBuffer.toString());
    }
}
