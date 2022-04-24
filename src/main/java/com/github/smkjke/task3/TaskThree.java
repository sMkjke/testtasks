package com.github.smkjke.task3;

import java.util.*;

public class TaskThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String romanNumOne = scanner.nextLine();
        String romanNumTwo = scanner.nextLine();
        TaskThree taskThree = new TaskThree();

        try {
            taskThree.sumRomanNumbers(romanNumOne, romanNumTwo);
        } catch (IllegalFormatException e) {
            System.out.println(e);
        }
        System.out.println(taskThree.sumRomanNumbers(romanNumOne, romanNumTwo));
    }

    public String sumRomanNumbers(String romanNumOne, String romanNumTwo) {
        if (!validate(romanNumOne.toUpperCase()) || !validate(romanNumTwo.toUpperCase())) {
            throw new IllegalArgumentException("Некорректный формат ввода - доступны только римские цифры (IVXLC)");
        }
        int arabicNumOne = convertToArabic(romanNumOne);
        int arabicNumTwo = convertToArabic(romanNumTwo);

        if (arabicNumOne > 100 || arabicNumTwo > 100) {
            throw new IllegalArgumentException("Одно из чисел больше 100 (С)");
        }
        return convertToRoman(arabicNumOne + arabicNumTwo);
    }


    private boolean validate(String line) {
        return line != null
                && line.length() != 0
                && line.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
    }

    private int decodeSingle(char letter) {
        switch (letter) {
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }

    private int convertToArabic(String roman) {
        int result = 0;
        String uRoman = roman.toUpperCase();
        for (int i = 0; i < uRoman.length() - 1; i++) {
            int value = decodeSingle(uRoman.charAt(i));
            if (value < decodeSingle(uRoman.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }
        result += decodeSingle(uRoman.charAt(uRoman.length() - 1));
        return result;
    }

    private String convertToRoman(int number) {
        final String[] digit = {"", "I", "II", "III", "IV", "V", "VI", "VII",
                "VIII", "IX"};
        final String[] ten = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX",
                "LXXX", "XC"};
        final String[] hundred = {"", "C", "CC"};

        return hundred[number % 1000 / 100] + ten[number % 100 / 10] + digit[number % 10];
    }
}