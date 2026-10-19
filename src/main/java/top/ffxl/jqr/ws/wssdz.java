package top.ffxl.jqr.ws;

import top.ffxl.jqr.gj.http;
import top.ffxl.jqr.gj.json;
import top.ffxl.jqr.sj.glj;

public class wssdz {
    public static String hq() throws Exception {
        http a = new http();
        a.ks(glj.tydz + "/gateway","GET");
        a.RZ();
        return json.tq(a.dqxy(),"url");
    }
}
