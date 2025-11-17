package org.example.karthick;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public boolean isAnagram(String s, String t){

        if(s.length() != t.length())
            return false;

        Map<Character, Integer> sCountMap = new HashMap<>();
        Map<Character, Integer> tCountMap = new HashMap<>();

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for(int i = 0 ; i < sChars.length; i++){
            sCountMap.put(sChars[i], sCountMap.getOrDefault(sChars[i],0) +1);
            tCountMap.put(tChars[i], tCountMap.getOrDefault(tChars[i],0) +1);
        }

        for(char c: sCountMap.keySet()){
            if(sCountMap.get(c).intValue() != tCountMap.getOrDefault(c, 0).intValue()){
                return false;
            }
        }

        return true;



    }
}
