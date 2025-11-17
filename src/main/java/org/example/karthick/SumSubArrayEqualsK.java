package org.example.karthick;

import java.util.HashMap;
import java.util.Map;

public class SumSubArrayEqualsK {


    public int sumSubArrayEqualsK(int[] nums, int k){
        int curSum = 0;
        int res = 0;
        int diff;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int n: nums){
            curSum += n;
            diff = curSum - k;
            res += map.getOrDefault(diff,0);
            map.put(curSum, map.getOrDefault(curSum,0)+1);
        }
        return res;
    }
}
