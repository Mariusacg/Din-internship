package org.example.logic;

import java.io.IOException;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {
    private static final Logger logger = LoggerFactory.getLogger("InfoLogger");
    public static String calculate(String expresion) throws IOException, ArithmeticException, NumberFormatException {
        String bracketFinderOuput = null;
        expresion = expresion.trim();
        logger.info("New call to calculate with initial expression " + expresion);
        while (true) {
            ImmutablePair<String, Boolean> pair = null;
            pair = BracketFinder.firstBracket(expresion);
            bracketFinderOuput = pair.getLeft();
            logger.info("BracketFinder output is " + bracketFinderOuput);
            if (bracketFinderOuput.equals("No brackets found!")) {
                break;
            }
            if (bracketFinderOuput.equals("Invalid input - brackets!")) {
                break;
            }
            if (bracketFinderOuput.contains(",") && pair.getRight()) {
                String[] outputs = bracketFinderOuput.split("\\,");
                String result1 = Calculator.calculate(outputs[0]);
                String result2 = Calculator.calculate(outputs[1]);
                expresion = expresion.replace("(" + bracketFinderOuput + ")", "{" + result1 + "," + result2 + "}");
            } else {
                String result = Calculator.calculate(bracketFinderOuput);
                if (pair.getRight()) {
                    expresion = expresion.replace("(" + bracketFinderOuput + ")", "{" + result + "}");
                } else {
                    expresion = expresion.replace("(" + bracketFinderOuput + ")", result);
                }
            }
            logger.info("Remade expression is " + expresion);
        }
        return OperationPriority.calculate(expresion);
    }
}
