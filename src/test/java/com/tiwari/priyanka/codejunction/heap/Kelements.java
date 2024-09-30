package com.tiwari.priyanka.codejunction.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;


public class Kelements {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] arr = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(getelements(arr, k));
    }

    public static int getelements(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i: arr){
            pq.add(i);
            if(pq.size() > k){
               pq.poll();
            }
        }
        return pq.peek();
    }
}
