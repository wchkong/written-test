package fall2019.t4tujia;


import java.util.*;

/**
 4 6 3
 要去的城市
2 3 4
 边
1 2 4
2 3 3
4 3 1
1 4 1
4 2 2
3 1 6

 4 6 3
 2 3 4
 1 2 4
 2 3 3
 4 3 1
 1 4 1
 4 2 2
 3 1 6

 A
 2
 */
public class Main1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        // 城市数
        int N = in.nextInt();
        // M条道路
        int M = in.nextInt();
        // 需要访问城市数
        int R = in.nextInt();

        List<Integer> rList = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            rList.add(in.nextInt());
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

        Integer nodeKey1 = rList.get(0);
        HashSet<Node> set = new HashSet<>();
        Node node = graph.nodes.get(nodeKey1);
        int count = 0;
        while (!set.contains(node) && node != null && rList.contains(node.value)) {
            set.add(node);
            Node next = null;
            int minWeight = Integer.MAX_VALUE;
            Edge minEdge = null;
            for (Edge edge:node.edges) {
                Node node2 = edge.node2;
                Node node1 = edge.node1;
                int weight = edge.weight;

                if (node1 != node && rList.contains(node1.value) && !set.contains(node1)) {
                    if (minWeight > weight) {
                        minWeight = weight;
                        minEdge = edge;
                    }
                } else if (node2 != node && rList.contains(node2.value) && !set.contains(node1)){
                    if (minWeight > weight) {
                        minWeight = weight;
                        minEdge = edge;
                    }
                }
            }
            if (minEdge != null) {
                count += minWeight;
                next = minEdge.node1 == node ? minEdge.node2 : minEdge.node1;
            }
            node = next;
        }


        System.out.println(count);

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


