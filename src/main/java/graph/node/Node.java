package graph.node;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int data;
    public List<Node> nodes;

    public Node(int i) {
        data = i;
        nodes = new ArrayList<>();
    }
}
