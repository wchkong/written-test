package fall2019.t11kuaishou;

import java.util.Scanner;

/**
 * 2001:0bd8:85a3:0:0:8A2E:0370:7334
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        if (s.length() < 5) {
            System.out.println("Neither");
        }

        boolean checkIPv4 = checkIPv4(s);
        boolean checkIPv6 = checkIPv6(s);

        if (checkIPv4) {
            System.out.println("IPv4");
        } else if (checkIPv6) {
            System.out.println("IPv6");
        } else {
            System.out.println("Neither");
        }
    }

    static boolean checkIPv4(String s) {
        String[] split = s.split("\\.");
        if (split.length < 4) {
            return false;
        }
        for (int i = 0; i < split.length; i++) {
            String s1 = split[i];
            if (s1.startsWith("0") && s1.length() > 1) {
                return false;
            }
            Integer integer = Integer.valueOf(s1);
            if (integer < 0 || integer > 255) {
                return false;
            }
        }
        return true;
    }

    static boolean checkIPv6(String s) {
        String[] split = s.split(":");
        if (split.length < 8) {
            return false;
        }
        for (int i = 0; i < split.length; i++) {
            String s1 = split[i];
            if (s1.length() > 4 || s1.length() == 0) {
                return false;
            }
            if (isZero(s1)) {
                return false;
            }


        }
        return true;
    }

    private static boolean isZero(String s1) {

        if (s1.length() < 2) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (c != '0') {
                return false;
            }
        }
        return true;
    }

}
