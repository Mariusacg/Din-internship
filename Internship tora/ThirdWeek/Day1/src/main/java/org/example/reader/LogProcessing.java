package org.example.reader;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class LogProcessing {
    public static int countLines(final String path) throws IOException {
        int count = 0;
        try (LogReader log = new LogReader(path)) {
            while (log.readLine() != null) {
                count++;
            }
        }
        return count;
    }

    public static int countPattern(final String path, final String pattern) throws IOException {
        int count = 0;
        try (LogReader log = new LogReader(path)) {
            String line = null;
            while ((line = log.readLine()) != null) {
                count += StringUtils.countMatches(line, pattern);
            }
        }
        return count;
    }

    public static void removePattern(final String path, final String newpath, final String pattern) throws IOException {
        try (LogReader logreader = new LogReader(path); LogWriter logwriter = new LogWriter(newpath)) {
            String line = null;
            while ((line = logreader.readLine()) != null) {
                logwriter.writeline(StringUtils.replace(line, pattern, ""));
            }
        }
    }

    public static void replacePattern(final String path, final String newpath, final String pattern, final String newpattern) throws IOException {
        try (LogReader logreader = new LogReader(path); LogWriter logwriter = new LogWriter(newpath)) {
            String line = null;
            while ((line = logreader.readLine()) != null) {
                logwriter.writeline(StringUtils.replace(line, pattern, newpattern));
            }
        }
    }

    public static List<String> frequentSubjects(final String path) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        try (LogReader log = new LogReader(path)) {
            String line = null;
            while ((line = log.readLine()) != null) {
                int index = -1;
                if ((index = line.indexOf(" subject=")) != -1) {
                    int finalIndex = line.indexOf(",", index);
                    final String substring = line.substring(index + 8, finalIndex);
                    if (!map.containsKey(substring)) {
                        map.put(substring, 1);
                    } else {
                        map.replace(substring, map.get(substring) + 1);
                    }
                }
            }
        }
        return Utils.mostFreqFromMap(map, 5);
    }

    public static List<String> frequentWords(final String path) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        try (LogReader log = new LogReader(path)) {
            String line = null;
            while ((line = log.readLine()) != null) {
                String[] words = line.split("[ ,.=]");
                for (String word : words) {
                    if (word.matches("[a-zA-Z]+"))
                        if (!map.containsKey(word)) {
                            map.put(word, 1);
                        } else {
                            map.replace(word, map.get(word) + 1);
                        }
                }
            }
        }
        return Utils.mostFreqFromMap(map, 5);
    }
}
