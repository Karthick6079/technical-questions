package org.example.karthick.twopointer;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int compliment = target - arr[i];
            if(map.containsKey(compliment)){
                return new int[]{map.get(compliment), i};
            }
            map.put(arr[i],i);
        }
        return new int[]{-1, -1};
    }

    public int[] twoSumSortedArray(int[] arr, int target){
        int l = 0;
        int r = arr.length-1;

        while(l < r){
            int sum = arr[l] + arr[r];
            if(sum == target) return new int[]{l, r};
            if( sum > target) r--;
            else l++;
        }
        return new int[]{-1, -1};
    }
}
