package com.bromles;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3)
@Measurement(iterations = 10)
@State(Scope.Benchmark)
@Fork(value = 2)
public class StreamBenchmark {

    public Integer[] array;

    @Setup
    public void setup() {
        array = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    @Benchmark
    public long simpleArray() {
        long count = 0;
        for(int i = 0; i < 10; i++) {
            if(array[i] % 2 == 0){
                count++;
            }
        }

        return count;
    }

    @Benchmark
    public long streamArray() {
        return Arrays.stream(array).filter(o -> o % 2 != 0).count();
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(StreamBenchmark.class.getSimpleName())
                .build();
        new Runner(options).run();
    }
}
