package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class FindMinStep {
    Set<String> visited = new HashSet<>();
    int answer = -1;

    public static void main(String[] args) {
        FindMinStep f = new FindMinStep();
        f.findMinStep("WWRRBBWW", "WRBRW");
        System.out.println(f.answer);
    }

    public int findMinStep(String board, String hand) {
        findMinStep(board, hand, 1);
        return answer;
    }

    public void findMinStep(String board, String hand, int depth) {
        for (char c : hand.toCharArray()) {
            for (int i = 0; i < board.length(); i++) {
                String s = addChar(c, i, board);


                String tmp = "";
                while (!s.equals(tmp) && !s.equals("")) {
                    tmp = s;
                    s = shrinkBoard(s);
                }

                if (s.equals("")) {
                    answer = answer == -1 ? depth : Math.min(depth, answer);
                    continue;
                }

                if (!visited.contains(s)) {
                    visited.add(s);
                    //System.out.print(s);
                    //System.out.print(" | ");
                    String h = removeChar(hand, c);
                    //System.out.println(h);
                    findMinStep(s, h, depth+1);
                }
            }
        }
    }

    private String addChar(char ch, int position, String str) {
        return str.substring(0, position) + ch + str.substring(position);
    }

    private String removeChar(String string1, char c) {
        return string1.replaceFirst(Pattern.quote(String.valueOf(c)), "");
    }

    private String shrinkBoard(String board) {
        int position = 0;
        char lastChar = board.charAt(position);
        int counter = 1;
        boolean delete = false;
        for (int i = 1; i < board.length(); i++) {
            if (lastChar == board.charAt(i)) {
                counter++;
            } else {
                if (delete) break;
                else {
                    counter = 1;
                    position = i;
                    lastChar = board.charAt(i);
                }
            }
            if (!delete) {
                if (counter == 3) {
                    delete = true;
                }
            }
        }
        board = !delete? board : board.substring(0, position) + board.substring(position+counter);
        return board;
    }
}
