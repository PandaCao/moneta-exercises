package com.example.demo.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Exercise2Service {

    private final Logger log = LoggerFactory.getLogger(Exercise2Service.class);

    private char[] swapNumber(char[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] <= '3') {
                char temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        return arr;
    }

    private char[] multiplyByTwo(char[] arr){
        ArrayList<Character> result = new ArrayList<>();

        for (char c : arr) {
            int num = Character.getNumericValue(c);
            if (num == 8 || num == 9) {
                String multiplied = String.valueOf(num * 2);
                for (char digit : multiplied.toCharArray()) {
                    result.add(digit);
                }
            } else {
                result.add(c);
            }
        }

        char[] finalArray = new char[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalArray[i] = result.get(i);
        }

        return finalArray;
    }

    private char[] removeNumberSeven(char[] arr){
        ArrayList<Character> result = new ArrayList<>();

        for (char c : arr) {
            if (c != '7') {
                result.add(c);
            }
        }

        char[] finalArray = new char[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalArray[i] = result.get(i);
        }

        return finalArray;
    }

    private Integer divideByEvenNumbers(char[] arr){
        var evenNums = 0;
        var number = Integer.parseInt(String.valueOf(arr));
        for (char c : arr) {
            if (c % 2 == 0) {
                evenNums++;
            }
        }

        return Math.floorDiv(number, evenNums);
    }


    public Integer calculate(Integer num) {
        char[] arr = String.valueOf(num).toCharArray();

        var swap = swapNumber(arr);

        log.info("After swapNumber: {}", swap);

        var multiply = multiplyByTwo(swap);

        log.info("After multiplying: {}", multiply);

        var remove = removeNumberSeven(multiply);

        log.info("After removeNumberSeven: {}", remove);

        var result = divideByEvenNumbers(remove);

        log.info("After divideByEvenNumbers: {}", result);

        return result;
    }
}
