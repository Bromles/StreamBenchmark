# Java Stream API vs classic for loop performance benchmark
## Java 11 with JMH 1.21 were used to count even numbers in an array of 100 million elements

### TL:DR results:
    
        Benchmark              (arraySize)  Mode  Cnt    Score    Error  Units
        Main.simpleArray         100000000  avgt   20  272.466 ± 11.935  ms/op
        Main.streamCountArray    100000000  avgt   20  848.575 ± 50.369  ms/op

### Full benchmark output

    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=45627:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 10 s each
    # Measurement: 10 iterations, 10 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.simpleArray
    # Parameters: (arraySize = 100000000)
     
    # Run progress: 0.00% complete, ETA 00:08:40
    # Fork: 1 of 2
    # Warmup Iteration   1: 293.051 ms/op
    # Warmup Iteration   2: 289.861 ms/op
    # Warmup Iteration   3: 271.948 ms/op
    Iteration   1: 256.450 ms/op
    Iteration   2: 263.974 ms/op
    Iteration   3: 255.963 ms/op
    Iteration   4: 271.319 ms/op
    Iteration   5: 261.639 ms/op
    Iteration   6: 271.707 ms/op
    Iteration   7: 264.470 ms/op
    Iteration   8: 269.206 ms/op
    Iteration   9: 279.236 ms/op
    Iteration  10: 298.910 ms/op
 
    # Run progress: 25.00% complete, ETA 00:07:03
    # Fork: 2 of 2
    # Warmup Iteration   1: 264.579 ms/op
    # Warmup Iteration   2: 275.000 ms/op
    # Warmup Iteration   3: 283.488 ms/op
    Iteration   1: 282.644 ms/op
    Iteration   2: 265.745 ms/op
    Iteration   3: 288.972 ms/op
    Iteration   4: 299.134 ms/op
    Iteration   5: 268.489 ms/op
    Iteration   6: 279.608 ms/op
    Iteration   7: 258.751 ms/op
    Iteration   8: 257.179 ms/op
    Iteration   9: 264.394 ms/op
    Iteration  10: 291.528 ms/op
 
 
    Result "com.bromles.Main.simpleArray":
        272.466 ±(99.9%) 11.935 ms/op [Average]
        (min, avg, max) = (255.963, 272.466, 299.134), stdev = 13.744
        CI (99.9%): [260.531, 284.401] (assumes normal distribution)
 
 
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=45627:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 10 s each
    # Measurement: 10 iterations, 10 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.streamCountArray
    # Parameters: (arraySize = 100000000)
 
    # Run progress: 50.00% complete, ETA 00:04:42
    # Fork: 1 of 2
    # Warmup Iteration   1: 835.289 ms/op
    # Warmup Iteration   2: 804.157 ms/op
    # Warmup Iteration   3: 818.048 ms/op
    Iteration   1: 838.259 ms/op
    Iteration   2: 794.954 ms/op
    Iteration   3: 833.792 ms/op
    Iteration   4: 812.272 ms/op
    Iteration   5: 825.855 ms/op
    Iteration   6: 813.735 ms/op
    Iteration   7: 816.283 ms/op
    Iteration   8: 773.150 ms/op
    Iteration   9: 780.315 ms/op
    Iteration  10: 893.345 ms/op
 
    # Run progress: 75.00% complete, ETA 00:02:23
    # Fork: 2 of 2
    # Warmup Iteration   1: 821.676 ms/op
    # Warmup Iteration   2: 784.329 ms/op
    # Warmup Iteration   3: 779.432 ms/op
    Iteration   1: 811.779 ms/op
    Iteration   2: 874.046 ms/op
    Iteration   3: 951.206 ms/op
    Iteration   4: 948.980 ms/op
    Iteration   5: 913.875 ms/op
    Iteration   6: 933.289 ms/op
    Iteration   7: 892.187 ms/op
    Iteration   8: 883.415 ms/op
    Iteration   9: 803.386 ms/op
    Iteration  10: 777.384 ms/op
 
 
    Result "com.bromles.Main.streamCountArray":
        848.575 ±(99.9%) 50.369 ms/op [Average]
        (min, avg, max) = (773.150, 848.575, 951.206), stdev = 58.005
        CI (99.9%): [798.206, 898.944] (assumes normal distribution)
 
 
    # Run complete. Total time: 00:09:37
 
    REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
    why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
    experiments, perform baseline and negative tests that provide experimental control, make sure
    the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
    Do not assume the numbers tell you what you want them to tell.
 
    Benchmark              (arraySize)  Mode  Cnt    Score    Error  Units
    Main.simpleArray         100000000  avgt   20  272.466 ± 11.935  ms/op
    Main.streamCountArray    100000000  avgt   20  848.575 ± 50.369  ms/op
 
