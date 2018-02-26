package com.atli;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private List<String> words = new ArrayList<>();

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
            System.out.println("File not found"); // Hi Keith, unsure what to do here? I'm guessing I don't use DisplayManager..?
        }
    }

    public List<String> getWords() {
        return words;
    }
    
}