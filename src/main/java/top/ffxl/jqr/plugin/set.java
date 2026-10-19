package top.ffxl.jqr.plugin;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import top.ffxl.jqr.gj.json;
import top.ffxl.jqr.gj.sj;
import top.ffxl.jqr.onebotv11.sjk.UserMapper;
import top.ffxl.jqr.sj.qqcs;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Component
@Order(2)
public class set implements rk {
    private final UserMapper x;

    public set(UserMapper x) {
        this.x = x;
    }

    @Override
    public String hy(qqcs qqcs) {
        if (Objects.equals( qqcs.t, "GROUP_MESSAGE_CREATE") || Objects.equals( qqcs.t, "GROUP_AT_MESSAGE_CREATE") || Objects.equals(qqcs.t, "C2C_MESSAGE_CREATE") || Objects.equals(qqcs.t, "MESSAGE_CREATE") || Objects.equals(qqcs.t, "AT_MESSAGE_CREATE") || Objects.equals(qqcs.t, "DIRECT_MESSAGE_CREATE")) {
            boolean b1 = qqcs.t.equals("GROUP_AT_MESSAGE_CREATE") || qqcs.t.equals("GROUP_MESSAGE_CREATE");
            Map<String, Object> g;
            if (b1) {
                 g = x.getQun(qqcs.group_openid);
            }else if( qqcs.t.equals("MESSAGE_CREATE") || qqcs.t.equals("AT_MESSAGE_CREATE")){
                g = x.getQun(qqcs.channel_id);
            }else {
                g = new HashMap<>();
                g.put("a","a");
            }
            Map<String, Object> u = x.getUserQqbot(qqcs.openid);
            if (u == null){
                x.setUser(qqcs.username,qqcs.openid);
                u = x.getUserQqbot(qqcs.openid);
            }
            boolean b = qqcs.t.equals("GROUP_AT_MESSAGE_CREATE") || qqcs.t.equals("GROUP_MESSAGE_CREATE") || qqcs.t.equals("MESSAGE_CREATE") || qqcs.t.equals("AT_MESSAGE_CREATE");
            if (b){
                if(g == null){
                    if (b1) {
                        x.setQun(qqcs.group_openid);
                        g = x.getQun(qqcs.group_openid);
                    }else {
                        x.setQun(qqcs.channel_id);
                        g = x.getQun(qqcs.channel_id);
                    }
                }
                if (x.getQunuser(json.tql(g,"group_id"),json.tql(u,"user_id")) == null){
                    x.setQunuser(json.tql(g,"group_id"),qqcs.username,json.tql(u,"user_id"), qqcs.member_role, sj.sjc());
                    x.updMemberCount(new JSONArray(x.getQunuserrs(json.tql(g,"group_id"))).length(),qqcs.group_openid);
                }
                if (x.getxxQ(qqcs.msg_id) == null) {
                    x.setxx(sj.sjc(),json.tql(g,"group_id"),json.tql(u,"user_id"),qqcs.content,qqcs.msg_id);
                }
                x.updLastSentTime(sj.sjc(),json.tql(g,"group_id"),json.tql(u,"user_id"));
            }else {
                if (x.getxxQ(qqcs.msg_id) == null) {
                    x.setxxu(sj.sjc(),json.tql(u,"user_id"),qqcs.content,qqcs.msg_id);
                }
            }
        }
        return "A";
    }
}
