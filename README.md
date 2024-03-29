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

## performance tests: 2021-11-02 ff
- Apple Silicon M1
- Multipass Ubuntu 20.04 VM (4 cpus, 8gb ram)
- JVM -Xmx2048m
- ilivalidator 1.11.11

### ilivalidator 

#### INTERLIS 1 (ITF)

Amtliche Vermessung Kanton SO (107 files)

| Java Version  | Avg. Time (mins:secs) | Times |
| ------------- | ------------- | ------------- |
| Java 8 (temurin) | 10:21  | 10:19, 10:20, 10:24 |
| Java 17 (temurin + UseG1GC, default)  | 10:06 | 10:15, 10:03, 10:01 |
| Java 17 (temurin + UseParallelGC)  | 9:39 | 9:39, 9:43, 9:34 |
| Java 17 (graalvm + UseG1GC, default)  | 11:25 | 11:22, 11:24, 11:28 |
| Java 17 (graalvm + UseParallelGC)  | 11:07  | 11:22, 10:46, 11:14 |

#### INTERLIS 2 (XTF)

Nutzungsplanung Kanton SO (53 files)

| Java Version  | Avg. Time (mins:secs) | Times |
| ------------- | ------------- | ------------- |
| Java 8 (temurin) | 8:02  | 8:05, 8:02, 8:00 |
| Java 17 (temurin + UseG1GC, default)  | 7:44 | 7:47, 7:47, 7:38 |
| Java 17 (temurin + UseParallelGC)  | 7:12 | 7:25, 7:08, 7:03 |
| Java 17 (graalvm + UseG1GC, default)  | 7:39 | 7:38, 7:42, 7:37 |
| Java 17 (graalvm + UseParallelGC)  | 7:08 | 7:14, 7:03, 7:07 |

MOpublic Kanton Solothurn (1 file, 2.4 GB)

| Java Version  | Avg. Time (mins:secs) | Times |
| ------------- | ------------- | ------------- |
| Java 8 (temurin) | 7:47  | 7:51, 7:45, 7:44 |
| Java 17 (temurin + UseG1GC, default)  | 7:59 | 8:02, 7:59, 7:57 |
| Java 17 (temurin + UseParallelGC)  | 7:22 | 7:22, 7:22, 7:21 |
| Java 17 (graalvm + UseG1GC, default)  | 8:03 | 8:03, 8:00, 8:07 |
| Java 17 (graalvm + UseParallelGC)  | 7:21 | 7:22, 7:23, 7:18 |

Vergleich MOpublic ohne Multipass:
| Java Version  | Avg. Time (mins:secs) | Times |
| ------------- | ------------- | ------------- |
| Java 17 (temurin + UseParallelGC)  | 9:10 | 9:14, 9:10, 9:06 |


### ili2db

#### INTERLIS 1 (ITF)

Amtliche Vermessung Kanton SO (107 files)

| Java Version  | Avg. Time (mins:secs) | Times |
| ------------- | ------------- | ------------- |
| Java 8 (temurin) | 25:45  | 25:15, 26:01, 25:59 |
| Java 17 (temurin + UseG1GC, default)  | 25:12 | 25:13, 25:12, 25:11 |
| Java 17 (temurin + UseParallelGC)  | 24:53 | 24:56, 24:46, 24:57 |
| Java 17 (graalvm + UseG1GC, default)  | 25:37 | 25:36, 25:28, 25:46 |
| Java 17 (graalvm + UseParallelGC)  | 25:00  | 25:11, 24:49, 25:00 |

Nutzungsplanung ~ 1 minute

MOpublic Kanton Solothurn (1 file, 2.4 GB)

