package t25xiecheng;

/**
 *
 10
 10
 0 0 0 0 0 0 0 0 0 0
 0 0 0 0 0 0 0 0 0 0
 0 0 0 0 0 0 0 0 0 0
 0 0 0 0 0 0 0 0 0 0
 0 0 0 0 0 0 0 0 0 0
 0 0 0 0 0 0 0 0 0 0
 0 0 0 0 0 0 0 0 0 0
 0 0 0 0 0 0 0 0 0 0
 0 0 0 0 0 0 0 0 0 0
 0 0 0 0 0 0 0 0 0 0
 48620

 * @Author: kongweichang
 * @Date: 2019/10/14 10:34
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main3 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int DynamicPathPlanning(int[][] matrixGrid) {

        if (matrixGrid == null || (matrixGrid.length == 0 || matrixGrid[0].length == 0)){
            return 0;
        }

        if (matrixGrid.length == 1 || matrixGrid[0].length == 1) {
            for (int i = 0; i < matrixGrid.length; i++) {
                for (int j = 0; j < matrixGrid[0].length; j++) {
                    if (matrixGrid[i][j] == 1) {
                        return 0;
                    }
                }
            }
            return 1;
        }

        int[][] a = new int[matrixGrid.length][matrixGrid[0].length];
        a[0][0] = 1;
        for (int i = 0; i < matrixGrid.length; i++) {
            if (matrixGrid[i][0] == 1) {
                a[i][0] = 0;
            } else {
                a[i][0] = 1;
            }
        }
        for (int i = 0; i < matrixGrid[0].length; i++) {
            if (matrixGrid[0][i] == 1) {
                a[0][i] = 0;
            } else {
                a[0][i] = 1;
            }
        }
        for (int i = 1; i < matrixGrid.length; i++) {
            for (int j = 1; j < matrixGrid[0].length; j++) {
                if (matrixGrid[i][j] == 1) {
                    a[i][j] = 0;
                } else {
                    a[i][j] = a[i - 1][j] + a[i][j - 1];
                }
            }
        }
        return a[matrixGrid.length - 1][matrixGrid[0].length - 1];
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _matrixGrid_rows = 0;
        int _matrixGrid_cols = 0;
        _matrixGrid_rows = Integer.parseInt(in.nextLine().trim());
        _matrixGrid_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _matrixGrid = new int[_matrixGrid_rows][_matrixGrid_cols];
        for(int _matrixGrid_i=0; _matrixGrid_i<_matrixGrid_rows; _matrixGrid_i++) {
            for(int _matrixGrid_j=0; _matrixGrid_j<_matrixGrid_cols; _matrixGrid_j++) {
                _matrixGrid[_matrixGrid_i][_matrixGrid_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = DynamicPathPlanning(_matrixGrid);
        System.out.println(String.valueOf(res));

    }
}

