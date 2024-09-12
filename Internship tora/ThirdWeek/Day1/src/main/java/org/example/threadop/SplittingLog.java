package org.example.threadop;

import org.example.reader.LogReader;
import org.example.reader.LogWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class SplittingLog implements Runnable {

    private final String pathInput;
    private final long charToSkip;
    private final long charToRead;
    private final String pathOutput;
    private long counter = 0;


    public SplittingLog(final int id, final String pathInput, final long charToSkip, final long charToRead) {
        this.pathOutput = "./logs/logThreadNr" + id + ".log";
        this.pathInput = pathInput;
        this.charToSkip = charToSkip;
        this.charToRead = charToRead;
    }

    @Override
    public void run() {
        try (LogReader logReader = new LogReader(pathInput); LogWriter logWriter = new LogWriter(pathOutput)) {
            logReader.skip(charToSkip);
            String batch = null;

            int batchPerRead = 8192;
            while (!Objects.equals(batch = logReader.readBytes(batchPerRead), "")) {
                counter += batch.length();
                if (counter > charToRead) {
                    batch = batch.substring(0, (int) (batch.length() - (counter - charToRead)));
                    logWriter.writeline(batch);
                    break;
                }
                logWriter.writeline(batch);
            }

        } catch (FileNotFoundException e) {
            System.out.println("");
        } catch (IOException e) {
            System.out.println("");
        }
        System.out.println(pathOutput);
    }
}
