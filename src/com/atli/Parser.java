package com.atli;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Parser {
    private List<String> words = new LinkedList<>();

    public Parser(String filename) {
        String filePath = new File("").getAbsolutePath();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(filePath + "/src/resources/" + filename));
            String line;
            while ((line = br.readLine()) != null) {
                String someWords[];
                line = line.toLowerCase().replaceAll("[']", "");
                line = line.replaceAll("[-]", " ");
                someWords = line.replaceAll("[^a-z ]", "").split(" ");
                for (String word : someWords) {
                    if (!word.equals(""))
                    words.add(word);
                }
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public List<String> getWords() {
        return words;
    }
    
}