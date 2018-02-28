package com.atli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Counter {
    private int j = 0;
    private Map<String, Integer> wordCounts;
    private String[] topThree = new String[3];

    public Counter() {
        wordCounts = new HashMap<>();
    }

    public void add(String word) {
        int count = 0;
        if (wordCounts.containsKey(word)) {
            count = wordCounts.get(word);
            wordCounts.put(word, ++count);

        } else {
            wordCounts.put(word, ++count);
            if (j < 3) topThree[j++] = word;
        }
        if (wordCounts.get(word) >= wordCounts.get(topThree[0])) { // New top word
            if (word.equals(topThree[1])) { // if top word already in list in second place, swap
                topThree[1] = topThree[0];
                topThree[0] = word;
            } else if (!word.equals(topThree[0])) { // Else propagate through
                String tmp = topThree[0];
                topThree[0] = word;
                String tmp2 = topThree[1];
                topThree[1] = tmp;
                topThree[2] = tmp2;
            }
        } else if (wordCounts.get(word) >= wordCounts.get(topThree[1])) { // New 2nd top word
            if (!word.equals(topThree[1])) { // if 2nd word already in list, swap
                topThree[2] = topThree[1];
                topThree[1] = word;
            }
        } else if (wordCounts.get(word) >= wordCounts.get(topThree[2])) topThree[2] = word; // New 3rd top word
    }

    public List<String> getTopWords() {
        List<String> top3 = new ArrayList<>();
        for (int i = 0; i<3; i++) {
            top3.add(topThree[i] + " - " + wordCounts.get(topThree[i]));
        }
        return top3;
    }

    public Map<String, Integer> getWordCounts() {
        return wordCounts;
    }
}
