package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class Util {

    public static List<String> mapToUppercase(List<String> input) {
        return input.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
    public static List<String> removeElementsWithMoreThanFourCharacters(List<String> input) {
        return input.stream()
                .filter(s -> s.length() < 4)
                .collect(Collectors.toList());
    }
    public static List<String> sortStrings(List<String> input) {
        return input.stream()
                .sorted()
                .collect(Collectors.toList());
    }
    public static List<Integer> sortIntegers(List<String> input) {
        return input.stream()
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }
    public static List<Integer> sortIntegersDescending(List<String> input) {
        return input.stream()
                .map(Integer::parseInt)
                .sorted((number1, number2) -> number2.compareTo(number1))
                .collect(Collectors.toList());
    }
    public static Integer sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(s -> s).sum();
    }
    public static List<String> flattenToSingleCollection(List<List<String>> input) {
        return input.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
    public static String separateNamesByComma(List<Person> input) {
        return input.stream()
                .map(Person::getName)
                .collect(joining(", ", "Names: ", "."));
    }

    public static String findNameOfOldestPerson(List<Person> input) {
        return input.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .get()
                .getName();

    }
    public static List<String> filterPeopleLessThan18YearsOld(List<Person> input) {
        return input.stream()
                .filter(person -> person.getAge() < 18)
                .map(Person::getName)
                .collect(Collectors.toList());
    }
    public static IntSummaryStatistics getSummaryStatisticsForAge(List<Person> input) {
        return new IntSummaryStatistics(input.stream().count(),
                                        input.stream().min(Comparator.comparingInt(Person::getAge)).get().getAge(),
                                        input.stream().max(Comparator.comparingInt(Person::getAge)).get().getAge(),
                                        input.stream().map(Person::getAge).reduce(0,Integer::sum)
                                        );
    }
    public static Map<Boolean, List<Person>> partitionAdults(List<Person> input) {
        return input.stream()
                .collect(Collectors.partitioningBy(person -> person.getAge() > 18));
    }
    public static Map<String, List<Person>> partitionByNationality(List<Person> input) {
        return input.stream()
                .collect(groupingBy(Person::getCountry));
    }
}
