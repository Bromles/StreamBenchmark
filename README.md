# Java Stream API vs classic for loop performance benchmark
### Java 11 with JMH 1.21 were used to count even numbers in an array of 100 million elements
### Configuration: 2 Forks, 3 Warmup Iterations, 10 Measurement Iterations

#### TL;DR results (ordered by score):
    
    Benchmark                                            (arraySize)  Mode  Cnt     Score    Error  Units
    parallelStreamOnSimpleArrayOnPrimitiveWithReduce      100000000   avgt   20    65.237 ± 32.303  ms/op
    parallelIntStreamOnSimpleArrayOnPrimitiveWithReduce   100000000   avgt   20    66.512 ± 34.315  ms/op
    forLoopOnSimpleArrayOnPrimitive                       100000000   avgt   20    71.541 ±  2.594  ms/op
    streamOnSimpleArrayOnPrimitiveWithReduce              100000000   avgt   20    87.087 ±  1.267  ms/op
    intStreamOnSimpleArrayOnPrimitiveWithReduce           100000000   avgt   20    87.360 ±  1.458  ms/op
    parallelStreamOnSimpleArrayOnPrimitiveWithFilter      100000000   avgt   20   102.852 ±  1.252  ms/op
    parallelIntStreamOnSimpleArrayOnPrimitiveWithFilter   100000000   avgt   20   122.384 ± 28.286  ms/op
    parallelStreamOnArrayListWithFilter                   100000000   avgt   20   173.798 ± 17.986  ms/op
    parallelStreamOnSimpleArrayOnClassWithFilter          100000000   avgt   20   183.783 ± 10.396  ms/op
    forEachLoopOnSimpleArrayOnClass                       100000000   avgt   20   250.709 ±  4.265  ms/op
    forLoopOnSimpleArrayOnClass                           100000000   avgt   20   268.845 ±  9.756  ms/op
    forLoopOnArrayList                                    100000000   avgt   20   291.629 ±  8.090  ms/op
    forEachLoopOnArrayList                                100000000   avgt   20   325.317 ±  9.851  ms/op
    forEachLoopOnSimpleArrayOnPrimitive                   100000000   avgt   20   406.020 ±  8.629  ms/op
    streamOnSimpleArrayOnPrimitiveWithFilter              100000000   avgt   20   429.699 ± 18.457  ms/op
    intStreamOnSimpleArrayOnPrimitiveWithFilter           100000000   avgt   20   439.117 ± 13.151  ms/op
    parallelStreamOnSimpleArrayOnClassWithReduce          100000000   avgt   20   471.038 ± 36.790  ms/op
    parallelStreamOnArrayListWithReduce                   100000000   avgt   20   478.093 ± 45.455  ms/op
    streamOnArrayListWithFilter                           100000000   avgt   20   743.722 ± 15.542  ms/op
    streamOnSimpleArrayOnClassWithFilter                  100000000   avgt   20   783.755 ± 19.685  ms/op
    streamOnArrayListWithReduce                           100000000   avgt   20  1341.798 ± 78.126  ms/op
    streamOnSimpleArrayOnClassWithReduce                  100000000   avgt   20  1411.742 ± 82.362  ms/op
    
    
