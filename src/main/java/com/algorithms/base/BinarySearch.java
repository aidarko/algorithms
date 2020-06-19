package com.algorithms.base;

public class BinarySearch {
    public static void main(String... args){

    }

    public int binarySearch(int toFind, int... array) {
        int upper = array.length;
        int lower = 0;

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            if (array[mid] == toFind){
                return mid;
            }
            if (array[mid] < toFind){
                lower = mid;
            }
            else {
                upper = mid;
            }
        }
        return -1;
    }
}
