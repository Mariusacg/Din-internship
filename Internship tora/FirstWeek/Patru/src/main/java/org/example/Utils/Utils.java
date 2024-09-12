package org.example.Utils;

import java.util.HashMap;
import java.util.Map;

import org.example.Operations.*;


public class Utils {
    public static Map<String, Operation> map = new HashMap();
    static{
        map.put("+", (int number1, int number2) -> number1 + number2);
        map.put("-", (int number1, int number2) -> number1 - number2);
        map.put("%", (int number1, int number2) -> number2 == 0 ? Integer.MAX_VALUE : number1 / number2); 
        map.put("x", (int number1, int number2) -> number1 * number2);
    }
}
