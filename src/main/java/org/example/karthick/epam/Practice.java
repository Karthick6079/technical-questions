package org.example.karthick.epam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Practice {


    public int[] twoSum(int[] nums, int target){

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int desired = target - nums[i];
            if(map.containsKey(desired)){
                return new int[] { i, map.get(desired)};
            }
            map.put(desired, i);
        }
        return new int[]{-1, -1};
    }

    public int longestSubString(String str){
        char[] chars =  str.toCharArray();
        Set<Character> set = new HashSet<>();
        int left = 0, max = 0;

        for(int right = 0; right < chars.length; right++){
            while(set.contains(chars[right])){
                set.remove(chars[left++]);
            }
            set.add(chars[right]);
            max = Math.max(max, right - left + 1);
        }
        return max;

    }
}
