package com.sergey.prykhodko.homework7.reverse;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Created by Sergey on 25.07.2017.
 */
public class StringReverse {

    public String reverseString(String input){
        return StringUtils.reverse(input);
    }

    public String reverseStringNoTouchingNonLetters(String input){
        String[] toWorkWith = input.split(" ");
        toWorkWith = reverseAllStringsInArray(toWorkWith);
        return buildStringBackFromArray(toWorkWith);
    }

    private String[] reverseAllStringsInArray(String[] input){
        for (int i = 0; i < input.length; i++) {
            input[i] = reverseStringWithoutSpases(input[i]);
        }
        return input;
    }

    private String reverseStringWithoutSpases(String input){
        char[] charsToReverse = input.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < charsToReverse.length; i++) {
            if (Character.isLetter(charsToReverse[i])){
                stack.push(charsToReverse[i]);
                charsToReverse[i] = ' ';
            }
        }
        for (int i = 0; i < charsToReverse.length; i++) {
            if(charsToReverse[i] == ' '){
                charsToReverse[i] = stack.pop();
            }
        }
        return String.valueOf(charsToReverse);
    }

    private String buildStringBackFromArray(String[] input){
        StringBuilder builder = new StringBuilder();
        for (String string : input
             ) {
            builder.append(string + " ");
        }
        return builder.toString().trim();
    }



    public static void main(String[] args) {
        StringReverse reverse = new StringReverse();
        System.out.println(reverse.reverseStringNoTouchingNonLetters("ab2cd_ghd*hj abd#fd"));
    }
}
