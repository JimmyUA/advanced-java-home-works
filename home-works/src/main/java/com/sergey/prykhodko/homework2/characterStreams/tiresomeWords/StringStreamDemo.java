package com.sergey.prykhodko.homework2.characterStreams.tiresomeWords;

import java.io.*;

/**
 * Created by Sergey on 17.07.2017.
 */
public class StringStreamDemo {
    public static void main(String[] args) {
        final String s = "How are you doing today!";
        StringReader reader = new StringReader(s);

        StringWriter writer = new StringWriter();
        try {
            for (int i = 0; i < s.length(); i++) {
                writer.append((char) reader.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(writer.toString());
    }
}
