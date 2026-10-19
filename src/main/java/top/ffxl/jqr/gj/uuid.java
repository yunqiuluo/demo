package top.ffxl.jqr.gj;

import com.fasterxml.uuid.Generators;

public class uuid {
    public static String sc() {
        return Generators.timeBasedEpochRandomGenerator().generate().toString();
    }
}
