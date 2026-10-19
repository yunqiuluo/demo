package top.ffxl.jqr.plugin;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import top.ffxl.jqr.gj.TS;
import top.ffxl.jqr.gj.json;
import top.ffxl.jqr.onebotv11.sjk.UserMapper;
import top.ffxl.jqr.onebotv11.wsd;
import top.ffxl.jqr.sj.qqcs;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component
@Order(100)
public class oneBot implements rk {
    private final UserMapper user;

    public oneBot(UserMapper user) {
        this.user = user;
    }

    @Override
    public String hy(qqcs qqcs) throws Exception {
        JSONObject US = new JSONObject(user.getUserQqbot(qqcs.openid));
        JSONObject G = new JSONObject(user.getQun(qqcs.group_openid));
        JSONObject MS = new JSONObject(user.getxxQ(qqcs.msg_id));
        Matcher at = Pattern.compile("<@(.*)>").matcher(qqcs.content);
        StringBuilder ms = new StringBuilder();
        if (Objects.equals(qqcs.t, "GROUP_AT_MESSAGE_CREATE") || Objects.equals(qqcs.t, "GROUP_MESSAGE_CREATE")) {
            while (at.find()) {
                String userId = at.group(1);
                if (!Objects.equals(userId, "all")) {
                    JSONObject U = new JSONObject(user.getUserQqbot(userId));
                    long userIdLong = json.tql(U, "user_id");
                    at.appendReplacement(ms, Matcher.quoteReplacement("[CQ:at,qq=" + userIdLong + "]"));
                } else {
                    at.appendReplacement(ms, Matcher.quoteReplacement("[CQ:at,qq=all]"));
                }
            }
            at.appendTail(ms);
            if (qqcs.url != null){
                for (String s : qqcs.url) {
                    ms.append(" [CQ:image,file=").append(s).append("] ");
                }
            }
            wsd.ts(TS.group(json.tql(G,"group_id"),json.tql(US,"user_id"), json.tql(MS,"message_id"), ms.toString(), json.tq(US,"nickname")));
        }
        return "t";
    }
}
