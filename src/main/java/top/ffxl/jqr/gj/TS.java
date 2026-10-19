package top.ffxl.jqr.gj;


import org.json.JSONObject;
import top.ffxl.jqr.onebotv11.sjk.UserMapper;

public class TS {
    JSONObject a;
    private TS(UserMapper userMapper) {
        a = new JSONObject();
        a.put("time",sj.sjc());
        a.put("self_id",112435483);
        a.put("post_type","message");
    }
    public static String group(long g_id,long u_id,long m_id,String message,String name){
        TS ts = new TS(null);
        ts.a.put("message_type","group");
        ts.a.put("sub_type","normal");
        ts.a.put("group_id",g_id);
        ts.a.put("user_id",u_id);
        ts.a.put("message_id",m_id);
        ts.a.put("message",message);
        ts.a.put("raw_message",message);
        ts.a.put("anonymous",(JSONObject)null);
        JSONObject sender = new JSONObject();
        sender.put("user_id",u_id);
        sender.put("nickname",name);
        ts.a.put("sender",sender);
        return ts.a.toString();
    }
    public static String privateU(long u_id, long m_id,String message,String name){
        TS ts = new TS(null);
        ts.a.put("message_type","private");
        ts.a.put("sub_type","friend");
        ts.a.put("user_id",u_id);
        ts.a.put("message_id",m_id);
        ts.a.put("message",message);
        ts.a.put("raw_message",message);
        JSONObject sender = new JSONObject();
        sender.put("user_id",u_id);
        sender.put("nickname",name);
        ts.a.put("sender",sender);
        return ts.a.toString();
    }
}

