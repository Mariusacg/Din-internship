package org.example.threadop;

import org.example.reader.LogReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class RemakingLogReader implements Runnable {

    private final String pathInput;
    private final long charToSkip;
    private final long charToRead;
    private long counter = 0;

    public RemakingLogReader(final String pathInput, final long charToSkip, final long charToRead) {
        this.pathInput = pathInput;
        this.charToSkip = charToSkip;
        this.charToRead = charToRead;
    }

    @Override
    public void run() {
        try (LogReader logReader = new LogReader(pathInput)) {
            logReader.skip(charToSkip);
            String batch = null;

            int batchPerRead = 8192;
            while (!Objects.equals(batch = logReader.readBytes(batchPerRead), "")) {
                counter += batch.length();
                if (counter > charToRead) {
                    batch = batch.substring(0, (int) (batch.length() - (counter - charToRead)));
                    Utils.add(pathInput, batch);
                    break;
                }
                Utils.add(pathInput, batch);
            }
        } catch (FileNotFoundException e) {
            System.out.println("DSADSADSADSADSADSADASDASDASDASDAS");
        } catch (IOException e) {
            System.out.println("DSAAAAAAAAAAAdsadasdsadDSADASDASDASDASDEWQEQWQGERNDMFKMQEWK");
        } catch (Exception e) {
            System.out.println(e.getMessage() + " " + pathInput);
        }
    }
}
