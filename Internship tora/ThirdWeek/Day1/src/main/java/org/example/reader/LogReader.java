package org.example.reader;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LogReader implements AutoCloseable {
    private final Path path;
    private BufferedReader reader = null;
    private BufferedInputStream readerBytes = null;

    public LogReader(String path) throws FileNotFoundException {
        this.path = (Paths.get(path)).normalize();
    }

    public String getPath() {
        return path.toString();
    }

    public String readLine() throws IOException {
        if (reader == null) {
            reader = new BufferedReader(new FileReader(path.toString()));
        }
        return reader.readLine();
    }

    public long skip(long number) throws IOException {
        if (readerBytes == null) {
            readerBytes = new BufferedInputStream(new FileInputStream(path.toString()));
        }
        return readerBytes.skip(number);
    }

    public String readBytes(int numberOfBytes) throws IOException {
        if (readerBytes == null) {
            readerBytes = new BufferedInputStream(new FileInputStream(path.toString()));
        }
        return new String(readerBytes.readNBytes(numberOfBytes));
    }

    public void close() throws IOException {
        if (reader == null) {
            return;
        }
        reader.close();
    }

}
