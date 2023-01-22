package tree;

import tree.node.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *          4
 *        /   \
 *       2     6
 *      / \   /
 *     1   3 5
 *
 * pre-order  4 2 1 3 6 5
 * inorder    1 2 3 4 5 6
 * post-order 1 3 2 5 6 4
 *
 * post-order iterative:
 * 1. Push root to s1
 * 2. loop s1
 *      pop n and push s2
 *      push n.left and n.right to s1
 * 3. Print s3.
 */
public class BstTraverse {

    public static void main(String[] args) {
        BstTraverse traverse = new BstTraverse();
        Node node1 = new Node(1, null, null);
        Node node3 = new Node(3, null, null);
        Node node2 = new Node(2, node1, node3);
        Node node5 = new Node(5, null, null);
        Node node6 = new Node(6, node5, null);
        Node root = new Node(4, node2, node6);

        System.out.print("preOrder: ");
        traverse.preOrder(root); System.out.println();
        System.out.print("inOrder: ");
        traverse.inOrder(root); System.out.println();
        System.out.print("postOrder: ");
        traverse.postOrder(root); System.out.println();

        System.out.print("preOrderIterative: ");
        traverse.preOrderIterative(root); System.out.println();
        System.out.print("inOrderIterative: ");
        traverse.inOrderIterative(root); System.out.println();
        System.out.print("postOrderIterative: ");
        traverse.postOrderIterative(root); System.out.println();

        System.out.print("bfsIterative: ");
        traverse.bfsIterative(root); System.out.println();

    }

    /**
     *  *          4
     *  *        /   \
     *  *       2     6
     *  *      / \   /
     *  *     1   3 5
     */
    private void bfsIterative(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            System.out.print(node.data + " ");
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
    }

    private void preOrderIterative(Node root) {
        Stack<Node> s = new Stack<>();
        s.add(root);
        while (!s.isEmpty()) {
            Node node = s.pop();
            System.out.print(node.data + " ");
            if (node.right != null) s.add(node.right);
            if (node.left != null) s.add(node.left);
        }
    }

    private void inOrderIterative(Node root) {
        Stack<Node> s = new Stack<>();
        s.add(root);
        Node node = root;
        while (node.left != null) {
            node = node.left;
            s.add(node);
        }

        while (!s.isEmpty()) {
            node = s.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                Node right = node.right;
                s.add(right);

                while (right.left != null) {
                    right = right.left;
                    s.add(right);
                }
            }
        }
    }

    private void postOrderIterative(Node root) {}

    private void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    private void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }


}
