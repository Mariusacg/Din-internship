package org.example.utils;

public enum EcuationTypeEnum {
    OPERANDMIDDLE{
        @Override
        public String toString(){
            return " number + operand + number(binary) or number + operand(unary) ex : 4 - 5(binary) or 12++(unary)";
        }
    },
    OPERANDFIRST{
        @Override
        public String toString(){
            return " operand(number, number)(binary) or operand(number)(unary) ex : min(4,5)(binary) or sqrt(4)(unary)";
        }
    };
}
