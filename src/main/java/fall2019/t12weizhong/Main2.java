package fall2019.t12weizhong;

import java.util.*;

/**
 * @Author: kongweichang
 * @Date: 2019/9/19 16:27
 */
public class Main2 {

    /**
     * 去过的点
     */
    static int count = 0;
    static HashSet<Node> set = new HashSet<>();

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        // 景点数
        int N = in.nextInt();
        // M条道路
        int M = in.nextInt();

        if (N == 0 || M == 0) {
            System.out.println(0);
            return;
        }

        Graph graph = new Graph();

        for (int i = 0; i < M; i++) {
            int i1 = in.nextInt();
            Node node1 = graph.nodes.get(i1);
            if (node1 == null) {
                node1 = new Node(i1);
            }
            int i2 = in.nextInt();
            Node node2 = graph.nodes.get(i2);
            if (node2 == null) {
                node2 = new Node(i2);
            }

            Edge edge = new Edge(node1, node2, in.nextInt());
            graph.nodes.put(i1, node1);
            graph.nodes.put(i2, node2);
            graph.edges.add(edge);

            node1.edges.add(edge);
            node2.edges.add(edge);
            node1.edge ++;
            node2.edge ++;
        }

        // 入口
        int S = in.nextInt();
        // 出口
        int T = in.nextInt();

        Node node = graph.nodes.get(S);

        List<Node> nodes = new ArrayList<>();
        nodes.add(node);
        process(node, T, nodes);

        System.out.println(N - set.size());

    }


    static void process(Node now, int end, List<Node> nodes) {

        if (now.value == end) {
            set.addAll(nodes);
            return;
        }

        for (Edge edge:now.edges) {
            Node node2 = edge.node2;
            Node node1 = edge.node1;
            if (node1 != now && !nodes.contains(node1)) {
                nodes.add(node1);
                process(node1, end, nodes);
                nodes.remove(node1);
            } else if (node2 != now && !nodes.contains(node1)){
                nodes.add(node2);
                process(node2, end, nodes);
                nodes.remove(node2);
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
