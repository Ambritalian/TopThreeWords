package com.atli;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Parser {

    public Parser(String filename, Counter counter) {
        String filePath = new File("").getAbsolutePath();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(filePath + "/src/resources/" + filename));
            String line;
            while ((line = br.readLine()) != null) {
                String someWords[];
                line = line.toLowerCase().replaceAll("[-]", " ");
                someWords = line.replaceAll("[^a-z ]", "").split(" ");
                for (String word : someWords) {
                    if (!word.equals(""))
                    counter.add(word);
                }
            }
        } catch (IOException e) {
            System.out.println("File not found"); // Hi Keith, unsure what to do here? I'm guessing I don't use DisplayManager..?
        }
    }
    
}