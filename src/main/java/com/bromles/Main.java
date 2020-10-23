package com.bromles;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3)
@Measurement(iterations = 10)
@State(Scope.Benchmark)
@Fork(value = 2)
public class Main {
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(Main.class.getSimpleName())
                .build();
        new Runner(options).run();
    }

    @Param({"100000000"})
    int arraySize;
    public Integer[] array;

    @Setup
    public void setup() {
        array = new Integer[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = new Random().nextInt(1000);
        }
    }

    @Benchmark
    public long simpleArray() {
        long count = 0;
        for(int i = 0; i < arraySize; i++) {
            if(array[i] % 2 == 0){
                count++;
            }
        }

        return count;
    }

    @Benchmark
    public long streamCountArray() {
        return Arrays.stream(array).filter(o -> o % 2 != 0).count();
    }
}
