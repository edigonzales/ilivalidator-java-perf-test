///usr/bin/env jbang "$0" "$@" ; exit $?
// //DEPS <dependency1> <dependency2>

import static java.lang.System.*;

public class helloworld {

 //   public static List<String> OEREB_SERVICE_BASE_URL = Stream.of(
//            "https://oereb.geo.sh.ch/oereb/", 
//            "https://maps.zh.ch/oereb/",
//            "https://map.geo.gl.ch/oereb/wsgi/oereb/",
//            "https://map.geo.sz.ch/oereb/wsgi/oereb/",
//            "https://api.geo.ag.ch/v1/oereb/",
//            "https://geo.so.ch/api/oereb/")
//            .collect(Collectors.toList());



    public static void main(String... args) {
        out.println("Hello Stefan");

        out.println(System.getProperty("java.version") );
    }
}
