package org.example.reader;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {
    public static List<String> mostFreqFromMap(final Map<String, Integer> entry,final int limit){
        return entry.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
