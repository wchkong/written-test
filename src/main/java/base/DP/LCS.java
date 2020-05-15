package base.DP;

/**
 *
 * DP实现 求两个字符串最长子序列
 *
 * @Author: kongweichang
 * @Date: 2019/9/23 14:49
 */
public class LCS {

    public static void main(String[] args) {

        int[][] lcs = getLCS("abcd", "ab1234a");
        System.out.println(lcs[lcs.length - 1][lcs[0].length - 1]);

    }


    public static int[][] getLCS(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] lens = new int[len1 + 1][len2 + 1];


        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if ( i == 0 || j == 0) {
                    lens[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lens[i][j] = lens[i - 1][j - 1] + 1;
                } else {
                    lens[i][j] = Math.max(lens[i][j - 1], lens[i - 1][j]);
                }

            }
        }
        return lens;
    }

}
