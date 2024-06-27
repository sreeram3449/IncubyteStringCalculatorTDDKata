package org.incubyte;

public class StringCalculator {
    //TODO Should handle custom delimiter passed in between // and \n at the beginning of the String
    public static int add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        } else if (numbers.contains(",")) {
            String[] tokens = splitString(numbers);
            int sum = 0;
            for(String i:tokens){
                sum=sum+toInt(i);
            }
            return sum;
        } else{
            return Integer.parseInt(numbers);
        }
    }

    private static String[] splitString(String numbers){
        return numbers.split(",|\n");
    }

    private static int toInt(String token){
        return Integer.parseInt(token);
    }
}