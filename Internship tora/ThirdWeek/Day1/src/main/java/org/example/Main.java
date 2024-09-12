package org.example;

import org.example.threadop.RemakingLogReader;
import org.example.threadop.RemakingLogWriter;
import org.example.threadop.SplittingLog;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final String PATH_LOG_CURRENT = "./logs/trilava-2021-07-05-POST.log";
    private static final String PATH_LOG_NEW = "./logs/mylog.log";
    private static long sizePerFile;
    private static final int NUMBER_OF_THREADS = 4;
    private static final int NUMBER_OF_THREADS_READER = 4;
    private static final int NUMBER_OF_THREADS_WRITER = 2;

    public static void main(String[] args) throws IOException, InterruptedException {
        Main.sizePerFile = Files.size(Paths.get(PATH_LOG_CURRENT)) / NUMBER_OF_THREADS;

//        System.out.println(LogProcessing.countLines(PATH_LOG_CURRENT));
//
//        System.out.println(LogProcessing.countPattern(PATH_LOG_CURRENT, "order new"));
//
//        LogProcessing.removePattern(PATH_LOG_CURRENT, PATH_LOG_NEW, "Listening");
//        System.out.println(LogProcessing.countPattern(PATH_LOG_NEW, "order new"));
//
//        System.out.println("Old count = " + LogProcessing.countPattern(PATH_LOG_CURRENT, "Listening"));
//        LogProcessing.replacePattern(PATH_LOG_CURRENT, PATH_LOG_NEW, "Listening", "Spying");
//        System.out.println("New count = " + LogProcessing.countPattern(PATH_LOG_NEW, "Spying"));
//
//        System.out.println(LogProcessing.frequentSubjects(PATH_LOG_CURRENT));
//
//        System.out.println(LogProcessing.frequentWords(PATH_LOG_CURRENT));
//
//       LogProcessing.replacePattern(PATH_LOG_NEW, PATH_LOG_NEW, "Spying", "Listening");

//        try (ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS)) {
//            for (int i = 0; i < NUMBER_OF_THREADS; i++) {
//                executor.submit(new SplittingLog(i + 1, PATH_LOG_CURRENT, Main.sizePerFile * i, Main.sizePerFile));
//            }
//            executor.shutdown();
//        }
        try (ExecutorService executorRead = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
             ExecutorService executorWrite = Executors.newFixedThreadPool(NUMBER_OF_THREADS)) {
            for (int i = 0; i < NUMBER_OF_THREADS; i++) {
                int aux = i + 1;
                long sizePerReader = Files.size(Paths.get("./logs/logThreadNr" + aux + ".log")) / NUMBER_OF_THREADS_READER;
                for (int j = 0; j < NUMBER_OF_THREADS_READER; j++) {
                    executorRead.submit(new RemakingLogReader("./logs/logThreadNr" + aux + ".log", j * sizePerReader, sizePerReader));
                }
                for (int j = 0; j < NUMBER_OF_THREADS_WRITER; j++) {
                    executorWrite.submit(new RemakingLogWriter("./logs/logThreadNr" + aux + ".log"));
                }
            }
        }

    }
}