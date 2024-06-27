package org.incubyte;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String numbers) {
        if(numbers.isEmpty()){
            return 0;
        } else {
            String[] tokens = splitString(numbers);
            throwExceptionOnNegativeNumber(tokens);
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

    private static void throwExceptionOnNegativeNumber(String[] tokens) {
        for(String i: tokens){
            if(toInt(i)<0) {
                throw new RuntimeException("Negative numbers not allowed " + i);
            }
        }
    }

    private static int sumOfNumbers(String[] tokens){
        int sum = 0;
        for (String i : tokens) {
            sum = sum + toInt(i);
        }
        return sum;
    }
}