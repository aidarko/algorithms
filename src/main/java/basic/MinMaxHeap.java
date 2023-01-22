package basic;

import java.util.PriorityQueue;

public class MinMaxHeap {
    public static void main(String[] args) {
        // create priority queue
        PriorityQueue< Integer > prq = new PriorityQueue <> ();

        // insert values in the queue
        prq.add(6);
        prq.add(9);
        prq.add(5);
        prq.add(64);
        prq.add(6);

        //print values
        while (!prq.isEmpty()) {
            System.out.print(prq.poll()+" ");
        }
    }
}
