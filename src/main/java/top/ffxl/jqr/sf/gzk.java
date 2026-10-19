package top.ffxl.jqr.sf;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import top.ffxl.jqr.sj.glj;
import top.ffxl.jqr.sj.qqcs;
import top.ffxl.jqr.gj.http;

import java.util.Objects;

@Slf4j
public class gzk {
    public String gz(String content, int msg_type, int msg_seq, qqcs qqcs, JSONArray keyboard){
        JSONObject hf = new JSONObject();
        if (msg_type == 0) {
            hf.put("content", content);
        }else if(msg_type == 2){
            JSONObject markdown = new JSONObject();
            markdown.put("content",content);
            hf.put("markdown",markdown);
        }
        if (keyboard != null){
            JSONObject keyboardJson = new JSONObject();
            JSONObject xx = new JSONObject();
            xx.put("rows",keyboard);
            keyboardJson.put("content",xx);
            hf.put("keyboard",keyboardJson);
        }
        hf.put("msg_type",msg_type);
        if (Objects.equals(qqcs.t, "INTERACTION_CREATE") || Objects.equals(qqcs.t, "GROUP_MSG_RECEIVE") || Objects.equals(qqcs.t, "C2C_MSG_RECEIVE") || Objects.equals(qqcs.t, "GROUP_ADD_ROBOT") || Objects.equals(qqcs.t, "FRIEND_ADD")) {
            hf.put("event_id",qqcs.event_id);
        }else{
            hf.put("msg_id",qqcs.msg_id);
            hf.put("msg_seq",msg_seq);
        }
        return hf.toString(2);
    }


    public String gz(String content,String url,int file_type,int msg_seq,qqcs qqcs) throws Exception {
        JSONObject hf = new JSONObject();
        hf.put("content", content);
        hf.put("msg_type",7);
        if (Objects.equals(qqcs.t, "INTERACTION_CREATE") || Objects.equals(qqcs.t, "GROUP_MSG_RECEIVE") || Objects.equals(qqcs.t, "C2C_MSG_RECEIVE") || Objects.equals(qqcs.t, "GROUP_ADD_ROBOT") || Objects.equals(qqcs.t, "FRIEND_ADD")) {
            hf.put("event_id",qqcs.event_id);
        }else{
            hf.put("msg_id",qqcs.msg_id);
            hf.put("msg_seq",msg_seq);
        }
        hf.put("media",c(url,file_type,qqcs));
        return hf.toString(2);
    }

    public String z(String content,qqcs qqcs){
        JSONObject hf = new JSONObject();
        hf.put("content", content);
        hf.put("msg_id",qqcs.msg_id);
        return hf.toString(2);
    }

    public String z(String content,String url,qqcs qqcs){
        JSONObject hf = new JSONObject();
        hf.put("content", content);
        hf.put("msg_id",qqcs.msg_id);
        hf.put("image",url);
        return hf.toString(2);
    }
    public JSONObject c(String url, int file_type, qqcs qqcs) throws Exception {
        JSONObject tp = new JSONObject();
        tp.put("url",url);
        tp.put("file_type",file_type);
        tp.put("srv_send_msg",false);
        http qq = new http();
        glj glj = new glj(qqcs);
        qq.ks(top.ffxl.jqr.sj.glj.tydz +glj.tu+"/files","POST");
        qq.RZ();
        qq.qqti(tp.toString());
        String jg = qq.dqxy();
        log.debug(jg);
        return new JSONObject(jg);
    }
    public String gz(String content, int msg_type, JSONArray keyboard){
        JSONObject hf = new JSONObject();
        if (msg_type == 0) {
            hf.put("content", content);
        }else if(msg_type == 2){
            JSONObject markdown = new JSONObject();
            markdown.put("content",content);
            hf.put("markdown",markdown);
        }
        if (keyboard != null){
            JSONObject keyboardJson = new JSONObject();
            JSONObject xx = new JSONObject();
            xx.put("rows",keyboard);
            keyboardJson.put("content",xx);
            hf.put("keyboard",keyboardJson);
        }
        hf.put("msg_type",msg_type);
        return hf.toString(2);
    }
    public String gz(String content,String url,int file_type,qqcs qqcs) throws Exception {
        JSONObject hf = new JSONObject();
        hf.put("content", content);
        hf.put("msg_type",7);
        hf.put("media",c(url,file_type,qqcs));
        return hf.toString(2);
    }


    public String fl(String content,int msg_type,int msg_seq,qqcs qqcs,JSONArray keyboard){
        return switch (Objects.requireNonNull(qqcs.t)) {
            case "C2C_MESSAGE_CREATE", "GROUP_AT_MESSAGE_CREATE","GROUP_MESSAGE_CREATE" -> gz(content,msg_type,msg_seq,qqcs,keyboard);
            case "MESSAGE_CREATE", "AT_MESSAGE_CREATE", "DIRECT_MESSAGE_CREATE" -> z(content,qqcs);
            default -> null;
        };
    }


    public String fl(String content,String url,int file_type,int msg_seq,qqcs qqcs) throws Exception {
        return switch (Objects.requireNonNull(qqcs.t)) {
            case "C2C_MESSAGE_CREATE", "GROUP_AT_MESSAGE_CREATE","GROUP_MESSAGE_CREATE" -> gz(content, url, file_type, msg_seq,qqcs);
            case "MESSAGE_CREATE", "AT_MESSAGE_CREATE", "DIRECT_MESSAGE_CREATE" -> z(content, url,qqcs);
            default -> null;
        };
    }
}
