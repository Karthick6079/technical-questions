package org.example.karthick;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KTopElements {

    public int[] KTopElements(int[] nums, int k){
        Map<Integer, Integer> counts = new HashMap<>();
        for(int n: nums){
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>( k, (a,b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> entry: counts.entrySet()){
            minHeap.offer(entry);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] res = new int[k];

        for(int i = 0; i < k; i++){
            res[i] = minHeap.poll().getKey();
        }

        return res;
    }
}
