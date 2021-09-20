# ilivalidator-java-perf-test

**USE: //JAVA_OPTIONS -XX:+UseParallelGC**

## jbang

### install

```
sdk install jbang
```

### init new 'project'
```
jbang init ilivalidator.java
```

```
jbang ilivalidator.java
```

### use eclipse (or other ide)
```
jbang edit ilivalidator.java
```

```
jbang edit --live ilivalidator.java
```

## performance tests
- Max Heap is set to 2048M for all tests: `-Xmx2048`.
- Time = Arithmetic mean of 3 subsequent runs
- PopOS 20.04
- ilivalidator 1.11.8

### INTERLIS 1 (ITF)

Amtliche Vermessung Kanton BS (220MB file) from https://geodienste.ch/services/av

| Java Version  | Avg. Time (mins:secs) | Times |
| ------------- | ------------- | ------------- |
| Java 8 (adoptopenjdk) | 19:48  | 19:54, 19:40, 19:51 |
| Java 11 (adoptopenjdk + UseG1GC, default gc)  | 17:00  | 17:40, 16:29, 16:51 |
| Java 15 (adoptopenjdk + UseG1GC, default gc)  | 18:00  | 18:27, 18:32, 17:04 |
| Java 11 (adoptopenjdk + UseParallelGC)  | 17:35  | 17:12, 18:39, 16:55 |
| Java 15 (adoptopenjdk + UseParallelGC)  | 16.51  | 16:44, 16:58, 16:50 |
| Java 8 (graalvm)  | 19:32  | 19:09, 20:22, 18:35 | 
| Java 11 (graalvm + UseG1GC, default gc)  | 18:34  | 19:14, 17:37, 18:52 |
| Java 11 (graalvm + UseParallelGC)  | 18:11  | 18:23, 18:23, 17:47 |

### INTERLIS 2 (XTF)

MOpublic Kanton Solothurn (2.4 GB). No associations.

| Java Version  | Avg. Time (mins:secs) | Times |
| ------------- | ------------- | ------------- |
| Java 8 (adoptopenjdk) | 13:08  | 13:21, 13:09, 12:55 |
| Java 11 (adoptopenjdk + UseG1GC, default gc)  | 15:53  | 15:33, 15:50, 16:17 |
| Java 15 (adoptopenjdk + UseG1GC, default gc)  | 15:53  | 15:49, 16:04, 15:47 |
| Java 11 (adoptopenjdk + UseParallelGC)  | 13:17 | 13:14, 13:23, 13:15 |
| Java 15 (adoptopenjdk + UseParallelGC)  | 12:26  | 12:25, 12:09, 12:44 |
| Java 8 (graalvm)  | 11:52  | 11:58, 11:53, 11:45 | 
| Java 11 (graalvm + UseG1GC, default gc)  | 14:32  | 14:28, 14:37, 14:31 |
| Java 11 (graalvm + UseParallelGC)  | 11:54  | 11:58, 11:59, 11:46 |

## 2021-09-XX
- Apple Silicon M1
