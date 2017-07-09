package tiresomeWords;

import java.io.*;
import java.util.*;

/**
 * Created by Sergey on 03.07.2017.
 */
public class TiresomeWords {
    private Map<String, Integer> words;

    public TiresomeWords(File file) throws IOException {
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        words = new TreeMap<String, Integer>();

        getWords(bufferedReader);

    }

    private void getWords(BufferedReader bufferedReader) throws IOException {
        String line = null;


        while ((line = bufferedReader.readLine()) != null) {

            String[] strings = line.split(" ");
            for (String string : strings) {
                String toAdd = trimToWord(string);
                if (words.keySet().contains(toAdd)) {
                    words.put(toAdd, words.get(toAdd) + 1);
                } else if (toAdd.length() != 0){
                    words.put(toAdd, 1);
                }
            }

        }
    }

    private boolean isLetter(char c) {
        if (c < 65) {
            return false;
        }
        else if (c > 122) {
            return false;
        }
        else if (c > 90 && c < 97) {
            return false;
        }
        else {
            return true;
        }
    }

    private String trimToWord(String s){
        char[] word = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char aWord : word) {
            if (isLetter(aWord)) {
                builder.append(aWord);
            }
        }
        return builder.toString();
    }

    public Map<String, Integer> getDecreasingOrderSortedMap(){
        Map<String, Integer> sortedWords = new TreeMap<String, Integer>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return words.get(o2).compareTo(words.get(o1));
            }
        });

        sortedWords.putAll(words);
        return sortedWords;
    }

    public String getMostFrequent() {
        String target = "";
        int max = 0;
        Iterator<Map.Entry<String, Integer>> it = words.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> current = it.next();
            if (current.getValue() > max){
                target = current.getKey();
                max = current.getValue();
            }
        }
        return target;
    }

    public Map<String, Integer> getTreeLeaders(){
        Map<String, Integer> result = new LinkedHashMap<String, Integer>();
        int max = 0;
        while (result.size() < 3){
            String mostFrequent = getMostFrequent();
            int amount = words.get(mostFrequent);
            if (amount == max){
                mostFrequent = getLongest(amount);
                Iterator <Map.Entry<String, Integer>> it = result.entrySet().iterator();
                while(it.hasNext()) {
                    Map.Entry<String, Integer> entry = it.next();
                    String current = entry.getKey();
                    if (result.get(current) ==  amount) {
                        if (mostFrequent.length() > current.length()) {
                            result.remove(current);
                            words.put(current, amount);
                        }
                    }
                }
            }

            result.put(mostFrequent, amount);
            max = words.get(mostFrequent);
            words.remove(mostFrequent);

        }
        return result;
    }

    private String getLongest(int amount) {
        Iterator<Map.Entry<String, Integer>> it = words.entrySet().iterator();
        int maxLength = 0;
        String target = "";
        while (it.hasNext()) {
            Map.Entry<String, Integer> current = it.next();
            if (current.getValue() == amount){
                if (current.getKey().length() > maxLength) {
                    target = current.getKey();
                    maxLength = current.getValue();
                }
            }
        }
        return target;
    }


    public static void main(String[] args) {
        File file = new File("D:/COPYRIGHT");
        TiresomeWords tw = null;
        try {
            tw = new TiresomeWords(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(tw.getMostFrequent() + " " + tw.words.get(tw.getMostFrequent()));
        Map<String, Integer> map = tw.getTreeLeaders();
        for (String s : map.keySet()) {
            System.out.println(s + " " + map.get(s));
        }
    }
}
