package org.example;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.BaseStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyBenchmarkCap50M {

    @Benchmark
    @Fork(1)
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Warmup(iterations = 4, time = 5)
    @Measurement(iterations = 6, time = 10)
    public void benchmarkForIterativePrimitive(){
        int max = 0;
        for(int i = 1; i <= 50000000; i++){
            int aux = i + 1;
            max = max < aux ? aux : max;
        }
    }
    @Benchmark
    @Fork(1)
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Warmup(iterations = 4, time = 5)
    @Measurement(iterations = 6, time = 10)
    public void benchmarkForIterativeWrapper(){
        int max = 0;
        for(int i = 1; i <= 50000000; i++){
            Integer aux = i + 1;
            max = max < aux ? aux : max;
        }
    }
    @Benchmark
    @Fork(1)
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Warmup(iterations = 4, time = 5)
    @Measurement(iterations = 6, time = 10)
    public void benchmarkForStreamList(ListWith50MState state){
        state.list.stream()
                .map(i -> i + 1)
                .max(Integer::compareTo);
    }
    @Benchmark
    @Fork(1)
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Warmup(iterations = 4, time = 5)
    @Measurement(iterations = 6, time = 10)
    public void benchmarkForStreamListParallel(ListWith50MState state){
        state.list.stream()
                .parallel()
                .map(i -> i + 1)
                .max(Integer::compareTo);
    }
    @Benchmark
    @Fork(1)
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Warmup(iterations = 4, time = 5)
    @Measurement(iterations = 6, time = 10)
    public void benchmarkForStreamIntStream(){
        IntStream.rangeClosed(1, 50000000)
                .map(i -> i + 1)
                .max();
    }
    @Benchmark
    @Fork(1)
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Warmup(iterations = 4, time = 5)
    @Measurement(iterations = 6, time = 10)
    public void benchmarkForStreamIntStreamParallel(){
        IntStream.rangeClosed(1, 50000000)
                .parallel()
                .map(i -> i + 1)
                .max();
    }
    @State(Scope.Thread)
    public static class ListWith50MState {
        public List<Integer> list;
        @Setup(Level.Iteration)
        public void setup(){
            list = new ArrayList<>();
            for(int i = 0; i < 50000000; i++){
                list.add(i);
            }
        }
        @TearDown(Level.Iteration)
        public void tearDown(){
            System.out.println("Da");
        }

    }
}
