package org.example.Logic;

public class Calculator {
    public static int calculate(String initial){
        while (true) {
            System.out.println(initial);
            String urmatorul = Regex.mRegex(initial);
            
            if(urmatorul == "")
                return Integer.parseInt(initial);
            
            initial = urmatorul;
        }
    }
}
