package org.example.executors;

import java.util.concurrent.Callable;

public class StringConcat implements Callable<String> {
    private String stringOne;
    private String stringTwo;
    public StringConcat(String one, String two){
        stringOne = one;
        stringTwo = two;
    }
    @Override
    public String call() throws Exception {
        return stringOne.concat(stringTwo);
    }
}
