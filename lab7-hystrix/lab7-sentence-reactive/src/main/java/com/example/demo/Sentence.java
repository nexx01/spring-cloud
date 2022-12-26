package com.example.demo;

import java.util.Map;
import java.util.TreeMap;

public class Sentence {

    private Map<Word.Role, String> words = new TreeMap<>();

    public void add(Word word) {
        words.put(word.getRole(), word.getWord());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Word.Role role : words.keySet()) {
            stringBuilder.append(words.get(role)).append(' ');
        }
        return stringBuilder.toString();
    }
}
