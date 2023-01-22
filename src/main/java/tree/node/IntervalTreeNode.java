package tree.node;

public class IntervalTreeNode {
    public int from;
    public int to;
    public int maxRight;
    public IntervalTreeNode left;
    public IntervalTreeNode right;

    public IntervalTreeNode(int from, int to, int maxRight, IntervalTreeNode left, IntervalTreeNode right) {
        this.from = from;
        this.to = to;
        this.maxRight = maxRight;
        this.left = left;
        this.right = right;
    }

    public IntervalTreeNode(int from, int to, int maxRight) {
        this.from = from;
        this.to = to;
        this.maxRight = maxRight;
    }
}
