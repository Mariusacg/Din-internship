package org.example;

import java.util.Scanner;

import org.example.Logic.Calculator;
import org.example.Operations.Operation;
import org.example.Operations.Sum;
import org.example.Utils.Utils;

public class Main {
    public static void main(String[] args) {

        // Scanner myObj = new Scanner(System.in);
        // while (true) {
        //     String operatie = myObj.nextLine();
        //     if (operatie.equals("Quit"))
        //         break;

        //     System.out.println(Calculator.calculate(operatie));
        // }

        // myObj.close();

        Operation op;
        op = Utils.map.get("+");
        System.out.println(op.result(321, 12));
    }
}