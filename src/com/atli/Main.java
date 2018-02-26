package com.atli;

/****************************
 * @Name: Top Three Words
 * @Author: Alex Ingram
 * @Date: 26/02/2018
 * @Version: 1.1
*****************************/

public class Main {
    public static void main(String[] args) {
        Controller.parse("LargeFile");
    }
}

// parser class that takes incoming file as input, outputs an arraylist of words
// counter class that takes output from parser, stores words in hashmap and returns top three words
// Manager class to connect p & c
// display class to output top three words or messages to screen