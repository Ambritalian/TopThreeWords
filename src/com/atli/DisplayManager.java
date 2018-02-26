package com.atli;

import java.util.List;

public final class DisplayManager {

    public static void display(List<String> input) {
        for (String thing: input) {
            System.out.println(thing);
        }
    }

    public static void display(String message) {
        System.out.println(message);
    }
}
