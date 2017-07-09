package com.sergey.prykhodko.homework4.collections;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Sergey on 07.07.2017.
 */
public class Dictionary {
    private static Path dictionary = Paths.get("D:/dictionary.txt");


    public static Map<String, String> getDictionary(){
        Map<String, String> dictionary = new TreeMap<>();
        List<String> keys = new LinkedList<>();
        List<String> values = new LinkedList<>();
        InputStream in = null;
        try {
            in = new FileInputStream(Dictionary.dictionary.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int input;
        StringBuilder builder = new StringBuilder();
        try {
            while ((input = in.read()) > 0){
                if (input == 58) {
                    String key = builder.toString();
                    keys.add(key);
                    builder = new StringBuilder();
                }
                else if (input == 59) {
                    String value = builder.toString();
                    values.add(value);
                    builder = new StringBuilder();
                }
                else if (input == 13 || input == 10) {
                }
                else {
                    builder.append((char) input);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator<String> itKeys = keys.iterator();
        Iterator<String> itvalues = values.iterator();
        while (itKeys.hasNext() && itvalues.hasNext()) {
            dictionary.put(itKeys.next(), itvalues.next());
        }

        return dictionary;
    }
}
