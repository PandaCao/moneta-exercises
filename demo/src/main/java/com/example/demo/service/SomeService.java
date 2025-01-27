package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class SomeService {
    // Czech vowels
    private Boolean isCharacterVowel(char  c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'á' || c == 'e' || c == 'é' || c == 'ě' || c == 'i' || c == 'í' || c == 'o' || c == 'ó' || c == 'u' || c == 'ú' || c == 'ů';
    }

    public String getReversedString(String text) {
        text = text.replaceAll("\\s+", " ").trim();

        var arr = text.toCharArray();
        var result = new char[arr.length];

        for (int i = 0; i < arr.length; i++) {
            var c = arr[arr.length - 1 - i];
            if (isCharacterVowel(arr[i])) {
                result[i] = Character.toUpperCase(c);
            }
            else {
                result[i] = Character.toLowerCase(c);;
            }
        }

        return new String(result);
    }

}
