package com.atli;

/****************************
 * @Name: Top Three Words
 * @Author: Alex Ingram
 * @Date: 26/02/2018
 * @Version: 1.3
 * @TODO: Contractions
*****************************/

public class Main {
    public static void main(String[] args) {
        Controller.parse("lyrics");
    }
}

// parser class that takes incoming file as input, outputs an arraylist of words
// counter class that takes output from parser, stores words in hashmap and returns top three words
// Manager class to connect p & c
// display class to output top three words or messages to screen

// might not handle dashes correctly as it assumes that dashes only appear in double-barrel words
// currently does not handle contractions (can't) as two separate words