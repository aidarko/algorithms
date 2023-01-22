package tree;

import tree.node.Node;

import static common.Util.println;

/**
 * Keep range [min left, max right] and boolean
 *           4
 *         /   \
 *       2      8
 *      / \    /
 *     1   3  6
 *            \
 *             7
 *
 *           4
 *         /   \
 *       2      8
 *      / \    /
 *     1   3  6
 *           / \
 *          1  9
 */
public class BstValidation {
    public static void main(String[] args) {
        BstValidation bstValidation = new BstValidation();

        Node validRoot = createBst();
        Node inValidRoot = createInvalidBst();

        println(bstValidation.validateBst(validRoot));
        println(bstValidation.validateBst(inValidRoot));
    }

    private static Node createBst() {
        Node node1 = new Node(1, null, null);
        Node node3 = new Node(3, null, null);
        Node node7 = new Node(7, null, null);
        Node node6 = new Node(6, null, node7);
        Node node2 = new Node(2, node1, node3);
        Node node8 = new Node(8, node6, null);
        return new Node(4, node2, node8);
    }

    private static Node createInvalidBst() {
        Node node1 = new Node(1, null, null);
        Node node3 = new Node(3, null, null);
        Node node9 = new Node(9, null, null);
        Node node6 = new Node(6, node1, node9);
        Node node2 = new Node(2, node1, node3);
        Node node8 = new Node(5, node6, null);
        return new Node(4, node2, node8);
    }

    /**
     *           4
     *         /   \
     *       2      8
     *      / \    /
     *     1   3  6
     *            \
     *             7
     */
    private boolean validateBst(Node root) {
        if (root == null) return false;
        return validateBstInternal(root).valid;
    }

    // 1. Valid tree   1 <- 2 -> 3 => [1,3]
    // 2. Invalid tree 1 <- 3 -> 2

    private Triple validateBstInternal(Node root) {
        if (root.left == null && root.right == null) {
            return new Triple(root.data, root.data, true);
        } else if (root.left != null && root.right != null) {
            Triple left = validateBstInternal(root.left);
            Triple right = validateBstInternal(root.right);
            boolean isValid = root.data < right.left
                    && root.data >= left.right
                    && left.valid
                    && right.valid;
            return new Triple(left.left, right.right, isValid);
        } else if (root.left != null) {
            Triple left = validateBstInternal(root.left);
            boolean isValid = root.data >= left.right
                    && left.valid;
            return new Triple(left.left, root.data, isValid);
        } else {
            Triple right = validateBstInternal(root.right);
            boolean isValid = root.data < right.left
                    && right.valid;
            return new Triple(root.data, right.right, isValid);
        }

    }

    static class Triple {
        int left;
        int right;
        boolean valid;

        public Triple(int left, int right, boolean valid) {
            this.left = left;
            this.right = right;
            this.valid = valid;
        }
    }
}
