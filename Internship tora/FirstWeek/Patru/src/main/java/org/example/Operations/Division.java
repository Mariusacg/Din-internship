package org.example.Operations;

public class Division implements Operation {

    public int result(int number1, int number2) {
        if(number2 == 0){
            return Integer.MAX_VALUE;
        }
        return number1 / number2;
    }
}
