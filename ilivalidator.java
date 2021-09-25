///usr/bin/env jbang "$0" "$@" ; exit $?
//REPOS mavenCentral,ehi=http://jars.interlis.ch/
//DEPS ch.interlis:ilivalidator:1.11.8 org.apache.commons:commons-lang3:3.11
//JAVA_OPTIONS -XX:+UseParallelGC -Xmx2048m

import static java.lang.System.*;

import ch.ehi.basics.settings.Settings;

import org.apache.commons.lang3.time.StopWatch;
import org.interlis2.validator.Validator;

public class ilivalidator {
    
    public static void main(String... args) {
        //String dataFile = "/Users/stefan/Downloads/ch.so.agi.mopublic_xtf/ch.so.agi.mopublic.xtf"; 
        String dataFile = "/Users/stefan/Downloads/av_BS_lv95/Basel.itf"; 

        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_ILIDIRS, Validator.SETTING_DEFAULT_ILIDIRS);
        settings.setValue(Validator.SETTING_ALL_OBJECTS_ACCESSIBLE, Validator.TRUE);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
                
        boolean valid = Validator.runValidation(dataFile, settings);
    
        stopWatch.stop();
        out.println(System.getProperty("java.version"));
        out.println(stopWatch.formatTime());
    }
}
