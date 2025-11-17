package org.example.karthick;

import java.util.HashMap;
import java.util.Map;

public class CountDivisibleByK {

    public int countDivisibleByK(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0; i < arr.length; i++){
            int rem1 = arr[i] % k;
            if(rem1 != 0 ){
                ans += map.get(k-arr[i]%k);
            } else {
                ans += map.get(0);
            }
            map.put(rem1, map.getOrDefault(rem1, 0) + 1);

        }

        return ans;
    }
}
