# ilivalidator-java-perf-test

**USE: //JAVA_OPTIONS -XX:+UseParallelGC -Xmx2048m**


```
sdk install jbang
```

```
jbang init ilivalidator.java
```

```
jbang ilivalidator.java
```

```
jbang edit ilivalidator.java
```

```
 jbang edit --live ilivalidator.java
```

Info: maxMemory 3620864 KB


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



