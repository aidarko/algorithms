package graph;

import graph.node.Node;

public class TopologicalSort {
    /**
     *       2
     *     / \ \
     *    1  3  5
     *     \/
     *     4
     *  4 1 3 5 2
     */

    public static void main(String[] args) {
        Node node2 = createGraph();
        Node nodeWithCycle = createGraphWithCycle();

        sort(node2);
    }

    private static void sort(Node root) {
    }

    private static Node createGraph() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node2.nodes.add(node1);
        node2.nodes.add(node3);
        node2.nodes.add(node5);
        node1.nodes.add(node4);
        node3.nodes.add(node4);
        return node2;
    }

    private static Node createGraphWithCycle() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node2.nodes.add(node1);
        node2.nodes.add(node3);
        node2.nodes.add(node5);
        node1.nodes.add(node4);
        node3.nodes.add(node4);

        // cycle
        node4.nodes.add(node5);

        return node2;
    }

}
