package huawei.firstDay;

import java.util.Scanner;

/**
 * @author kongweichang
 * @date 2021/8/14 5:32 下午
 * @desc :
 * @wiki : https://www.nowcoder.com/practice/8c949ea5f36f422594b306a2300315da?tpId=37&&tqId=21224&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 **/
public class HJ1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String all = scanner.nextLine();
        String[] s = all.split(" ");
        if (s.length == 0) {
            System.out.println(0);
        }
        int lastWordLength = s[s.length - 1].length() == 0 ? s[s.length - 2].length() : s[s.length - 1].length();
        System.out.println(lastWordLength);
    }
}
