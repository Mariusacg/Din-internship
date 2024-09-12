package org.example.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

public enum OperationEnum {

    ADD("+",
            Utils.TRIM + Utils.DOUBLE + Utils.TRIM + "\\+" + Utils.TRIM + Utils.DOUBLE,
            EcuationTypeEnum.OPERANDMIDDLE, BigDecimal::add,
            19),
    SUBTRACT("-",
            Utils.TRIM + Utils.DOUBLE + Utils.TRIM + "\\-" + Utils.TRIM + Utils.DOUBLE,
            EcuationTypeEnum.OPERANDMIDDLE, BigDecimal::subtract,
            20),
    MULTIPLY("*",
            Utils.TRIM + Utils.DOUBLE + Utils.TRIM + "\\*" + Utils.TRIM + Utils.DOUBLE,
            EcuationTypeEnum.OPERANDMIDDLE, BigDecimal::multiply,
            16),
    DIVISION("/",
            Utils.TRIM + Utils.DOUBLE + Utils.TRIM + "\\/" + Utils.TRIM + Utils.DOUBLE,
            EcuationTypeEnum.OPERANDMIDDLE,
            (BigDecimal number1, BigDecimal number2) -> number2.equals(new BigDecimal("0"))
                    ? ExceptionThrower.arithmeticException("You can't divide by 0!")
                    : number1.divide(number2),
            17),
    MIN("min",
            Utils.TRIM + "min\\{" + Utils.TRIM + Utils.DOUBLE + Utils.TRIM + "\\," + Utils.TRIM
                    + Utils.DOUBLE
                    + Utils.TRIM + "\\}",
            EcuationTypeEnum.OPERANDFIRST,
            (BigDecimal number1, BigDecimal number2) -> (number1.compareTo(number2) == 1) ? number2
                    : number1,
            14),
    MAX("max",
            Utils.TRIM + "max\\{" + Utils.TRIM + Utils.DOUBLE + Utils.TRIM + "\\," + Utils.TRIM
                    + Utils.DOUBLE
                    + Utils.TRIM + "\\}",
            EcuationTypeEnum.OPERANDFIRST,
            (BigDecimal number1, BigDecimal number2) -> (number1.compareTo(number2) == 1) ? number1
                    : number2,
            15),
    POWEROF("powerof",
            Utils.TRIM + "powerof\\{" + Utils.TRIM + Utils.DOUBLE + Utils.TRIM + "\\," + Utils.TRIM
                    + Utils.DOUBLE
                    + Utils.TRIM + "\\}",
            EcuationTypeEnum.OPERANDFIRST,
            (BigDecimal number1, BigDecimal number2) -> number1.pow(number2.intValue()),
            15),
    INCREMENT("++",
            Utils.TRIM + Utils.DOUBLE + "[(\\+)]{2}",
            EcuationTypeEnum.OPERANDMIDDLE,
            (BigDecimal number) -> number.add(new BigDecimal("1")),
            10),
    DECREMENT("--",
            Utils.TRIM + Utils.DOUBLE + "[(\\-)]{2}",
            EcuationTypeEnum.OPERANDMIDDLE,
            (BigDecimal number) -> number.subtract(new BigDecimal("1")),
            11),
    ROUND("round",
            Utils.TRIM + "round\\{" + Utils.TRIM + Utils.DOUBLE + Utils.TRIM + "\\}",
            EcuationTypeEnum.OPERANDFIRST,
            (BigDecimal number) -> number.round(new MathContext(1)),
            12),
    SQRT("sqrt",
            Utils.TRIM + "sqrt\\{" + Utils.TRIM + Utils.DOUBLE + Utils.TRIM + "\\}",
            EcuationTypeEnum.OPERANDFIRST,
            (BigDecimal number) -> number.sqrt(new MathContext(5)),
            13);

    public final UnaryOperation unary;
    public final BinaryOperation binary;
    public final String symbol;
    public final String regex;
    public final EcuationTypeEnum type;
    public final int priority;

    private static List<OperationEnum> listOfEnumsOperandFirst = new ArrayList<>();
    private static List<OperationEnum> sortedListOfEnumsAfterPriority = new ArrayList<>();

    private OperationEnum(String symbol, String regex, EcuationTypeEnum type, UnaryOperation op, int priority) {
        this.symbol = symbol;
        this.regex = regex;
        this.type = type;
        this.priority = priority;
        unary = op;
        binary = null;
    }

    private OperationEnum(String symbol, String regex, EcuationTypeEnum type, BinaryOperation op, int priority) {
        this.symbol = symbol;
        this.regex = regex;
        this.type = type;
        this.priority = priority;
        binary = op;
        unary = null;
    }

    private static void initSorted() {
        sortedListOfEnumsAfterPriority.addAll(Arrays.asList(OperationEnum.values()));
        sortedListOfEnumsAfterPriority.sort(Comparator.comparing(anEnum -> anEnum.priority));
    }

    private static void initOperandFirst() {
        for (OperationEnum operation : OperationEnum.values()) {
            if ((operation.type).equals(EcuationTypeEnum.OPERANDFIRST)) {
                listOfEnumsOperandFirst.add(operation);
            }
        }
    }

    public static List<OperationEnum> getSortedEnumsByPriority() {
        if (sortedListOfEnumsAfterPriority.isEmpty()) {
            initSorted();
        }
        return sortedListOfEnumsAfterPriority;
    }

    public static List<OperationEnum> getEnumsOperandFirst() {
        if (listOfEnumsOperandFirst.isEmpty()) {
            initOperandFirst();
        }
        return listOfEnumsOperandFirst;
    }

    public String applyOperation(String matcher) {
        return switch (this.type) {
            case EcuationTypeEnum.OPERANDMIDDLE -> {
                if (binary != null) {
                    yield binaryAndMiddle(matcher);
                } else {
                    yield unaryAndMiddle(matcher);
                }
            }
            case EcuationTypeEnum.OPERANDFIRST -> {
                if (binary != null) {
                    yield binaryAndFirst(matcher);
                } else {
                    yield unaryAndFirst(matcher);
                }
            }

        };
    }

    private String binaryAndMiddle(String matcher) {
        String[] numbers = matcher.split("\\" + this.symbol, 2);
        return this.binary.result(new BigDecimal(numbers[0].trim()),
                        new BigDecimal(numbers[1].trim()))
                .toString();
    }

    private String binaryAndFirst(String matcher) {
        String[] numbers = (StringUtils.substringBetween(matcher, "{", "}")).split(",");
        return this.binary.result(new BigDecimal(numbers[0].trim()),
                        new BigDecimal(numbers[1].trim()))
                .toString();

    }

    private String unaryAndMiddle(String matcher) {
        String number = matcher.split("\\" + this.symbol, 2)[0].trim();
        return (this.unary.result(new BigDecimal(number))).toString();
    }

    private String unaryAndFirst(String matcher) {
        String number = StringUtils.substringBetween(matcher, "{", "}").trim();
        return (this.unary.result(new BigDecimal(number))).toString();

    }

}
