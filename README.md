# ilivalidator-java-perf-test

**USE: //JAVA_OPTIONS -XX:+UseParallelGC**

` -Xmx2048m*`
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
| Java 8 (adoptopenjdk) | xx  | x, x, x |
| Java 11 (adoptopenjdk + UseG1GC, default gc)  | xx  | x, x, x |
| Java 15 (adoptopenjdk + UseG1GC, default gc)  | xx  | x, x, x |
| Java 11 (adoptopenjdk + UseParallelGC)  | xx  | x, x, x |
| Java 15 (adoptopenjdk + UseParallelGC)  | xx  | x, x, x |
| Java 8 (graalvm)  | xx  | x, x, x | 
| Java 11 (graalvm + UseG1GC, default gc)  | xx  | x, x, x |
| Java 11 (graalvm + UseParallelGC)  | Content Cell  |




## todo
- same gc?
- max 2GB heap

Adopt:

hs
1.8.0_275
00:00:41.994

j9
1.8.0_275
00:00:55.989

hs
11.0.9.1
00:00:39.860

hs
14.0.2
00:00:40.238

hs
15.0.1
00:00:41.969

azul
11.0.9
00:00:39.496

graal
1.8.0_262
00:00:37.129

graal
11.0.8
00:00:38.029



ITF (AV SO):
1.8.0_275
00:19:46.774

1.8.0_275
00:19:09.843

14.0.2
00:18:17.411

14.0.2
00:18:34.049

1.8.0_262 (graal jvm)
00:17:47.010

1.8.0_262
00:17:25.796

11.0.8
00:18:48.556

11.0.8
00:18:31.776


MOpublic XTF:

11.0.8
00:16:00.151
11.0.8
00:15:38.630

1.8.0_262
00:12:14.517
1.8.0_262
00:12:31.720


14.0.2
00:16:50.334
14.0.2
00:16:30.078


1.8.0_275
00:13:53.052



