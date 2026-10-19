package top.ffxl.jqr.onebotv11.sj;

import org.json.JSONObject;
import top.ffxl.jqr.gj.sj;

public class ysj {

    public static String smzq(){
        JSONObject cs = new JSONObject();
        cs.put("meta_event_type", "lifecycle");
        cs.put("post_type", "meta_event");
        cs.put("self_id", 112435483); // 替换为你的机器人QQ
        cs.put("sub_type", "connect");
        cs.put("time", sj.sjc());
        return cs.toString();
    }

    public static String xt(){
        JSONObject cs = new JSONObject();
        cs.put("time", sj.sjc());
        cs.put("self_id", 112435483);
        cs.put("post_type", "meta_event");
        cs.put("meta_event_type", "heartbeat");
        JSONObject status = new JSONObject();
        status.put("online",true);
        status.put("good",true);
        cs.put("status", status);
        cs.put("interval",5000);
        return cs.toString();
    }
}
