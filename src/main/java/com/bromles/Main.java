package com.bromles;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 10, time = 2)
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

    public Integer[] arrayOnClass;
    public int[] arrayOnPrimitive;
    public ArrayList<Integer> arrayList;

    @Setup
    public void setup() {
        arrayOnPrimitive = ThreadLocalRandom.current().ints(0, 1000)
                .limit(arraySize).toArray();
        arrayOnClass = ThreadLocalRandom.current().ints(0, 1000)
                .limit(arraySize).boxed().toArray(Integer[]::new);
        arrayList = new ArrayList<>(Arrays.asList(arrayOnClass));
    }

    @Benchmark
    public long forLoopOnSimpleArrayOnClass() {
        long count = 0;

        for (int i = 0; i < arraySize; i++) {
            if (arrayOnClass[i] % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    @Benchmark
    public long forEachLoopOnSimpleArrayOnClass() {
        long count = 0;

        for (Integer i : arrayOnClass) {
            if (i % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    @Benchmark
    public long forLoopOnSimpleArrayOnPrimitive() {
        long count = 0;

        for (int i = 0; i < arraySize; i++) {
            if (arrayOnPrimitive[i] % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    @Benchmark
    public long forEachLoopOnSimpleArrayOnPrimitive() {
        long count = 0;

        for (Integer i : arrayOnPrimitive) {
            if (i % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    @Benchmark
    public long forLoopOnArrayList() {
        long count = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    @Benchmark
    public long forEachLoopOnArrayList() {
        long count = 0;

        for (Integer i : arrayList) {
            if (i % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    @Benchmark
    public long streamOnSimpleArrayOnClassWithFilter() {
        return Arrays.stream(arrayOnClass).filter(o -> o % 2 != 0).count();
    }

    @Benchmark
    public long streamOnSimpleArrayOnClassWithReduce() {
        return Arrays.stream(arrayOnClass).reduce(0, (a, b) -> b % 2 != 0 ? a + 1 : a);
    }

    @Benchmark
    public long parallelStreamOnSimpleArrayOnClassWithFilter() {
        return Arrays.stream(arrayOnClass).parallel().filter(o -> o % 2 != 0).count();
    }

    @Benchmark
    public long parallelStreamOnSimpleArrayOnClassWithReduce() {
        return Arrays.stream(arrayOnClass).parallel().reduce(0, (a, b) -> b % 2 != 0 ? a + 1 : a);
    }

    @Benchmark
    public long streamOnSimpleArrayOnPrimitiveWithFilter() {
        return Arrays.stream(arrayOnPrimitive).filter(o -> o % 2 != 0).count();
    }

    @Benchmark
    public long intStreamOnSimpleArrayOnPrimitiveWithFilter() {
        return IntStream.of(arrayOnPrimitive).filter(o -> o % 2 != 0).count();
    }

    @Benchmark
    public long streamOnSimpleArrayOnPrimitiveWithReduce() {
        return Arrays.stream(arrayOnPrimitive).reduce(0, (a, b) -> b % 2 != 0 ? a + 1 : a);
    }

    @Benchmark
    public long intStreamOnSimpleArrayOnPrimitiveWithReduce() {
        return IntStream.of(arrayOnPrimitive).reduce(0, (a, b) -> b % 2 != 0 ? a + 1 : a);
    }

    @Benchmark
    public long parallelStreamOnSimpleArrayOnPrimitiveWithFilter() {
        return Arrays.stream(arrayOnPrimitive).parallel().filter(o -> o % 2 != 0).count();
    }

    @Benchmark
    public long parallelIntStreamOnSimpleArrayOnPrimitiveWithFilter() {
        return IntStream.of(arrayOnPrimitive).parallel().filter(o -> o % 2 != 0).count();
    }

    @Benchmark
    public long parallelStreamOnSimpleArrayOnPrimitiveWithReduce() {
        return Arrays.stream(arrayOnPrimitive).parallel().reduce(0, (a, b) -> b % 2 != 0 ? a + 1 : a);
    }

    @Benchmark
    public long parallelIntStreamOnSimpleArrayOnPrimitiveWithReduce() {
        return IntStream.of(arrayOnPrimitive).parallel().reduce(0, (a, b) -> b % 2 != 0 ? a + 1 : a);
    }

    @Benchmark
    public long streamOnArrayListWithFilter() {
        return arrayList.stream().filter(o -> o % 2 != 0).count();
    }

    @Benchmark
    public long streamOnArrayListWithReduce() {
        return arrayList.stream().reduce(0, (a, b) -> b % 2 != 0 ? a + 1 : a);
    }

    @Benchmark
    public long parallelStreamOnArrayListWithFilter() {
        return arrayList.stream().parallel().filter(o -> o % 2 != 0).count();
    }

    @Benchmark
    public long parallelStreamOnArrayListWithReduce() {
        return arrayList.stream().parallel().reduce(0, (a, b) -> b % 2 != 0 ? a + 1 : a);
    }
}