#### Full benchmark output
    
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=33773:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 1 s each
    # Measurement: 10 iterations, 2 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.forEachLoopOnArrayList
    # Parameters: (arraySize = 100000000)
    
    # Run progress: 0.00% complete, ETA 00:16:52
    # Fork: 1 of 2
    # Warmup Iteration   1: 340.797 ms/op
    # Warmup Iteration   2: 282.118 ms/op
    # Warmup Iteration   3: 288.097 ms/op
    Iteration   1: 303.480 ms/op
    Iteration   2: 340.518 ms/op
    Iteration   3: 318.772 ms/op
    Iteration   4: 328.149 ms/op
    Iteration   5: 338.812 ms/op
    Iteration   6: 335.941 ms/op
    Iteration   7: 337.654 ms/op
    Iteration   8: 322.197 ms/op
    Iteration   9: 336.553 ms/op
    Iteration  10: 341.099 ms/op
    
    # Run progress: 2.27% complete, ETA 00:23:13
    # Fork: 2 of 2
    # Warmup Iteration   1: 301.791 ms/op
    # Warmup Iteration   2: 272.165 ms/op
    # Warmup Iteration   3: 270.816 ms/op
    Iteration   1: 304.655 ms/op
    Iteration   2: 325.043 ms/op
    Iteration   3: 318.708 ms/op
    Iteration   4: 336.058 ms/op
    Iteration   5: 327.930 ms/op
    Iteration   6: 317.682 ms/op
    Iteration   7: 319.633 ms/op
    Iteration   8: 316.616 ms/op
    Iteration   9: 318.628 ms/op
    Iteration  10: 318.218 ms/op
    
    
    Result "com.bromles.Main.forEachLoopOnArrayList":
      325.317 ±(99.9%) 9.851 ms/op [Average]
      (min, avg, max) = (303.480, 325.317, 341.099), stdev = 11.345
      CI (99.9%): [315.466, 335.169] (assumes normal distribution)
    
    
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=33773:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 1 s each
    # Measurement: 10 iterations, 2 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.forEachLoopOnSimpleArrayOnClass
    # Parameters: (arraySize = 100000000)
    
    # Run progress: 4.55% complete, ETA 00:22:37
    # Fork: 1 of 2
    # Warmup Iteration   1: 230.304 ms/op
    # Warmup Iteration   2: 245.781 ms/op
    # Warmup Iteration   3: 246.564 ms/op
    Iteration   1: 244.970 ms/op
    Iteration   2: 248.138 ms/op
    Iteration   3: 246.708 ms/op
    Iteration   4: 254.007 ms/op
    Iteration   5: 246.251 ms/op
    Iteration   6: 248.635 ms/op
    Iteration   7: 244.917 ms/op
    Iteration   8: 245.918 ms/op
    Iteration   9: 247.352 ms/op
    Iteration  10: 248.395 ms/op
    
    # Run progress: 6.82% complete, ETA 00:22:01
    # Fork: 2 of 2
    # Warmup Iteration   1: 223.629 ms/op
    # Warmup Iteration   2: 222.515 ms/op
    # Warmup Iteration   3: 221.663 ms/op
    Iteration   1: 245.045 ms/op
    Iteration   2: 255.950 ms/op
    Iteration   3: 255.646 ms/op
    Iteration   4: 255.483 ms/op
    Iteration   5: 257.253 ms/op
    Iteration   6: 255.532 ms/op
    Iteration   7: 245.354 ms/op
    Iteration   8: 257.418 ms/op
    Iteration   9: 255.990 ms/op
    Iteration  10: 255.217 ms/op
    
    
    Result "com.bromles.Main.forEachLoopOnSimpleArrayOnClass":
      250.709 ±(99.9%) 4.265 ms/op [Average]
      (min, avg, max) = (244.917, 250.709, 257.418), stdev = 4.912
      CI (99.9%): [246.444, 254.974] (assumes normal distribution)
    
    
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=33773:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 1 s each
    # Measurement: 10 iterations, 2 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.forEachLoopOnSimpleArrayOnPrimitive
    # Parameters: (arraySize = 100000000)
    
    # Run progress: 9.09% complete, ETA 00:21:13
    # Fork: 1 of 2
    # Warmup Iteration   1: 387.156 ms/op
    # Warmup Iteration   2: 335.588 ms/op
    # Warmup Iteration   3: 316.571 ms/op
    Iteration   1: 401.017 ms/op
    Iteration   2: 417.230 ms/op
    Iteration   3: 392.091 ms/op
    Iteration   4: 406.303 ms/op
    Iteration   5: 396.033 ms/op
    Iteration   6: 412.285 ms/op
    Iteration   7: 406.746 ms/op
    Iteration   8: 407.713 ms/op
    Iteration   9: 422.908 ms/op
    Iteration  10: 398.550 ms/op
    
    # Run progress: 11.36% complete, ETA 00:20:54
    # Fork: 2 of 2
    # Warmup Iteration   1: 581.969 ms/op
    # Warmup Iteration   2: 445.696 ms/op
    # Warmup Iteration   3: 410.969 ms/op
    Iteration   1: 398.493 ms/op
    Iteration   2: 406.707 ms/op
    Iteration   3: 395.489 ms/op
    Iteration   4: 410.907 ms/op
    Iteration   5: 410.816 ms/op
    Iteration   6: 410.242 ms/op
    Iteration   7: 425.749 ms/op
    Iteration   8: 393.555 ms/op
    Iteration   9: 415.198 ms/op
    Iteration  10: 392.369 ms/op
    
    
    Result "com.bromles.Main.forEachLoopOnSimpleArrayOnPrimitive":
      406.020 ±(99.9%) 8.629 ms/op [Average]
      (min, avg, max) = (392.091, 406.020, 425.749), stdev = 9.937
      CI (99.9%): [397.391, 414.649] (assumes normal distribution)
    
    
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=33773:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 1 s each
    # Measurement: 10 iterations, 2 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.forLoopOnArrayList
    # Parameters: (arraySize = 100000000)
    
    # Run progress: 13.64% complete, ETA 00:20:47
    # Fork: 1 of 2
    # Warmup Iteration   1: 339.939 ms/op
    # Warmup Iteration   2: 287.486 ms/op
    # Warmup Iteration   3: 287.119 ms/op
    Iteration   1: 293.241 ms/op
    Iteration   2: 287.893 ms/op
    Iteration   3: 288.443 ms/op
    Iteration   4: 288.110 ms/op
    Iteration   5: 289.217 ms/op
    Iteration   6: 288.952 ms/op
    Iteration   7: 286.948 ms/op
    Iteration   8: 287.023 ms/op
    Iteration   9: 286.790 ms/op
    Iteration  10: 287.151 ms/op
    
    # Run progress: 15.91% complete, ETA 00:20:03
    # Fork: 2 of 2
    # Warmup Iteration   1: 308.257 ms/op
    # Warmup Iteration   2: 285.419 ms/op
    # Warmup Iteration   3: 285.270 ms/op
    Iteration   1: 289.925 ms/op
    Iteration   2: 305.667 ms/op
    Iteration   3: 290.009 ms/op
    Iteration   4: 297.855 ms/op
    Iteration   5: 286.708 ms/op
    Iteration   6: 282.651 ms/op
    Iteration   7: 286.627 ms/op
    Iteration   8: 293.492 ms/op
    Iteration   9: 325.313 ms/op
    Iteration  10: 290.561 ms/op
    
    
    Result "com.bromles.Main.forLoopOnArrayList":
      291.629 ±(99.9%) 8.090 ms/op [Average]
      (min, avg, max) = (282.651, 291.629, 325.313), stdev = 9.316
      CI (99.9%): [283.539, 299.719] (assumes normal distribution)
    
    
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=33773:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 1 s each
    # Measurement: 10 iterations, 2 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.forLoopOnSimpleArrayOnClass
    # Parameters: (arraySize = 100000000)
    
    # Run progress: 18.18% complete, ETA 00:19:23
    # Fork: 1 of 2
    # Warmup Iteration   1: 219.235 ms/op
    # Warmup Iteration   2: 218.439 ms/op
    # Warmup Iteration   3: 218.347 ms/op
    Iteration   1: 241.600 ms/op
    Iteration   2: 270.004 ms/op
    Iteration   3: 265.304 ms/op
    Iteration   4: 288.532 ms/op
    Iteration   5: 293.950 ms/op
    Iteration   6: 269.891 ms/op
    Iteration   7: 254.832 ms/op
    Iteration   8: 271.767 ms/op
    Iteration   9: 270.273 ms/op
    Iteration  10: 279.047 ms/op
    
    # Run progress: 20.45% complete, ETA 00:18:48
    # Fork: 2 of 2
    # Warmup Iteration   1: 239.483 ms/op
    # Warmup Iteration   2: 221.812 ms/op
    # Warmup Iteration   3: 223.925 ms/op
    Iteration   1: 266.328 ms/op
    Iteration   2: 277.143 ms/op
    Iteration   3: 264.064 ms/op
    Iteration   4: 259.104 ms/op
    Iteration   5: 262.919 ms/op
    Iteration   6: 271.031 ms/op
    Iteration   7: 272.165 ms/op
    Iteration   8: 271.748 ms/op
    Iteration   9: 265.197 ms/op
    Iteration  10: 262.007 ms/op
    
    
    Result "com.bromles.Main.forLoopOnSimpleArrayOnClass":
      268.845 ±(99.9%) 9.756 ms/op [Average]
      (min, avg, max) = (241.600, 268.845, 293.950), stdev = 11.235
      CI (99.9%): [259.089, 278.602] (assumes normal distribution)
    
    
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=33773:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 1 s each
    # Measurement: 10 iterations, 2 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.forLoopOnSimpleArrayOnPrimitive
    # Parameters: (arraySize = 100000000)
    
    # Run progress: 22.73% complete, ETA 00:18:15
    # Fork: 1 of 2
    # Warmup Iteration   1: 73.448 ms/op
    # Warmup Iteration   2: 72.779 ms/op
    # Warmup Iteration   3: 92.787 ms/op
    Iteration   1: 71.772 ms/op
    Iteration   2: 68.250 ms/op
    Iteration   3: 68.026 ms/op
    Iteration   4: 70.480 ms/op
    Iteration   5: 68.513 ms/op
    Iteration   6: 68.385 ms/op
    Iteration   7: 75.288 ms/op
    Iteration   8: 75.669 ms/op
    Iteration   9: 68.215 ms/op
    Iteration  10: 72.082 ms/op
    
    # Run progress: 25.00% complete, ETA 00:17:37
    # Fork: 2 of 2
    # Warmup Iteration   1: 74.838 ms/op
    # Warmup Iteration   2: 67.584 ms/op
    # Warmup Iteration   3: 68.938 ms/op
    Iteration   1: 69.555 ms/op
    Iteration   2: 67.913 ms/op
    Iteration   3: 72.171 ms/op
    Iteration   4: 73.351 ms/op
    Iteration   5: 74.448 ms/op
    Iteration   6: 70.664 ms/op
    Iteration   7: 72.423 ms/op
    Iteration   8: 78.575 ms/op
    Iteration   9: 73.384 ms/op
    Iteration  10: 71.657 ms/op
    
    
    Result "com.bromles.Main.forLoopOnSimpleArrayOnPrimitive":
      71.541 ±(99.9%) 2.594 ms/op [Average]
      (min, avg, max) = (67.913, 71.541, 78.575), stdev = 2.988
      CI (99.9%): [68.947, 74.135] (assumes normal distribution)
    
    
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=33773:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 1 s each
    # Measurement: 10 iterations, 2 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.intStreamOnSimpleArrayOnPrimitiveWithFilter
    # Parameters: (arraySize = 100000000)
    
    # Run progress: 27.27% complete, ETA 00:17:02
    # Fork: 1 of 2
    # Warmup Iteration   1: 596.616 ms/op
    # Warmup Iteration   2: 433.777 ms/op
    # Warmup Iteration   3: 427.343 ms/op
    Iteration   1: 429.817 ms/op
    Iteration   2: 445.338 ms/op
    Iteration   3: 454.245 ms/op
    Iteration   4: 458.640 ms/op
    Iteration   5: 464.421 ms/op
    Iteration   6: 456.635 ms/op
    Iteration   7: 449.963 ms/op
    Iteration   8: 447.060 ms/op
    Iteration   9: 452.595 ms/op
    Iteration  10: 448.855 ms/op
    
    # Run progress: 29.55% complete, ETA 00:16:34
    # Fork: 2 of 2
    # Warmup Iteration   1: 570.145 ms/op
    # Warmup Iteration   2: 529.005 ms/op
    # Warmup Iteration   3: 536.075 ms/op
    Iteration   1: 440.856 ms/op
    Iteration   2: 426.317 ms/op
    Iteration   3: 417.190 ms/op
    Iteration   4: 416.726 ms/op
    Iteration   5: 417.855 ms/op
    Iteration   6: 426.329 ms/op
    Iteration   7: 426.894 ms/op
    Iteration   8: 436.377 ms/op
    Iteration   9: 422.518 ms/op
    Iteration  10: 443.714 ms/op
    
    
    Result "com.bromles.Main.intStreamOnSimpleArrayOnPrimitiveWithFilter":
      439.117 ±(99.9%) 13.151 ms/op [Average]
      (min, avg, max) = (416.726, 439.117, 464.421), stdev = 15.144
      CI (99.9%): [425.966, 452.268] (assumes normal distribution)
    
    
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=33773:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 1 s each
    # Measurement: 10 iterations, 2 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.intStreamOnSimpleArrayOnPrimitiveWithReduce
    # Parameters: (arraySize = 100000000)
    
    # Run progress: 31.82% complete, ETA 00:16:01
    # Fork: 1 of 2
    # Warmup Iteration   1: 97.409 ms/op
    # Warmup Iteration   2: 86.374 ms/op
    # Warmup Iteration   3: 85.996 ms/op
    Iteration   1: 86.340 ms/op
    Iteration   2: 86.390 ms/op
    Iteration   3: 91.640 ms/op
    Iteration   4: 89.333 ms/op
    Iteration   5: 87.671 ms/op
    Iteration   6: 86.404 ms/op
    Iteration   7: 86.898 ms/op
    Iteration   8: 88.765 ms/op
    Iteration   9: 88.953 ms/op
    Iteration  10: 86.552 ms/op
    
    # Run progress: 34.09% complete, ETA 00:15:26
    # Fork: 2 of 2
    # Warmup Iteration   1: 140.991 ms/op
    # Warmup Iteration   2: 86.284 ms/op
    # Warmup Iteration   3: 86.769 ms/op
    Iteration   1: 88.026 ms/op
    Iteration   2: 86.051 ms/op
    Iteration   3: 85.686 ms/op
    Iteration   4: 88.012 ms/op
    Iteration   5: 86.214 ms/op
    Iteration   6: 85.711 ms/op
    Iteration   7: 85.698 ms/op
    Iteration   8: 86.335 ms/op
    Iteration   9: 90.278 ms/op
    Iteration  10: 86.250 ms/op
    
    
    Result "com.bromles.Main.intStreamOnSimpleArrayOnPrimitiveWithReduce":
      87.360 ±(99.9%) 1.458 ms/op [Average]
      (min, avg, max) = (85.686, 87.360, 91.640), stdev = 1.679
      CI (99.9%): [85.902, 88.818] (assumes normal distribution)
    
    
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=33773:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 1 s each
    # Measurement: 10 iterations, 2 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.parallelIntStreamOnSimpleArrayOnPrimitiveWithFilter
    # Parameters: (arraySize = 100000000)
    
    # Run progress: 36.36% complete, ETA 00:14:53
    # Fork: 1 of 2
    # Warmup Iteration   1: 139.158 ms/op
    # Warmup Iteration   2: 133.944 ms/op
    # Warmup Iteration   3: 129.901 ms/op
    Iteration   1: 131.233 ms/op
    Iteration   2: 125.331 ms/op
    Iteration   3: 103.521 ms/op
    Iteration   4: 109.734 ms/op
    Iteration   5: 102.579 ms/op
    Iteration   6: 101.300 ms/op
    Iteration   7: 102.886 ms/op
    Iteration   8: 154.832 ms/op
    Iteration   9: 212.881 ms/op
    Iteration  10: 201.465 ms/op
    
    # Run progress: 38.64% complete, ETA 00:14:20
    # Fork: 2 of 2
    # Warmup Iteration   1: 155.744 ms/op
    # Warmup Iteration   2: 130.283 ms/op
    # Warmup Iteration   3: 135.121 ms/op
    Iteration   1: 128.453 ms/op
    Iteration   2: 133.194 ms/op
    Iteration   3: 120.135 ms/op
    Iteration   4: 102.858 ms/op
    Iteration   5: 99.435 ms/op
    Iteration   6: 102.138 ms/op
    Iteration   7: 102.866 ms/op
    Iteration   8: 105.053 ms/op
    Iteration   9: 102.714 ms/op
    Iteration  10: 105.077 ms/op
    
    
    Result "com.bromles.Main.parallelIntStreamOnSimpleArrayOnPrimitiveWithFilter":
      122.384 ±(99.9%) 28.286 ms/op [Average]
      (min, avg, max) = (99.435, 122.384, 212.881), stdev = 32.574
      CI (99.9%): [94.098, 150.670] (assumes normal distribution)
    
    
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=33773:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 1 s each
    # Measurement: 10 iterations, 2 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.parallelIntStreamOnSimpleArrayOnPrimitiveWithReduce
    # Parameters: (arraySize = 100000000)
    
    # Run progress: 40.91% complete, ETA 00:13:48
    # Fork: 1 of 2
    # Warmup Iteration   1: 33.646 ms/op
    # Warmup Iteration   2: 28.414 ms/op
    # Warmup Iteration   3: 28.496 ms/op
    Iteration   1: 28.759 ms/op
    Iteration   2: 87.316 ms/op
    Iteration   3: 111.622 ms/op
    Iteration   4: 110.337 ms/op
    Iteration   5: 108.894 ms/op
    Iteration   6: 114.230 ms/op
    Iteration   7: 110.219 ms/op
    Iteration   8: 114.625 ms/op
    Iteration   9: 110.506 ms/op
    Iteration  10: 110.382 ms/op
    
    # Run progress: 43.18% complete, ETA 00:13:15
    # Fork: 2 of 2
    # Warmup Iteration   1: 29.591 ms/op
    # Warmup Iteration   2: 28.551 ms/op
    # Warmup Iteration   3: 28.021 ms/op
    Iteration   1: 28.902 ms/op
    Iteration   2: 32.476 ms/op
    Iteration   3: 32.792 ms/op
    Iteration   4: 32.539 ms/op
    Iteration   5: 32.306 ms/op
    Iteration   6: 32.660 ms/op
    Iteration   7: 32.465 ms/op
    Iteration   8: 32.285 ms/op
    Iteration   9: 34.428 ms/op
    Iteration  10: 32.490 ms/op
    
    
    Result "com.bromles.Main.parallelIntStreamOnSimpleArrayOnPrimitiveWithReduce":
      66.512 ±(99.9%) 34.315 ms/op [Average]
      (min, avg, max) = (28.759, 66.512, 114.625), stdev = 39.517
      CI (99.9%): [32.197, 100.826] (assumes normal distribution)
    
    
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=33773:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 1 s each
    # Measurement: 10 iterations, 2 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.parallelStreamOnArrayListWithFilter
    # Parameters: (arraySize = 100000000)
    
    # Run progress: 45.45% complete, ETA 00:12:42
    # Fork: 1 of 2
    # Warmup Iteration   1: 223.636 ms/op
    # Warmup Iteration   2: 220.588 ms/op
    # Warmup Iteration   3: 216.912 ms/op
    Iteration   1: 233.257 ms/op
    Iteration   2: 223.536 ms/op
    Iteration   3: 177.740 ms/op
    Iteration   4: 174.243 ms/op
    Iteration   5: 178.152 ms/op
    Iteration   6: 170.929 ms/op
    Iteration   7: 182.386 ms/op
    Iteration   8: 174.041 ms/op
    Iteration   9: 176.148 ms/op
    Iteration  10: 184.093 ms/op
    
    # Run progress: 47.73% complete, ETA 00:12:11
    # Fork: 2 of 2
    # Warmup Iteration   1: 163.411 ms/op
    # Warmup Iteration   2: 157.703 ms/op
    # Warmup Iteration   3: 167.105 ms/op
    Iteration   1: 159.621 ms/op
    Iteration   2: 163.335 ms/op
    Iteration   3: 157.045 ms/op
    Iteration   4: 157.349 ms/op
    Iteration   5: 160.074 ms/op
    Iteration   6: 162.399 ms/op
    Iteration   7: 158.308 ms/op
    Iteration   8: 162.125 ms/op
    Iteration   9: 158.562 ms/op
    Iteration  10: 162.617 ms/op
    
    
    Result "com.bromles.Main.parallelStreamOnArrayListWithFilter":
      173.798 ±(99.9%) 17.986 ms/op [Average]
      (min, avg, max) = (157.045, 173.798, 233.257), stdev = 20.712
      CI (99.9%): [155.813, 191.784] (assumes normal distribution)
    
    
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=33773:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 1 s each
    # Measurement: 10 iterations, 2 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.parallelStreamOnArrayListWithReduce
    # Parameters: (arraySize = 100000000)
    
    # Run progress: 50.00% complete, ETA 00:11:39
    # Fork: 1 of 2
    # Warmup Iteration   1: 668.062 ms/op
    # Warmup Iteration   2: 505.732 ms/op
    # Warmup Iteration   3: 510.646 ms/op
    Iteration   1: 507.406 ms/op
    Iteration   2: 454.138 ms/op
    Iteration   3: 409.275 ms/op
    Iteration   4: 428.295 ms/op
    Iteration   5: 497.129 ms/op
    Iteration   6: 483.401 ms/op
    Iteration   7: 407.514 ms/op
    Iteration   8: 405.150 ms/op
    Iteration   9: 496.828 ms/op
    Iteration  10: 489.646 ms/op
    
    # Run progress: 52.27% complete, ETA 00:11:10
    # Fork: 2 of 2
    # Warmup Iteration   1: 572.903 ms/op
    # Warmup Iteration   2: 512.624 ms/op
    # Warmup Iteration   3: 529.642 ms/op
    Iteration   1: 512.663 ms/op
    Iteration   2: 428.588 ms/op
    Iteration   3: 411.909 ms/op
    Iteration   4: 488.246 ms/op
    Iteration   5: 545.600 ms/op
    Iteration   6: 480.656 ms/op
    Iteration   7: 466.308 ms/op
    Iteration   8: 537.574 ms/op
    Iteration   9: 599.356 ms/op
    Iteration  10: 512.185 ms/op
    
    
    Result "com.bromles.Main.parallelStreamOnArrayListWithReduce":
      478.093 ±(99.9%) 45.455 ms/op [Average]
      (min, avg, max) = (405.150, 478.093, 599.356), stdev = 52.346
      CI (99.9%): [432.638, 523.549] (assumes normal distribution)
    
    
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=33773:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 1 s each
    # Measurement: 10 iterations, 2 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.parallelStreamOnSimpleArrayOnClassWithFilter
    # Parameters: (arraySize = 100000000)
    
    # Run progress: 54.55% complete, ETA 00:10:40
    # Fork: 1 of 2
    # Warmup Iteration   1: 232.815 ms/op
    # Warmup Iteration   2: 221.623 ms/op
    # Warmup Iteration   3: 204.138 ms/op
    Iteration   1: 219.825 ms/op
    Iteration   2: 211.714 ms/op
    Iteration   3: 176.206 ms/op
    Iteration   4: 190.687 ms/op
    Iteration   5: 183.907 ms/op
    Iteration   6: 179.216 ms/op
    Iteration   7: 177.297 ms/op
    Iteration   8: 174.860 ms/op
    Iteration   9: 176.715 ms/op
    Iteration  10: 174.740 ms/op
    
    # Run progress: 56.82% complete, ETA 00:10:09
    # Fork: 2 of 2
    # Warmup Iteration   1: 214.888 ms/op
    # Warmup Iteration   2: 184.399 ms/op
    # Warmup Iteration   3: 179.122 ms/op
    Iteration   1: 178.426 ms/op
    Iteration   2: 191.060 ms/op
    Iteration   3: 178.424 ms/op
    Iteration   4: 184.436 ms/op
    Iteration   5: 181.077 ms/op
    Iteration   6: 176.293 ms/op
    Iteration   7: 184.873 ms/op
    Iteration   8: 179.054 ms/op
    Iteration   9: 180.620 ms/op
    Iteration  10: 176.240 ms/op
    
    
    Result "com.bromles.Main.parallelStreamOnSimpleArrayOnClassWithFilter":
      183.783 ±(99.9%) 10.396 ms/op [Average]
      (min, avg, max) = (174.740, 183.783, 219.825), stdev = 11.972
      CI (99.9%): [173.388, 194.179] (assumes normal distribution)
    
    
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=33773:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 1 s each
    # Measurement: 10 iterations, 2 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.parallelStreamOnSimpleArrayOnClassWithReduce
    # Parameters: (arraySize = 100000000)
    
    # Run progress: 59.09% complete, ETA 00:09:37
    # Fork: 1 of 2
    # Warmup Iteration   1: 724.986 ms/op
    # Warmup Iteration   2: 522.993 ms/op
    # Warmup Iteration   3: 521.937 ms/op
    Iteration   1: 518.663 ms/op
    Iteration   2: 417.714 ms/op
    Iteration   3: 419.018 ms/op
    Iteration   4: 501.347 ms/op
    Iteration   5: 504.392 ms/op
    Iteration   6: 476.542 ms/op
    Iteration   7: 405.078 ms/op
    Iteration   8: 454.021 ms/op
    Iteration   9: 527.230 ms/op
    Iteration  10: 479.733 ms/op
    
    # Run progress: 61.36% complete, ETA 00:09:06
    # Fork: 2 of 2
    # Warmup Iteration   1: 679.449 ms/op
    # Warmup Iteration   2: 477.659 ms/op
    # Warmup Iteration   3: 514.234 ms/op
    Iteration   1: 519.425 ms/op
    Iteration   2: 479.684 ms/op
    Iteration   3: 434.272 ms/op
    Iteration   4: 435.606 ms/op
    Iteration   5: 510.226 ms/op
    Iteration   6: 504.869 ms/op
    Iteration   7: 419.069 ms/op
    Iteration   8: 408.365 ms/op
    Iteration   9: 504.869 ms/op
    Iteration  10: 500.632 ms/op
    
    
    Result "com.bromles.Main.parallelStreamOnSimpleArrayOnClassWithReduce":
      471.038 ±(99.9%) 36.790 ms/op [Average]
      (min, avg, max) = (405.078, 471.038, 527.230), stdev = 42.367
      CI (99.9%): [434.248, 507.828] (assumes normal distribution)
    
    
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=33773:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 1 s each
    # Measurement: 10 iterations, 2 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.parallelStreamOnSimpleArrayOnPrimitiveWithFilter
    # Parameters: (arraySize = 100000000)
    
    # Run progress: 63.64% complete, ETA 00:08:36
    # Fork: 1 of 2
    # Warmup Iteration   1: 106.703 ms/op
    # Warmup Iteration   2: 108.472 ms/op
    # Warmup Iteration   3: 101.270 ms/op
    Iteration   1: 101.388 ms/op
    Iteration   2: 103.798 ms/op
    Iteration   3: 102.862 ms/op
    Iteration   4: 103.607 ms/op
    Iteration   5: 101.721 ms/op
    Iteration   6: 102.151 ms/op
    Iteration   7: 106.195 ms/op
    Iteration   8: 101.575 ms/op
    Iteration   9: 102.674 ms/op
    Iteration  10: 104.646 ms/op
    
    # Run progress: 65.91% complete, ETA 00:08:03
    # Fork: 2 of 2
    # Warmup Iteration   1: 107.371 ms/op
    # Warmup Iteration   2: 101.615 ms/op
    # Warmup Iteration   3: 99.274 ms/op
    Iteration   1: 101.984 ms/op
    Iteration   2: 102.645 ms/op
    Iteration   3: 102.726 ms/op
    Iteration   4: 100.447 ms/op
    Iteration   5: 103.445 ms/op
    Iteration   6: 105.044 ms/op
    Iteration   7: 102.250 ms/op
    Iteration   8: 104.580 ms/op
    Iteration   9: 101.534 ms/op
    Iteration  10: 101.760 ms/op
    
    
    Result "com.bromles.Main.parallelStreamOnSimpleArrayOnPrimitiveWithFilter":
      102.852 ±(99.9%) 1.252 ms/op [Average]
      (min, avg, max) = (100.447, 102.852, 106.195), stdev = 1.441
      CI (99.9%): [101.600, 104.103] (assumes normal distribution)
    
    
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=33773:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 1 s each
    # Measurement: 10 iterations, 2 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.parallelStreamOnSimpleArrayOnPrimitiveWithReduce
    # Parameters: (arraySize = 100000000)
    
    # Run progress: 68.18% complete, ETA 00:07:30
    # Fork: 1 of 2
    # Warmup Iteration   1: 31.998 ms/op
    # Warmup Iteration   2: 28.499 ms/op
    # Warmup Iteration   3: 29.104 ms/op
    Iteration   1: 35.820 ms/op
    Iteration   2: 47.851 ms/op
    Iteration   3: 32.653 ms/op
    Iteration   4: 32.712 ms/op
    Iteration   5: 32.615 ms/op
    Iteration   6: 32.642 ms/op
    Iteration   7: 32.176 ms/op
    Iteration   8: 31.381 ms/op
    Iteration   9: 32.637 ms/op
    Iteration  10: 31.143 ms/op
    
    # Run progress: 70.45% complete, ETA 00:06:57
    # Fork: 2 of 2
    # Warmup Iteration   1: 34.520 ms/op
    # Warmup Iteration   2: 32.618 ms/op
    # Warmup Iteration   3: 34.519 ms/op
    Iteration   1: 34.694 ms/op
    Iteration   2: 55.710 ms/op
    Iteration   3: 109.532 ms/op
    Iteration   4: 108.671 ms/op
    Iteration   5: 108.463 ms/op
    Iteration   6: 111.157 ms/op
    Iteration   7: 109.444 ms/op
    Iteration   8: 108.183 ms/op
    Iteration   9: 109.309 ms/op
    Iteration  10: 107.955 ms/op
    
    
    Result "com.bromles.Main.parallelStreamOnSimpleArrayOnPrimitiveWithReduce":
      65.237 ±(99.9%) 32.303 ms/op [Average]
      (min, avg, max) = (31.143, 65.237, 111.157), stdev = 37.200
      CI (99.9%): [32.934, 97.541] (assumes normal distribution)
    
    
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=33773:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 1 s each
    # Measurement: 10 iterations, 2 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.streamOnArrayListWithFilter
    # Parameters: (arraySize = 100000000)
    
    # Run progress: 72.73% complete, ETA 00:06:25
    # Fork: 1 of 2
    # Warmup Iteration   1: 828.573 ms/op
    # Warmup Iteration   2: 825.358 ms/op
    # Warmup Iteration   3: 752.338 ms/op
    Iteration   1: 736.926 ms/op
    Iteration   2: 732.317 ms/op
    Iteration   3: 725.214 ms/op
    Iteration   4: 723.486 ms/op
    Iteration   5: 728.673 ms/op
    Iteration   6: 723.139 ms/op
    Iteration   7: 723.941 ms/op
    Iteration   8: 724.073 ms/op
    Iteration   9: 728.439 ms/op
    Iteration  10: 728.167 ms/op
    
    # Run progress: 75.00% complete, ETA 00:05:54
    # Fork: 2 of 2
    # Warmup Iteration   1: 771.659 ms/op
    # Warmup Iteration   2: 768.349 ms/op
    # Warmup Iteration   3: 846.249 ms/op
    Iteration   1: 761.159 ms/op
    Iteration   2: 773.934 ms/op
    Iteration   3: 752.142 ms/op
    Iteration   4: 754.038 ms/op
    Iteration   5: 775.781 ms/op
    Iteration   6: 755.102 ms/op
    Iteration   7: 757.450 ms/op
    Iteration   8: 757.429 ms/op
    Iteration   9: 756.879 ms/op
    Iteration  10: 756.140 ms/op
    
    
    Result "com.bromles.Main.streamOnArrayListWithFilter":
      743.722 ±(99.9%) 15.542 ms/op [Average]
      (min, avg, max) = (723.139, 743.722, 775.781), stdev = 17.898
      CI (99.9%): [728.180, 759.263] (assumes normal distribution)
    
    
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=33773:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 1 s each
    # Measurement: 10 iterations, 2 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.streamOnArrayListWithReduce
    # Parameters: (arraySize = 100000000)
    
    # Run progress: 77.27% complete, ETA 00:05:24
    # Fork: 1 of 2
    # Warmup Iteration   1: 1788.038 ms/op
    # Warmup Iteration   2: 1488.160 ms/op
    # Warmup Iteration   3: 1340.935 ms/op
    Iteration   1: 1382.472 ms/op
    Iteration   2: 1326.967 ms/op
    Iteration   3: 1328.450 ms/op
    Iteration   4: 1354.742 ms/op
    Iteration   5: 1288.106 ms/op
    Iteration   6: 1389.085 ms/op
    Iteration   7: 1250.209 ms/op
    Iteration   8: 1447.799 ms/op
    Iteration   9: 1264.347 ms/op
    Iteration  10: 1510.840 ms/op
    
    # Run progress: 79.55% complete, ETA 00:04:54
    # Fork: 2 of 2
    # Warmup Iteration   1: 2343.872 ms/op
    # Warmup Iteration   2: 1605.342 ms/op
    # Warmup Iteration   3: 1439.161 ms/op
    Iteration   1: 1227.133 ms/op
    Iteration   2: 1468.747 ms/op
    Iteration   3: 1239.360 ms/op
    Iteration   4: 1438.315 ms/op
    Iteration   5: 1313.611 ms/op
    Iteration   6: 1330.171 ms/op
    Iteration   7: 1404.899 ms/op
    Iteration   8: 1237.358 ms/op
    Iteration   9: 1430.921 ms/op
    Iteration  10: 1202.422 ms/op
    
    
    Result "com.bromles.Main.streamOnArrayListWithReduce":
      1341.798 ±(99.9%) 78.126 ms/op [Average]
      (min, avg, max) = (1202.422, 1341.798, 1510.840), stdev = 89.970
      CI (99.9%): [1263.671, 1419.924] (assumes normal distribution)
    
    
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=33773:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 1 s each
    # Measurement: 10 iterations, 2 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.streamOnSimpleArrayOnClassWithFilter
    # Parameters: (arraySize = 100000000)
    
    # Run progress: 81.82% complete, ETA 00:04:23
    # Fork: 1 of 2
    # Warmup Iteration   1: 823.432 ms/op
    # Warmup Iteration   2: 797.946 ms/op
    # Warmup Iteration   3: 851.279 ms/op
    Iteration   1: 784.074 ms/op
    Iteration   2: 764.228 ms/op
    Iteration   3: 762.292 ms/op
    Iteration   4: 767.122 ms/op
    Iteration   5: 781.133 ms/op
    Iteration   6: 769.051 ms/op
    Iteration   7: 830.793 ms/op
    Iteration   8: 801.030 ms/op
    Iteration   9: 797.069 ms/op
    Iteration  10: 766.786 ms/op
    
    # Run progress: 84.09% complete, ETA 00:03:51
    # Fork: 2 of 2
    # Warmup Iteration   1: 848.042 ms/op
    # Warmup Iteration   2: 957.187 ms/op
    # Warmup Iteration   3: 894.716 ms/op
    Iteration   1: 813.475 ms/op
    Iteration   2: 816.538 ms/op
    Iteration   3: 816.744 ms/op
    Iteration   4: 804.112 ms/op
    Iteration   5: 766.396 ms/op
    Iteration   6: 778.239 ms/op
    Iteration   7: 761.161 ms/op
    Iteration   8: 772.150 ms/op
    Iteration   9: 762.918 ms/op
    Iteration  10: 759.784 ms/op
    
    
    Result "com.bromles.Main.streamOnSimpleArrayOnClassWithFilter":
      783.755 ±(99.9%) 19.685 ms/op [Average]
      (min, avg, max) = (759.784, 783.755, 830.793), stdev = 22.670
      CI (99.9%): [764.070, 803.440] (assumes normal distribution)
    
    
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=33773:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 1 s each
    # Measurement: 10 iterations, 2 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.streamOnSimpleArrayOnClassWithReduce
    # Parameters: (arraySize = 100000000)
    
    # Run progress: 86.36% complete, ETA 00:03:19
    # Fork: 1 of 2
    # Warmup Iteration   1: 1906.795 ms/op
    # Warmup Iteration   2: 1439.313 ms/op
    # Warmup Iteration   3: 1392.890 ms/op
    Iteration   1: 1322.113 ms/op
    Iteration   2: 1463.030 ms/op
    Iteration   3: 1349.945 ms/op
    Iteration   4: 1427.982 ms/op
    Iteration   5: 1383.490 ms/op
    Iteration   6: 1388.124 ms/op
    Iteration   7: 1415.939 ms/op
    Iteration   8: 1339.580 ms/op
    Iteration   9: 1522.173 ms/op
    Iteration  10: 1397.566 ms/op
    
    # Run progress: 88.64% complete, ETA 00:02:47
    # Fork: 2 of 2
    # Warmup Iteration   1: 1586.494 ms/op
    # Warmup Iteration   2: 1645.707 ms/op
    # Warmup Iteration   3: 1490.513 ms/op
    Iteration   1: 1356.525 ms/op
    Iteration   2: 1434.976 ms/op
    Iteration   3: 1330.780 ms/op
    Iteration   4: 1495.598 ms/op
    Iteration   5: 1323.348 ms/op
    Iteration   6: 1431.349 ms/op
    Iteration   7: 1356.392 ms/op
    Iteration   8: 1439.568 ms/op
    Iteration   9: 1327.093 ms/op
    Iteration  10: 1729.274 ms/op
    
    
    Result "com.bromles.Main.streamOnSimpleArrayOnClassWithReduce":
      1411.742 ±(99.9%) 82.362 ms/op [Average]
      (min, avg, max) = (1322.113, 1411.742, 1729.274), stdev = 94.848
      CI (99.9%): [1329.380, 1494.104] (assumes normal distribution)
    
    
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=33773:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 1 s each
    # Measurement: 10 iterations, 2 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.streamOnSimpleArrayOnPrimitiveWithFilter
    # Parameters: (arraySize = 100000000)
    
    # Run progress: 90.91% complete, ETA 00:02:14
    # Fork: 1 of 2
    # Warmup Iteration   1: 442.810 ms/op
    # Warmup Iteration   2: 436.207 ms/op
    # Warmup Iteration   3: 434.202 ms/op
    Iteration   1: 417.915 ms/op
    Iteration   2: 437.499 ms/op
    Iteration   3: 421.793 ms/op
    Iteration   4: 421.223 ms/op
    Iteration   5: 428.418 ms/op
    Iteration   6: 417.876 ms/op
    Iteration   7: 417.479 ms/op
    Iteration   8: 418.534 ms/op
    Iteration   9: 444.488 ms/op
    Iteration  10: 418.308 ms/op
    
    # Run progress: 93.18% complete, ETA 00:01:41
    # Fork: 2 of 2
    # Warmup Iteration   1: 578.938 ms/op
    # Warmup Iteration   2: 524.796 ms/op
    # Warmup Iteration   3: 554.160 ms/op
    Iteration   1: 510.965 ms/op
    Iteration   2: 446.841 ms/op
    Iteration   3: 425.360 ms/op
    Iteration   4: 438.213 ms/op
    Iteration   5: 424.185 ms/op
    Iteration   6: 428.605 ms/op
    Iteration   7: 417.018 ms/op
    Iteration   8: 420.455 ms/op
    Iteration   9: 421.138 ms/op
    Iteration  10: 417.659 ms/op
    
    
    Result "com.bromles.Main.streamOnSimpleArrayOnPrimitiveWithFilter":
      429.699 ±(99.9%) 18.457 ms/op [Average]
      (min, avg, max) = (417.018, 429.699, 510.965), stdev = 21.255
      CI (99.9%): [411.242, 448.155] (assumes normal distribution)
    
    
    # JMH version: 1.21
    # VM version: JDK 11.0.8, OpenJDK 64-Bit Server VM, 11.0.8+10-post-Debian-1deb10u1
    # VM invoker: /usr/lib/jvm/java-11-openjdk-amd64/bin/java
    # VM options: -javaagent:/home/bromles/Dev/JetBrains/Idea/lib/idea_rt.jar=33773:/home/bromles/Dev/JetBrains/Idea/bin -Dfile.encoding=UTF-8
    # Warmup: 3 iterations, 1 s each
    # Measurement: 10 iterations, 2 s each
    # Timeout: 10 min per iteration
    # Threads: 1 thread, will synchronize iterations
    # Benchmark mode: Average time, time/op
    # Benchmark: com.bromles.Main.streamOnSimpleArrayOnPrimitiveWithReduce
    # Parameters: (arraySize = 100000000)
    
    # Run progress: 95.45% complete, ETA 00:01:07
    # Fork: 1 of 2
    # Warmup Iteration   1: 91.111 ms/op
    # Warmup Iteration   2: 86.903 ms/op
    # Warmup Iteration   3: 85.796 ms/op
    Iteration   1: 89.176 ms/op
    Iteration   2: 86.269 ms/op
    Iteration   3: 90.066 ms/op
    Iteration   4: 88.665 ms/op
    Iteration   5: 85.836 ms/op
    Iteration   6: 86.633 ms/op
    Iteration   7: 85.618 ms/op
    Iteration   8: 87.158 ms/op
    Iteration   9: 86.149 ms/op
    Iteration  10: 89.597 ms/op
    
    # Run progress: 97.73% complete, ETA 00:00:33
    # Fork: 2 of 2
    # Warmup Iteration   1: 91.522 ms/op
    # Warmup Iteration   2: 86.557 ms/op
    # Warmup Iteration   3: 85.668 ms/op
    Iteration   1: 85.561 ms/op
    Iteration   2: 85.724 ms/op
    Iteration   3: 86.112 ms/op
    Iteration   4: 86.962 ms/op
    Iteration   5: 86.285 ms/op
    Iteration   6: 88.749 ms/op
    Iteration   7: 86.434 ms/op
    Iteration   8: 88.273 ms/op
    Iteration   9: 85.489 ms/op
    Iteration  10: 86.976 ms/op
    
    
    Result "com.bromles.Main.streamOnSimpleArrayOnPrimitiveWithReduce":
      87.087 ±(99.9%) 1.267 ms/op [Average]
      (min, avg, max) = (85.489, 87.087, 90.066), stdev = 1.459
      CI (99.9%): [85.819, 88.354] (assumes normal distribution)
    
    
    # Run complete. Total time: 00:24:35
    
    REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
    why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
    experiments, perform baseline and negative tests that provide experimental control, make sure
    the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
    Do not assume the numbers tell you what you want them to tell.
    
    Benchmark                                                 (arraySize)  Mode  Cnt     Score    Error  Units
    Main.forEachLoopOnArrayList                                 100000000  avgt   20   325.317 ±  9.851  ms/op
    Main.forEachLoopOnSimpleArrayOnClass                        100000000  avgt   20   250.709 ±  4.265  ms/op
    Main.forEachLoopOnSimpleArrayOnPrimitive                    100000000  avgt   20   406.020 ±  8.629  ms/op
    Main.forLoopOnArrayList                                     100000000  avgt   20   291.629 ±  8.090  ms/op
    Main.forLoopOnSimpleArrayOnClass                            100000000  avgt   20   268.845 ±  9.756  ms/op
    Main.forLoopOnSimpleArrayOnPrimitive                        100000000  avgt   20    71.541 ±  2.594  ms/op
    Main.intStreamOnSimpleArrayOnPrimitiveWithFilter            100000000  avgt   20   439.117 ± 13.151  ms/op
    Main.intStreamOnSimpleArrayOnPrimitiveWithReduce            100000000  avgt   20    87.360 ±  1.458  ms/op
    Main.parallelIntStreamOnSimpleArrayOnPrimitiveWithFilter    100000000  avgt   20   122.384 ± 28.286  ms/op
    Main.parallelIntStreamOnSimpleArrayOnPrimitiveWithReduce    100000000  avgt   20    66.512 ± 34.315  ms/op
    Main.parallelStreamOnArrayListWithFilter                    100000000  avgt   20   173.798 ± 17.986  ms/op
    Main.parallelStreamOnArrayListWithReduce                    100000000  avgt   20   478.093 ± 45.455  ms/op
    Main.parallelStreamOnSimpleArrayOnClassWithFilter           100000000  avgt   20   183.783 ± 10.396  ms/op
    Main.parallelStreamOnSimpleArrayOnClassWithReduce           100000000  avgt   20   471.038 ± 36.790  ms/op
    Main.parallelStreamOnSimpleArrayOnPrimitiveWithFilter       100000000  avgt   20   102.852 ±  1.252  ms/op
    Main.parallelStreamOnSimpleArrayOnPrimitiveWithReduce       100000000  avgt   20    65.237 ± 32.303  ms/op
    Main.streamOnArrayListWithFilter                            100000000  avgt   20   743.722 ± 15.542  ms/op
    Main.streamOnArrayListWithReduce                            100000000  avgt   20  1341.798 ± 78.126  ms/op
    Main.streamOnSimpleArrayOnClassWithFilter                   100000000  avgt   20   783.755 ± 19.685  ms/op
    Main.streamOnSimpleArrayOnClassWithReduce                   100000000  avgt   20  1411.742 ± 82.362  ms/op
    Main.streamOnSimpleArrayOnPrimitiveWithFilter               100000000  avgt   20   429.699 ± 18.457  ms/op
    Main.streamOnSimpleArrayOnPrimitiveWithReduce               100000000  avgt   20    87.087 ±  1.267  ms/op
    
    Process finished with exit code 0
