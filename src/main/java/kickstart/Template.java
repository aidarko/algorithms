package kickstart;

import java.util.*;
import java.io.*;

public class Template {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = sc.nextInt();

        for (int caseId = 1; caseId <= numCases; caseId++) {
            // Inputs
            int numLines = sc.nextInt();
            sc.nextLine();

            // Setup
            String ans = "";

            for (int i = 0; i < numLines; i++) {
                String name = sc.nextLine();

                // Processing
            }

            // Print results
            // String ans = new DecimalFormat("#0.000000000000").format(someFloatorDouble);
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