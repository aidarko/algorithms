package graph.node;

import java.util.ArrayList;
import java.util.List;

public class WeightedNode {
    public int index;
    public List<WeightedNode> nodes;
    public List<Integer> weights;

    public WeightedNode(int i) {
        index = i;
        nodes = new ArrayList<>();
        weights = new ArrayList<>();
    }

    public void addNode(WeightedNode node, int weight){
        nodes.add(node);
        weights.add(weight);

        node.nodes.add(this);
        node.weights.add(weight);
    }
}
