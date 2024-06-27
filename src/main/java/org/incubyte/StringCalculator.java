package org.incubyte;

public class StringCalculator {

    //TODO should return sum of numbers if passed a String containing two numbers
    public static int add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        }
        else{
            return Integer.parseInt(numbers);
        }
    }
}