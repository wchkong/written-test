package t15neteasy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        List<Data> dataList = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            Data data = new Data(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            dataList.add(data);
        }

        for (Data data : dataList) {
            System.out.println(process(data, 0));
        }

    }

    static int process (Data data, int count) {

        if (data.A >= data.B) {
            return count;
        }
        if (data.A + data.p >= data.B) {
            return count + 1;
        }
        int temp = data.A;
        data.A = data.A + data.p;
        int processA = process(data, count + 1);
        data.A = temp;

        int temp1 = data.p;
        data.p = data.p * data.q;
        int processP = process(data, count + 1);
        data.p = temp1;
        return Math.min(processA, processP);
    }

    /**
     * 正解
     * @param args
     */
    static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            long q = sc.nextInt();
            int total = 0;
            while (a < b) {
                if (a + p >= b) {
                    a = a + p;
                } else {
                    p *= q;
                }
                total++;
            }
            System.out.println(total);

        }

        sc.close();

    }


}

//2 1 15 4 2 12 19 3 2

class Data {

    public int A;
    public int B;
    public int p;
    public int q;

    public Data(int A, int B, int p, int q) {
        this.A = A;
        this.B = B;
        this.p = p;
        this.q = q;
    }

}
