package org.example;

import org.openjdk.jmh.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class MyBenchmarkCap5 {
//
//    @Benchmark
//    @Fork(1)
//    @BenchmarkMode(Mode.Throughput)
//    @OutputTimeUnit(TimeUnit.MICROSECONDS)
//    @Warmup(iterations = 4, time = 5)
//    @Measurement(iterations = 6, time = 10)
//    public void benchmarkForIterativePrimitive(){
//        int max = 0;
//        for(int i = 1; i <= 5; i++){
//            int aux = i + 1;
//            max = max < aux ? aux : max;
//        }
//    }
//    @Benchmark
//    @Fork(1)
//    @BenchmarkMode(Mode.Throughput)
//    @OutputTimeUnit(TimeUnit.MICROSECONDS)
//    @Warmup(iterations = 4, time = 5)
//    @Measurement(iterations = 6, time = 10)
//    public void benchmarkForIterativeWrapper(){
//        int max = 0;
//        for(int i = 1; i <= 5; i++){
//            Integer aux = i + 1;
//            max = max < aux ? aux : max;
//        }
//    }
//    @Benchmark
//    @Fork(1)
//    @BenchmarkMode(Mode.Throughput)
//    @OutputTimeUnit(TimeUnit.MICROSECONDS)
//    @Warmup(iterations = 4, time = 5)
//    @Measurement(iterations = 6, time = 10)
//    public void benchmarkForStreamList(){
//        List.of(1,2,3,4,5).stream()
//                .map(i -> i + 1)
//                .max(Integer::compareTo);
//    }
//    @Benchmark
//    @Fork(1)
//    @BenchmarkMode(Mode.Throughput)
//    @OutputTimeUnit(TimeUnit.MICROSECONDS)
//    @Warmup(iterations = 4, time = 5)
//    @Measurement(iterations = 6, time = 10)
//    public void benchmarkForStreamIntStream(){
//        IntStream.rangeClosed(1, 5)
//                .map(i -> i + 1)
//                .max();
//    }
//    @Benchmark
//    @Fork(1)
//    @BenchmarkMode(Mode.Throughput)
//    @OutputTimeUnit(TimeUnit.MICROSECONDS)
//    @Warmup(iterations = 4, time = 5)
//    @Measurement(iterations = 6, time = 10)
//    public void benchmarkForStreamListParallel(){
//        List.of(1,2,3,4,5).stream()
//                .parallel()
//                .map(i -> i + 1)
//                .max(Integer::compareTo);
//    }
//    @Benchmark
//    @Fork(1)
//    @BenchmarkMode(Mode.Throughput)
//    @OutputTimeUnit(TimeUnit.MICROSECONDS)
//    @Warmup(iterations = 4, time = 5)
//    @Measurement(iterations = 6, time = 10)
//    public void benchmarkForStreamIntStreamParallel(){
//        IntStream.rangeClosed(1, 5)
//                .parallel()
//                .map(i -> i + 1)
//                .max();
//    }
}
