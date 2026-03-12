package org.example.karthick.epam;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Test {

    public static void main(String[] args) {

        Test testObj = new Test();

        String input = "Madam";
        List<String> words = Arrays.asList("Java","java","Python","python","Go","JAVA");

        testObj.findDuplicateChar(input);
        testObj.countOccurrences(input);
        testObj.printList(words);
        testObj.notRepeatChars(input);
        testObj.flattenMap();

        String sentence = "This is new sentence";
        testObj.countWordFreq(sentence);

    }


    // find duplicate characters in String
    public void findDuplicateChar(String str){

        str.toLowerCase().chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1)
                .forEach( (e) -> System.out.println(e.getKey() + ":" + e.getValue()));

    }

    // count character occurrences
    public void countOccurrences(String str){
        str.chars().mapToObj( c -> (char) c).collect( Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .forEach( (k,v) -> System.out.println(k + ":" + v));
    }

    // Given a list of strings, find the count of each word ignoring case, filter words that appear more than once, and print them sorted alphabetically.
    public void printList(List<String> list){

        list.stream().map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter( e -> e.getValue() > 1)
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(e.getKey() + e.getValue()));

    }

    public void notRepeatChars(String str){
        Character result = str.toLowerCase().chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new ,Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);

        System.out.println(result);
    }

    public void flattenMap(){
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2, 3, 9),
                Arrays.asList(4, 5, 6, 2),
                Arrays.asList(7, 8, 9)
        );

        List<Integer> flat = nested.stream()
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(flat); // [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    public void countWordFreq(String str){

        Map<String, Long> freq = Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        freq.forEach((word, count) -> System.out.println(word + " : " + count));
    }
}
