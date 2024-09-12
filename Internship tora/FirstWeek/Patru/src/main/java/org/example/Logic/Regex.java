package org.example.Logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.example.Operations.Sum;
import org.example.Operations.Difference;
import org.example.Operations.Division;
import org.example.Operations.Multiply;

public class Regex {
    public static String mRegex(String initialString)
    {
        final String regex = "[\t ]*\\-?\\d+[\\t ]*[\\+\\-÷%x][\\t ]*\\-?\\d+";

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(initialString);

        while (matcher.find()) {
            
            if(matcher.group(0).contains("+")){       
                // String[] numbers = matcher.group(0).split("\\+");
                // String rezultat = Integer.toString(new Sum().result(Integer.parseInt(numbers[0].trim()), Integer.parseInt(numbers[1].trim())));      
                // return initialString.replace(matcher.group(0), rezultat);
            }
            if(matcher.group(0).contains("-")){
                // String[] numbers = matcher.group(0).split("\\-");
                // String rezultat = Integer.toString(Scadere.rezultat(Integer.parseInt(numbers[0].trim()), Integer.parseInt(numbers[1].trim())));   
                // return initialString.replace(matcher.group(0), rezultat);
            }
            if(matcher.group(0).contains("x")){
                // String[] numbers = matcher.group(0).split("\\x");
                // String rezultat = Integer.toString(Inmultire.rezultat(Integer.parseInt(numbers[0].trim()), Integer.parseInt(numbers[1].trim())));      
                // return initialString.replace(matcher.group(0), rezultat);
            }
            if(matcher.group(0).contains("%")){
                // String[] numbers = matcher.group(0).split("\\%");
                // String rezultat = Integer.toString(Impartire.rezultat(Integer.parseInt(numbers[0].trim()), Integer.parseInt(numbers[1].trim())));         
                // return initialString.replace(matcher.group(0), rezultat);
            }
        }
        return "";
    }
}
