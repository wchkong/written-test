package fall2019.t858tongcheng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 分糖果  leetcode 135
 *
 *  1 2 3 2 1
 *  1 2 3 4 1
 *
 */
public class Main1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        int[] nums = new int[n];
        Arrays.fill(nums, 1);

        for (int i = 1; i < n; i++) {
            int scoreLast = scores[i - 1];
            int scoreNow =  scores[i];
            if (scoreLast < scoreNow) {
                nums[i] = nums[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (scores[i + 1] < scores[i] && nums[i] < nums[i + 1] + 1) {
                nums[i] = nums[i + 1] + 1;
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
        }
        System.out.println(count);
    }

}
