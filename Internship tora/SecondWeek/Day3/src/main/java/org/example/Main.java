package org.example;

import org.example.memorepo.FunctionalIntf;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

       List<String> letters1 = Collections.emptyList();
        FunctionalIntf f = System.out::println;
        ((FunctionalIntf)f::print).print("Schema");
    }
}
