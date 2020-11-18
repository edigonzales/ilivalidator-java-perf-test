///usr/bin/env jbang "$0" "$@" ; exit $?
//REPOS mavenCentral,jcenter,ehi=http://jars.interlis.ch/
//DEPS ch.interlis:ilivalidator:1.11.8 org.apache.commons:commons-lang3:3.11

import static java.lang.System.*;

import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ch.ehi.basics.settings.Settings;

import org.apache.commons.lang3.time.StopWatch;
import org.interlis2.validator.Validator;

public class ilivalidator {

    public static List<Integer> datasets = Stream.of(
            //2401,2402,2403,2404,2405,2406,2407,2408,2421,2422,2423,2424,2425,2426,2427,2428,2429,2445,2455,2456,2457,2461,2463,2464,2465,2472,2473,2474,2475,2476,2477,2478,2479,2480,2481,2491,2492,2493,2495,2497,2498,2499,2500,2501,2502,2503,2511,2513,2514,2516,2517,2518,2519,2520,2523,2524,2525,2526,2527,2528,2529,2530,2532,2534,2535,2541,2542,2543,2544,2545,2546,2547,2548,2549,2550,2551,2553,2554,2555,2556,2571,2572,2573,2574,2575,2576,2578,2579,2580,2581,2582,2583,2584,2585,2586,2601,2611,2612,2613,2614,2616,2617,2618,2619,2620,2621,2622
            2401,2402,2403,2404
            ).collect(Collectors.toList());
    
    public static void main(String... args) {
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_ILIDIRS, Validator.SETTING_DEFAULT_ILIDIRS);
        settings.setValue(Validator.SETTING_ALL_OBJECTS_ACCESSIBLE, Validator.TRUE);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int dataset : datasets) {            
            String filename = String.valueOf(dataset);
            String inputFilename = Paths.get("/home/stefan/Downloads/ch.so.agi.av.dm01avch24lv95d", filename + "00.itf").toFile().getAbsolutePath();
            boolean valid = Validator.runValidation(inputFilename, settings);
        }
        
        stopWatch.stop();
        out.println(System.getProperty("java.version"));
        out.println(stopWatch.formatTime());
    }
}
