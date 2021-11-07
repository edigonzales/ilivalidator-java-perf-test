///usr/bin/env jbang "$0" "$@" ; exit $?
//REPOS mavenCentral,ehi=http://jars.interlis.ch/
//DEPS ch.interlis:ili2pg:4.6.0 org.postgresql:postgresql:42.3.1 org.apache.commons:commons-lang3:3.11
//JAVA_OPTIONS -XX:+UseParallelGC -Xmx2048m

import static java.lang.System.*;

import java.io.File;
import java.io.FilenameFilter;

import ch.ehi.basics.settings.Settings;

import org.apache.commons.lang3.time.StopWatch;

import ch.ehi.ili2db.base.Ili2db;
import ch.ehi.ili2db.base.Ili2dbException;
import ch.ehi.ili2db.gui.Config;
import ch.ehi.ili2pg.PgMain;

public class ili2db {
    
    public static void main(String... args) throws Ili2dbException {
        //String dataFile = "/Users/stefan/Downloads/ch.so.agi.mopublic_xtf/ch.so.agi.mopublic.xtf"; 
        //String dataFile = "/Users/stefan/Downloads/av_BS_lv95/Basel.itf"; 
        File dir = new File("./data/");

        File [] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".xtf");
            }
        });
        
        for (int i=0; i<3; i++) {
           
            Config config = new Config();
            new PgMain().initConfig(config);
            config.setFunction(Config.FC_REPLACE);
            config.setImportTid(true);
            config.setDefaultSrsCode("2056");
            config.setDbhost("localhost");
            config.setDbport("54321");
            config.setDbdatabase("edit");
            config.setDbusr("ddluser");
            config.setDbpwd("ddluser");
            config.setDbschema("mopublic");
            config.setDburl("jdbc:postgresql://localhost:54321/edit");
            config.setModels("SO_AGI_MOpublic_20190424");
            config.setConfigReadFromDb(true);
            config.setBasketHandling(Config.BASKET_HANDLING_READWRITE);
            config.setTidHandling(Config.TID_HANDLING_PROPERTY);        
            config.setCreateDatasetCols(Config.CREATE_DATASET_COL);
            Config.setStrokeArcs(config, Config.STROKE_ARCS_ENABLE);
            config.setValidation(false);
            //config.setFetchSize(10000);
            //config.setBatchSize(10000);

            config.setItfTransferfile(true);

            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
    
            for (File dataFile : files) {
                System.out.println(dataFile);
                config.setDatasetName(dataFile.getName());
                config.setXtffile(dataFile.getAbsolutePath());
                Ili2db.run(config, null);
            }
    
            stopWatch.stop();
            out.println(System.getProperty("java.version"));
            out.println(stopWatch.formatTime());    
        }
    }
}
