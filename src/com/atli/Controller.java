package com.atli;

public final class Controller {

    public static void parse(String filename) {
        Parser parser = new Parser(filename);
        if (parser.getWords().size() > 0) {
            Counter counter = new Counter(parser.getWords());
            DisplayManager.display(counter.getTopWords());
        } else {
            DisplayManager.display("Empty file");
        }
    }
}
