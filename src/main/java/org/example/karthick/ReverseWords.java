package org.example.karthick;

public class ReverseWords {

    public String reverseWords(String str){

        String[] words = str.split("\\s+"); // Split based on whitespace
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--){
            sb.append(words[i]);
            if(i > 0)
                sb.append(" ");
        }

        return sb.toString();



    }
}
