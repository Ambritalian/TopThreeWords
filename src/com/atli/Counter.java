package com.atli;

import java.util.*;

public class Counter {

    private Map<String, Integer> wordCounts;
    private String[] topThree = new String[3];

    public Counter(List<String> words) {
        wordCounts = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String currentWord = words.get(i);
            int count = 0;
            if (wordCounts.containsKey(currentWord)) {
                count = wordCounts.get(currentWord);
                wordCounts.put(currentWord, ++count);
            } else wordCounts.put(currentWord, ++count);
            if (i < 3) topThree[i] = currentWord;
            else {
                if (wordCounts.get(currentWord) >= wordCounts.get(topThree[0])) { // New top word
                    if (currentWord.equals(topThree[1])) {
                        topThree[1] = topThree[0];
                        topThree[0] = currentWord;
                    } else if (!currentWord.equals(topThree[0])) {
                        String tmp = topThree[0];
                        topThree[0] = currentWord;
                        String tmp2 = topThree[1];
                        topThree[1] = tmp;
                        topThree[2] = tmp2;
                    }
                } else if (wordCounts.get(currentWord) >= wordCounts.get(topThree[1])) { // New 2nd top word
                    if (!currentWord.equals(topThree[1])) {
                        topThree[2] = topThree[1];
                        topThree[1] = currentWord;
                    }
                } else if (wordCounts.get(currentWord) >= wordCounts.get(topThree[2])) topThree[2] = currentWord; // New 3rd top word
            }
        }
    }

    public Map<String, Integer> getWordCounts() {
        return wordCounts;
    }

    public List<String> getTopWords() {
        List<String> top3 = new ArrayList<>();
        for (int i = 0; i<3; i++) {
            top3.add(topThree[i] + " " + wordCounts.get(topThree[i]));
        }
        return top3;
    }
}
