package com.sergey.prykhodko.homework4.collections;


import com.sergey.prykhodko.homework4.collections.Dictionary;

import java.io.*;
import java.util.Map;

/**
 * Created by Sergey on 07.07.2017.
 */
public class Translator {
    private final static Map<String, String> DICTIONARY = Dictionary.getDictionary();;

    

    public static String translateWord(String word) {
        return DICTIONARY.get(word);
    }

    public static String translateText(File file) throws IOException {
        FileReader reader = new FileReader(file);
        BufferedReader in = new BufferedReader(reader);
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            String[] strings = line.split(" ");
            for (String string : strings) {
                builder.append(DICTIONARY.get(string) + " ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {

            System.out.println(Translator.DICTIONARY);


        System.out.println(Translator.translateWord("friend"));

        try {
            System.out.println(Translator.translateText(new File("D:/text.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
