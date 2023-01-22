package graph;

import graph.node.Node;

public class DFS {
    /**
     *       2
     *     / \ \
     *    1  3  5
     *     \/
     *     4
     *  4 1 3 5 2
     */
    public static void main(String[] args) {
        dfs(createGraph(), new boolean[6]);
    }

    private static void dfs(Node node, boolean[] visited) {
        if (node == null || visited[node.data]) {
            return;
        }
        visited[node.data] = true;
        for (int i = 0; i < node.nodes.size(); i++) {
            dfs(node.nodes.get(i), visited);
        }
        System.out.print(node.data + " ");
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
}
