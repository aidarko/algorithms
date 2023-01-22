package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class MailboxesCluster {

    public static void main(String[] args) {
        MailboxesCluster mailboxesCluster = new MailboxesCluster();
        int[] houses = {1, 4, 8, 10, 20};
        System.out.println(mailboxesCluster.minDistance(houses, 3));
        int[] houses2 = {2,3,5,12,18};
        System.out.println(mailboxesCluster.minDistance(houses2, 2));
    }

    public int minDistance(int[] houses, int k) {
        if (houses.length == 1) return 0;
        Set<Integer> sortedSet = new HashSet<>();

        List<List<Integer>> clusters = new ArrayList<>();
        // d == 0 ready
        for (int i = 0; i < houses.length ; i++) {
            List<Integer> cluster = new ArrayList<>();
            cluster.add(houses[i]);
            clusters.add(cluster);
            if (i < houses.length - 1) {
                sortedSet.add(houses[i+1] - houses[i]);
            }
        }

        boolean stop = false;
        for (int d : sortedSet) {
            for (int i = 0; i < clusters.size() - 1 && !stop; i++) {
                List<Integer> cluster1 = clusters.get(i);
                List<Integer> cluster2 = clusters.get(i+1);
                if (cluster2.get(0) - cluster1.get(cluster1.size()-1) == d) {
                    cluster1.addAll(cluster2);
                    clusters.remove(i+1);
                    i--;
                }
                if (clusters.size() == k) {
                    stop = true;
                }
            }
        }

        int sum = 0;
        for (List<Integer> cluster : clusters){
            int tmpSum = 0;
            for (int h : cluster) {
                tmpSum += h;
            }
            int point = tmpSum / cluster.size();
            int dist = 0;
            for (int h : cluster) {
                dist += Math.abs(point - h);
            }
            sum += dist;
        }

        return sum;
    }
}
