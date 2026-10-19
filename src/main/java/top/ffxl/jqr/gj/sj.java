package top.ffxl.jqr.gj;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class sj {
    public static long sjc(){
        return Instant.now().getEpochSecond();
    }
    public static long sjZh(String sj, String gs) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(gs);
        LocalDateTime ldt = LocalDateTime.parse(sj, formatter);
        return ldt.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }
}
