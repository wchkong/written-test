package fall2019.t14didi;
/**
 *   最近很多城市都搞起了垃圾分类，已知有一个小区有n堆垃圾需要丢弃，这些垃圾都打包了，我们并不知道这是什么垃圾，
 *   要知道有些垃圾如果丢在一起是会影响环境的。这个小区一共只有两辆垃圾车，出于合理负载的考量，要求两辆车必须装载相同数量的垃圾。
 *   我们希望在不影响环境的情况下，每次让垃圾车载走最多的垃圾。
 *
 *   我们为垃圾袋标了号，分别是1-n，有m个约束，每个约束表示为“a b”，意思是第a堆垃圾与第b堆垃圾不能装在一辆垃圾车上。
 *   （每堆垃圾最多有两个约束条件）
 *
 *   请问两辆垃圾车一次最多可以带走多少堆垃圾呢？
 *
 * 输入
 * 输入第一行包含两个正整数n，m，表示共有n堆垃圾，m个约束条件。(1<=n,m<=500)
 *
 * 接下来有m行，每行有两个正整数，a，b，表示第a堆垃圾和第b堆垃圾不能放在一辆垃圾车上。(1<=a,b<=n)
 *
 * 输出
 * 输出仅包含一个正整数，表示两辆垃圾车一次最多带走的垃圾的数量。
 *
 *
 * 样例输入
 * 5 2
 * 1 4
 * 3 4
 * 样例输出
 * 4
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Graph graph = new Graph();
        for (int i = 0; i < m; i++) {
            int i1 = scanner.nextInt();
            Node node1 = graph.nodes.get(i1);
            if (node1 == null) {
                node1 = new Node(i1);
            }
            int i2 = scanner.nextInt();
            Node node2 = graph.nodes.get(i2);
            if (node2 == null) {
                node2 = new Node(i2);
            }

            Edge edge = new Edge(node1, node2, scanner.nextInt());
            graph.nodes.put(i1, node1);
            graph.nodes.put(i2, node2);
            graph.edges.add(edge);

            node1.edges.add(edge);
            node2.edges.add(edge);
            node1.edge ++;
            node2.edge ++;
        }

        for (int i = 0; i < n; i++) {
            Node node = graph.nodes.get(i);
            if (node == null) {
                node = new Node(i);
                graph.nodes.put(i, node);
            }
        }

        List<Node> a = new ArrayList<>();
        List<Node> b = new ArrayList<>();

        Node node = graph.nodes.get(1);
        process(graph.nodes, node, a, b);

        System.out.println(a.size() + b.size());

    }
    static void process(HashMap<Integer, Node> nodes, Node now, List<Node> a, List<Node> b) {

        if (now == null) {
            return;
        }
        for (Edge edge:now.edges) {
            Node node2 = edge.node2;
            Node node1 = edge.node1;
            if (node1 != now ) {
                if (a.contains(node1)) {
                    b.add(now);
                    process(nodes, node1, a, b);
                    b.remove(now);
                } else {
                    a.add(now);
                    process(nodes, node1, a, b);
                    a.remove(now);
                }

            } else if (node2 != now){
                if (a.contains(node2)) {
                    b.add(now);
                    process(nodes, node1, a, b);
                    b.remove(now);
                } else {
                    a.add(now);
                    process(nodes, node1, a, b);
                    a.remove(now);
                }
            }
        }



    }

}
class Node {
    public int value;
    public int edge;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        edge = 0;
        edges = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
class Edge {
    public int weight;
    public Node node1;
    public Node node2;

    public Edge(Node node1, Node node2, int weight) {
        this.weight = weight;
        this.node1 = node1;
        this.node2 = node2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return weight == edge.weight &&
                Objects.equals(node1, edge.node1) &&
                Objects.equals(node2, edge.node2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, node1, node2);
    }
}
class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