| Java Version  | Avg. Time (mins:secs) | Times |
| ------------- | ------------- | ------------- |
| Java 8 (temurin) | 12:26  | ~~16:41~~, 12:09, 12:43 |
| Java 17 (temurin + UseG1GC, default)  | 12:36 | 12:12, 12:17, 13:19 |
| Java 17 (temurin + UseParallelGC)  | 11:48| 12:01, 11:43, 11:41 |
| Java 17 (graalvm + UseG1GC, default)  | 12:37 | 12:12, 12:14, 13:27 |
| Java 17 (graalvm + UseParallelGC)  | 11:47 | ~~18:30~~, 11:50, 11:44 |


//JAVA_OPTIONS -XX:+UseParallelGC -Xmx2048m
org.postgresql:postgresql:42.1.4.jre6 


## Multipass
```
multipass launch --name foo --cpus 4 --mem 8G --disk 25G
multipass shell foo
```

- unzip
- zip

```
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```

```
multipass mount /Users/stefan/sources/ilivalidator-java-perf-test foo:/home/ubuntu/ilivalidator-java-perf-test
```

.zshrc
```
export PATH="$PATH:/Users/stefan/apps/vscode/Visual Studio Code.app/Contents/Resources/app/bin"
```

Make Java 11 the default SDK with sdkman!

### ilivalidator
```
jbang edit --open=code ilivalidator.java
```
(Wird obsolet, wenn vscodium für m1 arm verfügbar ist.)

```
jbang ilivalidator.java &> out.log
```

### ili2db
```
sudo docker run --rm --name editdb -p 54321:5432 -e POSTGRES_PASSWORD=mysecretpassword -e POSTGRES_DB=edit -e PG_READ_PWD=dmluser -e PG_WRITE_PWD=gretl sogis/oereb-db:latest
```

```
java -jar ili2pg-4.6.0/ili2pg-4.6.0.jar --dbhost localhost --dbport 54321 --dbdatabase edit --dbusr ddluser --dbpwd ddluser --defaultSrsCode 2056 --nameByTopic --createGeomIdx --createFk --createFkIdx  --createEnumTabs --beautifyEnumDispName --createMetaInfo --createNumChecks --strokeArcs --createBasketCol --createDatasetCol --createTidCol --dbschema dm01 --models DM01AVCH24LV95D --schemaimport
```

```
java -jar ili2pg-4.6.0/ili2pg-4.6.0.jar --dbhost localhost --dbport 54321 --dbdatabase edit --dbusr ddluser --dbpwd ddluser --defaultSrsCode 2056 --nameByTopic --createGeomIdx --createFk --createFkIdx  --createEnumTabs --beautifyEnumDispName --createMetaInfo --createNumChecks --strokeArcs --createBasketCol --createDatasetCol --createTidCol --dbschema npl --models SO_Nutzungsplanung_20171118 --schemaimport
```
```
java -jar ili2pg-4.6.0/ili2pg-4.6.0.jar --dbhost localhost --dbport 54321 --dbdatabase edit --dbusr ddluser --dbpwd ddluser --defaultSrsCode 2056 --nameByTopic --createGeomIdx --createFk --createFkIdx  --createEnumTabs --beautifyEnumDispName --createMetaInfo --createNumChecks --strokeArcs --createBasketCol --createDatasetCol --createTidCol --dbschema mopublic --models SO_AGI_MOpublic_20190424 --schemaimport
```

```
java -jar ili2pg-4.6.0/ili2pg-4.6.0.jar --dbhost localhost --dbport 54321 --dbdatabase edit --dbusr ddluser --dbpwd ddluser --defaultSrsCode 2056 --nameByTopic --createGeomIdx --createFk --createFkIdx  --createEnumTabs --beautifyEnumDispName --createMetaInfo --createNumChecks --strokeArcs --createBasketCol --createDatasetCol --createTidCol --dbschema swisstlm --models swissTLM3D_ili2_LV95_V1_9 --schemaimport

```

```
jbang ili2db.java &> out_tlm.log
```

### install docker

```
sudo apt-get update
sudo apt-get install \
    ca-certificates \
    curl \
    gnupg \
    lsb-release
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg
echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu \
  $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
sudo apt-get update
sudo apt-get install docker-ce docker-ce-cli containerd.io
```

