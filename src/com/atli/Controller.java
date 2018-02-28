package com.atli;

public final class Controller {

    public static void parse(String filename) {
        Counter counter = new Counter();
        Parser parser = new Parser(filename, counter);
        if (counter.getWordCounts().size() > 0) {
            DisplayManager.display(counter.getTopWords());
        } else {
            DisplayManager.display("Empty file");
        }
    }
}
