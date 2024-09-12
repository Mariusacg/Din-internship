package org.example.threadop;

import org.example.reader.LogReader;
import org.example.reader.LogWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class RemakingLogWriter implements Runnable {
    private final String pathInput;

    public RemakingLogWriter(final String pathInput) {
        this.pathInput = pathInput;
    }

    @Override
    public void run() {
        try (LogWriter logWriter = new LogWriter(pathInput + ".log")) {
            System.out.println(pathInput);
            String line;
            while (!Objects.equals(line = Utils.get(pathInput), "S-a terminat")) {
                if (!Objects.equals(line, "Wait")) {
                    logWriter.appendline(line);
                } else{
                    Thread.sleep(100);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("a");
        } catch (IOException e) {
            System.out.println("b");
        } catch (InterruptedException e) {
            System.out.println("c");
        }
        System.out.println("Adios!");
    }
}
