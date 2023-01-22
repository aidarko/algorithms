package tree;

import tree.node.Node;

/**
 *           4
 *         /   \
 *       2      8
 *      / \    /
 *     1   3  6
 *            \
 *             7
 */
public class BstFindHeight {
    public static void main(String[] args) {
        BstFindHeight findHeight = new BstFindHeight();
        Node node1 = new Node(1, null, null);
        Node node3 = new Node(3, null, null);
        Node node7 = new Node(7, null, null);
        Node node6 = new Node(6, null, node7);
        Node node2 = new Node(2, node1, node3);
        Node node8 = new Node(5, node6, null);
        Node root = new Node(4, node2, node8);

        System.out.println(findHeight.findHeight(root));
    }

    private int findHeight(Node root) {
        if (root == null) return 0;
        int heightLeft = findHeight(root.left);
        int heightRight = findHeight(root.right);
        return 1 + Math.max(heightLeft, heightRight);
    }
}
