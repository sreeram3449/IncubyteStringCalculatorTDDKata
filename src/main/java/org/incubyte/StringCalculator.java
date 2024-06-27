package org.incubyte;

public class StringCalculator {
    //TODO Should return Sum of N numbers if passed a String containing N numbers separated by coma
    public static int add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        } else if (numbers.contains(",")) {
            String[] tokens = numbers.split(",");
            return toInt(tokens[0])+toInt(tokens[1]);
        } else{
            return Integer.parseInt(numbers);
        }
    }

    private static int toInt(String token){
        return Integer.parseInt(token);
    }
}