package org.example.reader;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LogWriter implements AutoCloseable{
    private final Path path;
    private BufferedWriter writer = null;

    public LogWriter(String path) throws FileNotFoundException {
        this.path = (Paths.get(path)).normalize();
    }

    public String getPath() {
        return path.toString();
    }

    public void writeline(String line) throws IOException {
        if (writer == null) {
            writer = new BufferedWriter(new FileWriter(path.toString()));
        }
        writer.write(line + "\n");
    }
    public void appendline(String line) throws IOException {
        if (writer == null) {
            writer = new BufferedWriter(new FileWriter(path.toString(), true));
        }
        writer.write(line + "\n");
    }

    public void close() throws IOException {
        if (writer == null) {
            return;
        }
        writer.close();
    }

}
