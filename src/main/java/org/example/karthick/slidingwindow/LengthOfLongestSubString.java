package org.example.karthick.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubString {


    public int lengthOfLongestSubString(String input){
        char[] charArray = input.toCharArray();
        Set<Character> set = new HashSet<>();
        int left = 0, max = 0;

        for(int right = 0; right < charArray.length; right++){
            while(set.contains(charArray[right])){
                set.remove(charArray[left++]);
            }
            set.add(charArray[right]);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
