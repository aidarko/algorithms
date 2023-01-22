package kickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ButterflyPath {
    static class Node {
        int x, y, e;

        public Node(int x, int y, int e) {
            this.x = x;
            this.y = y;
            this.e = e;
        }
    }

    static int xMax = 0;
    static int yMax = 0;
    static int[][] values;
    static int E = 0;

    private static int process(int s, List<Node> matrix) {
        E = s;
        for (Node n : matrix) {
            xMax = Math.max(xMax, n.x);
            yMax = Math.max(yMax, n.y);
        }
        values = new int[xMax+1][yMax+1];
        for (Node n : matrix) {
            values[n.x][n.y] = n.e;
        }

        int ans = 0;
        for (int y = yMax; y >= 0; y--) {
            for (int x = 0; x <= xMax; x++) {
                ans = Math.max(ans, r(x , y));
            }
            for (int x = xMax; x >= 0; x--) {
                ans = Math.max(ans, l(x , y));
            }
        }
        return ans;
    }

    private static int r(int x, int y) {
        if (x == 0 && y == yMax) {
            return c(0, yMax);
        }
        if (x > 0 && y == yMax) {
            return r(x - 1, yMax) + c(x, yMax);
        }
        if (x == 0 && y < yMax) {
            return Math.max(r(0, y + 1), l(0, y + 1) - E) + c(0,y);
        }
        return Math.max(r(x-1, y), l(x, y + 1) + c(x,y));
    }

    private static int l(int x, int y) {
        if (x == xMax && y == yMax) {
            return c(x, y) - E;
        }
        if (x < xMax && y == yMax) {
            return l(x + 1, y) + c(x, y);
        }
        if (x == xMax && y < yMax) {
            return Math.max(l(xMax, y + 1), r(xMax, y + 1) - E) + c(xMax,y);
        }
        return Math.max(l(x+1, y), l(x, y + 1)) + c(x,y);
    }

    private static int c(int x, int y) {
        return values[x][y];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = sc.nextInt();
        sc.nextLine();

        for (int caseId = 1; caseId <= numCases; caseId++) {
            String pair = sc.nextLine();
            String[] s = pair.split(" ");
            List<Node> matrix = new ArrayList<>();
            for (int i = 0; i < Integer.parseInt(s[0]); i++) {
                // Processing
                String[] nodeStr = sc.nextLine().split(" ");
                int x = Integer.parseInt(nodeStr[0]);
                int y = Integer.parseInt(nodeStr[1]);
                int e = Integer.parseInt(nodeStr[2]);
                Node n = new Node(x, y, e);
                matrix.add(n);
            }
            int ans = process(Integer.parseInt(s[1]), matrix);

            // Print results
            // String ans = new DecimalFormat("#0.000000000000").format(someFloatOrDouble);
            println("Case #" + caseId + ": " + ans);
        }
    }

    private static void println(String s) {
        System.out.println(s);
    }

    private static void print(String s) {
        System.out.print(s);
    }
}
