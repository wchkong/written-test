package leetcode;

/**
 * 转圈打印矩阵 (逆时针)
 */
public class PrintMatrix {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);

    }

    private static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;

        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    private static void printEdge(int[][] matrix, int tR, int tC, int dR, int dC) {

        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                System.out.print(matrix[tC][dC]);
            }
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                System.out.print(matrix[tR][dR]);
            }
        } else {
            int x = tR;
            int y = tC;

            while (x != dR) {
                System.out.print(matrix[x++][y] + " ");
            }
            while (y != dC) {
                System.out.print(matrix[x][y++] + " ");
            }
            // tR，tC已经打印
            while (x != tR) {
                System.out.print(matrix[x--][y] + " ");
            }
            while (y != tC) {
                System.out.print(matrix[x][y--] + " ");
            }
        }
    }

}

/**
 * zigzag打印矩阵
 * 对角线打印
 */
class ZigZagPrintMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);

    }

    private static void printMatrixZigZag(int[][] matrix) {
        int tx = 0;
        int ty = 0;
        int dx = 0;
        int dy = 0;
        int endx = matrix.length - 1;
        int endy = matrix[0].length - 1;
        // 标记打印方向
        boolean fromUp = false;
        while (tx != endx + 1) {
            printLevel(matrix, tx, ty, dx, dy, fromUp);
            tx = ty == endy ? tx + 1 : tx;
            ty = ty == endy ? ty : ty + 1;
            dy = dx == endx ? dy + 1 : dy;
            dx = dx == endx ? dx : dx + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    private static void printLevel(int[][] matrix, int tx, int ty, int dx, int dy, boolean fromUp) {

        if (fromUp) {
            while (tx != dx + 1) {
                System.out.print(matrix[tx++][ty--] + " ");
            }
        } else {
            while (dx != tx - 1) {
                System.out.print(matrix[dx--][dy++] + " ");
            }
        }

    }
}
