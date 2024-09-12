package org.example;

import java.util.Scanner;

import org.example.logic.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger("ErrorLogger");

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        while (true) {
            String operation = myObj.nextLine();
            if (operation.equals("Quit")) {
                break;
            }
            try {
                System.out.println(Calculator.calculate(operation));
            } catch (Exception e) {
                System.out.println("Error for more info look in LoggerError txt");
                logger.error(e.getClass() + " : " + e.getMessage());
            }
        }
        myObj.close();
    }
}