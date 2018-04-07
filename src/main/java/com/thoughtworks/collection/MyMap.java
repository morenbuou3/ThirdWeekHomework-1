package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map(n -> n * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream().map(n -> String.valueOf((char) (n + 96))).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return array.stream().map(n -> {
            StringBuffer s = new StringBuffer();
            while (n > 0) {
                int m = n % 26;
                if (m == 0) {
                    m = 26;
                }
                s.insert(0, (char) (m + 96));
                n = (n - m) / 26;
            }
            return s.toString();
        }).collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        return array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }
}
