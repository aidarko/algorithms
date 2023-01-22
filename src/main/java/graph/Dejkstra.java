package graph;

import graph.node.WeightedNode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dejkstra {

    public static void main(String[] args) {
        WeightedNode graph = createGraph();
        findPath(graph, 4);
        System.out.println("distanceTo: " + Arrays.toString(distanceTo));
        System.out.println("pred: " + Arrays.toString(pred));
    }

    static boolean[] visited = new boolean[7];
    static int[] pred = new int[7];
    static int[] distanceTo = new int[7];

    private static void findPath(WeightedNode graph, int m) {
        Queue<Pair<WeightedNode, Integer>> pq = new PriorityQueue<>(Comparator.comparing(Pair::getValue));
        pq.add(new Pair<>(graph, 0));

        visited[0] = true;
        Arrays.fill(distanceTo, Integer.MAX_VALUE);
        distanceTo[1] = 0;


        while (!pq.isEmpty()) {
            Pair<WeightedNode, Integer> item = pq.poll();
            WeightedNode currNode = item.getKey();
            int currIdx = currNode.index;
            int currWeight = item.getValue();
            visited[currIdx] = true;

            int i = 0;
            for (WeightedNode neighNode : currNode.nodes) {
                if (!visited[neighNode.index]) {
                    int distance = currWeight + currNode.weights.get(i);

                    if (distanceTo[neighNode.index] > distance) {
                        pq.add(new Pair<>(neighNode, distance));
                        distanceTo[neighNode.index] = distance;
                        pred[neighNode.index] = currIdx;
                    }
                }

                i++;
            }

            if (currIdx == m) return;
        }
    }


    private static WeightedNode createGraph() {
        WeightedNode node1 = new WeightedNode(1);
        WeightedNode node2 = new WeightedNode(2);
        WeightedNode node3 = new WeightedNode(3);
        WeightedNode node4 = new WeightedNode(4);
        WeightedNode node5 = new WeightedNode(5);
        WeightedNode node6 = new WeightedNode(6);

        node1.addNode(node2, 7);
        node1.addNode(node3, 9);
        node1.addNode(node6, 14);

        node2.addNode(node3, 10);
        node2.addNode(node4, 15);

        node3.addNode(node6, 2);
        node3.addNode(node4, 11);

        node6.addNode(node5, 9);

        node5.addNode(node4, 6);

        return node1;
    }

    @AllArgsConstructor
    @Getter
    private static class Pair<T, T1> {
        T key;
        T1 value;
    }
}
