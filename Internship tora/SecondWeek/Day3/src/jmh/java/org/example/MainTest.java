package org.example;

import java.util.concurrent.TimeUnit;

import org.example.memorepo.ArrayListBasedRepository;
import org.example.memorepo.HashSetBasedRepository;
import org.example.memorepo.InMemoryRepository;
import org.example.memorepo.Order;
import org.example.memorepo.TreeSetBasedRepository;
import org.openjdk.jmh.annotations.*;

public class MainTest {

    @State(Scope.Thread)
    public static class ArrayStateGOL {
        InMemoryRepository<Order> array = new ArrayListBasedRepository<>();
    }

    @State(Scope.Thread)
    public static class ArrayStatePLIN {
        InMemoryRepository<Order> array = new ArrayListBasedRepository<>();

        public ArrayStatePLIN() {
            for (int i = 0; i < 50000; i++) {
                array.add(new Order(i, 10, 12));
            }
        }
    }

    @State(Scope.Thread)
    public static class HashSetStateGOL {
        InMemoryRepository<Order> array = new HashSetBasedRepository<>();
    }

    @State(Scope.Thread)
    public static class HashSetStatePLIN {
        InMemoryRepository<Order> array = new HashSetBasedRepository<>();

        public HashSetStatePLIN() {
            for (int i = 0; i < 50000; i++) {
                array.add(new Order(i, 10, 12));
            }
        }
    }

    @State(Scope.Thread)
    public static class TreeSetStateGOL {
        InMemoryRepository<Order> array = new TreeSetBasedRepository<>();
    }

    @State(Scope.Thread)
    public static class TreeSetStatePLIN {
        InMemoryRepository<Order> array = new TreeSetBasedRepository<>();

        public TreeSetStatePLIN() {
            for (int i = 0; i < 50000; i++) {
                array.add(new Order(i, 10, 12));
            }
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Fork(value = 2, jvmArgs = { "-Xms2G", "-Xmx2G" })
    @Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 100, time = 2, timeUnit = TimeUnit.SECONDS, batchSize = 10)
    @Threads(1)
    public void arrayTestForADDGOL(ArrayStateGOL state) {
        state.array.add(new Order(0, 0, 0));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Fork(value = 2, jvmArgs = { "-Xms2G", "-Xmx2G" })
    @Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 100, time = 2, timeUnit = TimeUnit.SECONDS, batchSize = 10)
    @Threads(1)
    public void hashTestForADDGOL(HashSetStateGOL state) {
        state.array.add(new Order(0, 0, 0));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Fork(value = 2, jvmArgs = { "-Xms2G", "-Xmx2G" })
    @Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 100, time = 2, timeUnit = TimeUnit.SECONDS, batchSize = 10)
    @Threads(1)
    public void treeTestForADDGOL(TreeSetStateGOL state) {
        state.array.add(new Order(0, 0, 0));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Fork(value = 2, jvmArgs = { "-Xms2G", "-Xmx2G" })
    @Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 100, time = 2, timeUnit = TimeUnit.SECONDS, batchSize = 10)
    @Threads(1)
    public void arrayTestForADDPLIN(ArrayStatePLIN state) {
        state.array.add(new Order(100001, 12, 1));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Fork(value = 2, jvmArgs = { "-Xms2G", "-Xmx2G" })
    @Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 100, time = 2, timeUnit = TimeUnit.SECONDS, batchSize = 10)
    @Threads(1)
    public void hashTestForADDPLIN(HashSetStatePLIN state) {
        state.array.add(new Order(100001, 12, 1));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Fork(value = 2, jvmArgs = { "-Xms2G", "-Xmx2G" })
    @Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 100, time = 2, timeUnit = TimeUnit.SECONDS, batchSize = 10)
    @Threads(1)
    public void treeTestForADDPLIN(TreeSetStatePLIN state) {
        state.array.add(new Order(100001, 12, 1));
    }
}
