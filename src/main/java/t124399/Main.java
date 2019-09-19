package t124399;

/**
 * @Author: kongweichang
 * @Date: 2019/9/18 9:39
 */
public class Main {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,2,3,5,2};
        int i = maxCost(a);
        System.out.println(i);
    }

    public static int maxCost(int[] goods) {

        if(goods.length == 0) {
            return 0;
        } else if (goods.length == 1) {
            return goods[0];
        }
        int maxIndexL = 0;
        int maxIndexR = 0;
        int firstCost = 0;
        for(int j = 0; j < goods.length - 1; j ++) {
            int l = j;
            int r = j + 1;
            if(goods[l] + goods[r] > firstCost) {
                firstCost = goods[l] + goods[r];
                maxIndexL = l;
                maxIndexR = r;
            }
        }
        int maxCost = firstCost;
        for(int i = 0; i < goods.length - 2; i++) {
            int nextIndex = 0;
            if(maxIndexL <= 0) {
                nextIndex = ++maxIndexR;
            } else if(maxIndexR >= goods.length - 1) {
                nextIndex = --maxIndexL;
            } else {
                if (goods[maxIndexL] > goods[maxIndexR]) {
                    nextIndex = --maxIndexL;
                } else {
                    nextIndex = ++maxIndexR;
                }
            }
            maxCost += goods[nextIndex];
        }


        return maxCost;
    }
}
