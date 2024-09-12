package org.example.logic;

import java.io.IOException;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.example.utils.OperationEnum;

public class BracketFinder {
    public static ImmutablePair<String, Boolean> firstBracket(String initialString) throws IOException {
        int remainingOpen = 0;
        boolean first = true;
        int pozFirstBracket = -1, pozFinalBracket = -1;
        int index = 0;
        boolean type2 = false;
        for (char c : initialString.toCharArray()) {
            if (c == '(') {
                remainingOpen++;
                if (first) {
                    first = false;
                    pozFirstBracket = index;
                    type2 = isType2(initialString, index, type2);
                }
            } else if (c == ')') {
                remainingOpen--;
                if (remainingOpen == 0) {
                    pozFinalBracket = index;
                    break;
                }
            }
            index++;
        }
        if (pozFirstBracket == -1) {
            return new ImmutablePair<String, Boolean>("No brackets found!", null);
        }
        if (pozFinalBracket == -1) {
            return new ImmutablePair<String, Boolean>("Invalid input - brackets!", null);
        }
        if (type2) {
            return new ImmutablePair<String, Boolean>(initialString.substring(pozFirstBracket + 1, pozFinalBracket),
                    true);
        } else {
            return new ImmutablePair<String, Boolean>(initialString.substring(pozFirstBracket + 1, pozFinalBracket),
                    false);
        }
    }

    private static boolean isType2(String initialString, int i, boolean type2) {
        for (OperationEnum operation : OperationEnum.getEnumsOperandFirst()) {
            String prequelToBracket = null;
            try {
                prequelToBracket = initialString.substring(i - operation.symbol.length(), i);
            } catch (IndexOutOfBoundsException e) {
                continue;
            }
            if (operation.symbol.equals(prequelToBracket)) {
                type2 = true;
                break;
            }
        }
        return type2;
    }
}
