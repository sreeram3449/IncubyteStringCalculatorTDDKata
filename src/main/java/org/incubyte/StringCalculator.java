package org.incubyte;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    /**
     * Return sum of all numbers from the string passed
     * @param numbers is a string with custom delimiters between numeric values eg: "//*\n1*2*4*1007"
     * @return sum of numeric values found in the argument numbers
     */
    public static int add(String numbers) {
        if(numbers.isEmpty()){
            return 0;
        } else {
            String[] tokens = splitString(numbers);
            handleNegativeNumbers(tokens);
            return sumOfNumbers(tokens);
        }
    }

    private static String[] splitString(String numbers){
        return (hasCustomDelimiter(numbers))
                ? splitCustomDelimitedString(numbers)
                : splitCommaAndNewLinsString(numbers);
    }

    private static boolean hasCustomDelimiter(String numbers){
        return numbers.startsWith("//");
    }

    private static String[] splitCommaAndNewLinsString(String numbers){
        return numbers.split(",|\n");
    }

    private static String[] splitCustomDelimitedString(String numbers){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(numbers);
        m.matches();
        String customDelimiter = m.group(1);
        String num=m.group(2);
        return num.split(Pattern.quote(customDelimiter));
    }

    private static int toInt(String token){
        return Integer.parseInt(token);
    }

    private static void handleNegativeNumbers(String[] tokens) {
        ArrayList<String> negativeNumbers = new ArrayList<>();
        for(String i: tokens){
            if(toInt(i)<0) {
                negativeNumbers.add(i);
            }
        }
        if(!negativeNumbers.isEmpty()) {
            throw new RuntimeException("Negative numbers not allowed " + String.join(",", negativeNumbers));
        }
    }

    private static int sumOfNumbers(String[] tokens){
        int sum = 0;
        for (String i : tokens) {
            if(toInt(i)>1000){
                continue;
            }
            sum = sum + toInt(i);
        }
        return sum;
    }
}