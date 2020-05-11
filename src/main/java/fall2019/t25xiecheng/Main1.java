package fall2019.t25xiecheng;

/**
 *
 *
 *
 *
 * @Author: kongweichang
 * @Date: 2019/10/14 10:20
 */
import java.util.*;

public class Main1 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int BestMatch(int[] LimitArray, int[][] DegMatrix) {

        List<People> peopleList = new ArrayList<>();
        PriorityQueue<People> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0; i < DegMatrix.length; i++) {
            People people = new People(DegMatrix[i], false);
            peopleList.add(people);
            maxProfitQ.add(people);
        }

        int count = 0;
        for (int i = 0; i < LimitArray.length; i++) {
            count += LimitArray[i];
        }
        int sum = 0;
        for (int i = 0; i < count; i++) {
            People poll = maxProfitQ.poll();

        }
        Collections.sort(peopleList, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return 0;
            }
        });


        return 0;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _LimitArray_size = 0;
        int _DegMatrix_rows = 0;
        int _DegMatrix_cols = 0;
        _DegMatrix_rows = Integer.parseInt(in.nextLine().trim());
        _DegMatrix_cols = Integer.parseInt(in.nextLine().trim());
        _LimitArray_size = _DegMatrix_cols;

        int[] _LimitArray = new int[_LimitArray_size];
        int _LimitArray_item;
        for(int _LimitArray_i = 0; _LimitArray_i < _LimitArray_size; _LimitArray_i++) {
            _LimitArray_item = Integer.parseInt(in.nextLine().trim());
            _LimitArray[_LimitArray_i] = _LimitArray_item;
        }

        int[][] _DegMatrix = new int[_DegMatrix_rows][_DegMatrix_cols];
        for(int _DegMatrix_i=0; _DegMatrix_i<_DegMatrix_rows; _DegMatrix_i++) {
            for(int _DegMatrix_j=0; _DegMatrix_j<_DegMatrix_cols; _DegMatrix_j++) {
                _DegMatrix[_DegMatrix_i][_DegMatrix_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = BestMatch(_LimitArray, _DegMatrix);
        System.out.println(String.valueOf(res));
    }

    public static class MaxProfitComparator implements Comparator<People> {
        @Override
        public int compare(People o2, People o1) {

            if (People.compare(o1, o2)) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}

class People{
    int[] list;
    boolean add;

    public People(int[] list, boolean add) {
        this.list = list;
        this.add = add;
    }

    public int[] getList() {
        return list;
    }

    public void setList(int[] list) {
        this.list = list;
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    public static boolean compare(People o1, People o2) {
        int o1Count = 0, o2Count = 0;
        for (int i = 0; i < o1.list.length; i++) {
            o1Count += o1.list[i];
        }
        for (int i = 0; i < o2.list.length; i++) {
            o2Count += o2.list[i];
        }

        return o1Count > o2Count;
    }

    public int compareTo(People o1, People o2, int idx) {
        return o1.list[idx] - o2.list[idx];
    }
}

