package tree;

import tree.node.IntervalTreeNode;

import static common.Util.println;

public class IntervalTreeSearch {
    public static void main(String[] args) {
        IntervalTreeNode root = createIntervalTree();
        println(search(root, 23, 25));
        println(search(root, 12, 14));
        println(search(root, 21, 23));
    }

    private static boolean search(IntervalTreeNode root, int from, int to) {
        if (root == null) {
            return false;
        }
        if (intersect(root, from, to)) {
            return true;
        }
        if (root.left == null || root.left.maxRight < from) {
            return search(root.right, from, to);
        }
        return search(root.left, from, to);
    }

    private static boolean intersect(IntervalTreeNode node, int from, int to) {
        return node.from < to && node.to > from;
    }


    private static IntervalTreeNode createIntervalTree() {
        IntervalTreeNode node4 = new IntervalTreeNode(4, 8, 8);
        IntervalTreeNode node7 = new IntervalTreeNode(7, 10, 10);
        IntervalTreeNode node21 = new IntervalTreeNode(21, 24, 24);
        IntervalTreeNode node16 = new IntervalTreeNode(16, 22, 22);

        IntervalTreeNode node15 = new IntervalTreeNode(15, 18, 22, node7, node16);
        IntervalTreeNode node5 = new IntervalTreeNode(5, 8, 22, node4, node15);

        IntervalTreeNode node17 = new IntervalTreeNode(17, 19, 24, node5, node21);

        return node17;
    }
}
