package leetcode;

/**
 * 美团面试 1面
 *
 * 在O(1)时间删除单链表结点

 * 题目： 给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 *
 * 问题：单链表中是否一定存在删除的这个结点？
 *
 * 思路：把下一结点的内容复制到需要删除的结点，删除下一结点，相当于删除当前结点。
 * 当我们想删除一个结点时，并不一定要删除这个结点本身。
 * 可以先把下一个结点的内容复制出来覆盖被删除结点的内容，然后把下一个结点删除。
 *
 * 假定待删除结点在链表中。
 */
public class DeleteLinkListNode {

    public static boolean deleteNode(Node head, Node node) {
        if (head == null || node == null) {
            return false;
        }
        if (node.next != null) {
            Node next = node.next;
            node.value = next.value;
            node.next = next.next;
        } else if (head == node) {
            head = head.next;
            node = null;
        } else {
            //node是尾结点
            Node now = head;
            while (now.next != node) {
                now = now.next;
            }
            now.next = null;
            node = null;
        }
        return true;
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
