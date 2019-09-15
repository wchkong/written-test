package t9weipinghui;

public class Main {

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode8;
        treeNode5.left = treeNode6;
        treeNode6.right = treeNode7;

        int width = getWidth(treeNode1);
        System.out.println(width);
    }

    static int getWidth(TreeNode head) {

        if (head == null) {
            return 0;
        }
        if (head.left == null && head.right == null) {
            return 1;
        }
        return getMax(head.left, 1) + getMax(head.right, 1);
    }

    private static int getMax(TreeNode head, int count) {

        if (head == null) {
            return 0;
        }
        TreeNode left = head.left;
        TreeNode right = head.right;

        if (left == null && right == null) {
            return 1;
        }
        return count + Math.max(getMax(left, count), getMax(right, count));
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
