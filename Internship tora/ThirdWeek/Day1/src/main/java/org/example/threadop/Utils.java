package org.example.threadop;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Utils {
    public static Map<String, MyPair> map = new ConcurrentHashMap<>();

    public static void add(final String file, final String line) {
        if (map.get(file) == null) {
            map.put(file, new MyPair());
        }
        map.get(file).getRight().add(line);
        map.get(file).getLeft().release();
    }
    //

    public static String get(final String file) throws InterruptedException {
        if (map.get(file) == null) {
            return "Wait";
        }
        if (!map.get(file).getLeft().tryAcquire(3, TimeUnit.SECONDS)) {
            return "S-a terminat";
        }
        return map.get(file).getRight().poll();
    }

    private static class MyPair extends Pair<Semaphore, LinkedBlockingQueue<String>> {
        private Semaphore semaphore = new Semaphore(0);
        private LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();

        @Override
        public Semaphore getLeft() {
            return semaphore;
        }

        @Override
        public LinkedBlockingQueue<String> getRight() {
            return queue;
        }

        @Override
        public LinkedBlockingQueue<String> setValue(LinkedBlockingQueue<String> value) {
            return null;
        }
    }
}
