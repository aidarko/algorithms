package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[][] costs = new int[5][2];
        for (int i=0; i<5; i++) {
            costs[i][0] = i;
            costs[i][1] = i*2;
        }

        //Arrays.sort(costs, (a, b) -> a[0] - a[1] - (b[0] - b[1]));
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });

        Subset subset = new Subset();
//        int[] a = {1, 2, 3};
//        subset.subsets(a);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> curr : output) {
                List<Integer> newList2 = new ArrayList<>(curr);
                newList2.add(num);
                newSubsets.add(newList2);
            }
            output.addAll(newSubsets);
        }

        return output;
    }
}
