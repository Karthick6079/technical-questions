package org.example.karthick;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public void isAnagramUsingSorted(String s, String t){

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        if(new String(sChars).equals(new String(tChars))){
            System.out.println("Yess");
        }

        System.out.println("No");
        

        // Sort using the java streams

        String sSorted = Stream.of(s.split("")).sorted().collect(Collectors.joining());
        String tSorted = Stream.of(t.split("")).sorted().collect(Collectors.joining());

        if(sSorted.equals(tSorted)){
            System.out.println("The given strings is Anagram");
        }
    }
}
