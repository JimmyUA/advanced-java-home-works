package com.sergey.prykhodko.homework2.characterStreams.tiresomeWords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sergey on 17.07.2017.
 */
public class TextEditor {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        try(InputStream in = new FileInputStream("D:/COPYRIGHT")){
            int i;
            int count = 0;
            int minLength = 2;

            StringBuilder builder = new StringBuilder();

            while ((i = in.read()) != -1){
                builder.append((char)i);
                if (i == 46 && builder.length() > minLength){
                    list.add(builder.toString().trim());
                    builder = new StringBuilder();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        showSentences(list);
        Scanner scanner = new Scanner(System.in);

        String command;
        do {
            command = scanner.nextLine();
            if (command.equals("e")){
                do{
                    command = scanner.nextLine();
                    if (command.equals("d")) {
                        deleteByNumber(list, scanner);

                    } else if (command.equals("i")) {
                        insertAfter(list, scanner);

                    } else if (command.equals("s")) {
                        insteadOrToTheEnd(list, scanner);

                    } else if (command.equals("r")) {
                        replace(list, scanner);

                    } else if(command.equals("sh")) {
                        showSentences(list);

                    }
                }while (!command.equals("|"));
            }

        }while (!command.equals("ZZ"));
    }

    public static void showSentences(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ". " + list.get(i));
        }
    }

    public static void replace(List<String> list, Scanner scanner) {
        System.out.println("Enter sentence number to replace: ");
        int sentenceToReplace = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter sentance :");
        String newSentence = scanner.nextLine();
        list.remove(sentenceToReplace - 1);
        list.add(sentenceToReplace - 1, newSentence);
    }

    public static void insteadOrToTheEnd(List<String> list, Scanner scanner) {
        System.out.println("Enter sentence number to add new one there: ");
        String input;
        if(!(input = scanner.nextLine()).equals("")) {
            int sentenceInsertAfter = Integer.parseInt(input);
            System.out.println("Enter sentance :");
            String newSentence = scanner.nextLine();
            list.add(sentenceInsertAfter - 1, newSentence);
        }
        else {
            System.out.println("Enter sentance :");
            String newSentence = scanner.nextLine();
            list.add(newSentence);
        }
    }

    public static void insertAfter(List<String> list, Scanner scanner) {
        System.out.println("Enter sentence number to add new one after: ");
        int sentenceInsertAfter = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter sentance :");
        String newSentence = scanner.nextLine();
        list.add(sentenceInsertAfter, newSentence);
    }

    public static void deleteByNumber(List<String> list, Scanner scanner) {
        System.out.println("Enter sentence number to delete: ");
        int sentenceToDelete = Integer.parseInt(scanner.nextLine());
        list.remove(sentenceToDelete - 1);
    }
}
