package top.ffxl.jqr.sj;

import org.json.JSONArray;
import top.ffxl.jqr.gj.json;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class qqcs {
    public int op;
    public String event_id;
    public JSONObject d;
    public JSONArray attachments = null;
    public String[] url = null;
    public String msg_id;
    public String content = "";
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public String timestamp = formatter.format(LocalDateTime.now());
    public JSONObject author;
    public String openid;
    public String username;
    public String member_role;
    public String group_openid;
    public String guild_id;
    public String channel_id;
    public String t;
    public String x(String c){
        try {
            if (c.startsWith("<@5C008C56D7F104F375AEF7892D4D08C2>")) {
                String b = c.trim().substring(35);
                if (b.trim().startsWith("/")) {
                    return b.trim().substring(1);
                } else {
                    return b.trim();
                }
            }else {
                if (c.trim().startsWith("/")) {
                    return c.trim().substring(1);
                } else {
                    return c.trim();
                }
            }
        } catch (Exception e) {
            return null;
        }
    }
    public qqcs(String body){
        this.op = json.tqi(body,"op");
        this.event_id = json.tq(body,"id");
        this.d = json.tqo(body,"d");
        if (d != null) {
            this.attachments = json.tqa(d.toString(),"attachments");
        }
        if (attachments != null) {
            this.url = new String[attachments.length()];
            for (int i = 0; i < attachments.length(); i++) {
                this.url[i] = json.tq(attachments.getJSONObject(i),"url");
            }
        }
        this.msg_id = json.tq(d,"id");
        this.content = x(json.tq(d,"content"));
        this.author = json.tqo(d,"author");
        this.openid = switch (Objects.requireNonNull(json.tq(body, "t"))){
            case "GROUP_AT_MESSAGE_CREATE","GROUP_MESSAGE_CREATE" -> json.tq(author,"member_openid");
            case "C2C_MESSAGE_CREATE" -> json.tq(author,"user_openid");
            case "MESSAGE_CREATE", "AT_MESSAGE_CREATE", "DIRECT_MESSAGE_CREATE" -> json.tq(author,"union_openid");
            default -> "";
        };
        this.username = json.tq(author,"username");
        this.member_role = json.tq(author,"member_role");
        this.group_openid = json.tq(d,"group_openid");
        this.guild_id = json.tq(d,"guild_id");
        this.channel_id = json.tq(d,"channel_id");
        this.t = json.tq(body,"t");
    }
}
