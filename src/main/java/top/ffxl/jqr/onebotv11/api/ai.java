package top.ffxl.jqr.onebotv11.api;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import top.ffxl.jqr.gj.*;
import top.ffxl.jqr.onebotv11.sjk.UserMapper;
import top.ffxl.jqr.sf.api;
import top.ffxl.jqr.sj.qqcs;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ai {
    api api = new api();
    private final UserMapper user;

    public ai(UserMapper user) {
        this.user = user;
    }

    public String dy(String a) throws Exception {
        JSONObject c = new JSONObject();
        c.put("retcode", 0);
        c.put("status", "ok");
//        c.put("echo","pyh");
        switch (Objects.requireNonNull(json.tq(a, "action"))) {
            case "send_group_msg": {
                ExecutorService executorService = Executors.newCachedThreadPool();
                JSONObject GroupMsg = json.tqo(a, "params");
                assert GroupMsg != null;
                JSONObject msg = new JSONObject();
                JSONObject d = new JSONObject();
                msg.put("t", "GROUP_MESSAGE_CREATE");
                d.put("group_openid", user.getQungroup(json.tql(GroupMsg, "group_id")));
                String ms = json.tq(GroupMsg, "message");
                JSONArray msgY = new JSONArray(user.getxxList(json.tql(GroupMsg, "group_id"), sj.sjc()));
                Pattern pattern = Pattern.compile("\\[CQ:([^,]+),([^]]+)]");
                assert ms != null;
                Matcher matcher = pattern.matcher(ms);
                StringBuilder result = new StringBuilder();
                String jsonData = json.tq(json.tqo(ms, "data"), "file");
                String x;
                String n;
                long qqh = 0;
                String WJ = null;
                String FLX;
                if (jsonData != null) {
                    n = uuid.sc() + ".wav";
                    oss.putBytes(n, "audio/wav", silk.hq(jsonData));
                } else {
                    n = null;
                }
                while (matcher.find()) {
                    String type = matcher.group(1);      // "image" 或 "at"
                    String params = matcher.group(2);    // "file={\"file\":\"...\"}" 或 "qq=33"
                    String replacement;
                    if ("image".equals(type)) {
                        // 提取链接
                        String link = params.replaceAll(".*\"file\":\"(.*?)\".*", "$1");
                        executorService.submit(() -> {
                            try {
                                Thread.sleep(60000);
                                oss.del(link.substring(24));
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        });
                        img u = img.build(link);
                        FLX = u.getFormat();
                        if (!Objects.equals(FLX, "gif")) {
                            replacement = "![text #" + u.getWidth() + "px #" + u.getHeight() + "px](" + link + ")";// 示例
                        } else {
                            WJ = link;
                            replacement = "";
                        }
                    } else if ("at".equals(type)) {
                        qqh = Long.parseLong(params.replaceAll("qq=(.+)", "$1"));
                        replacement = "<qqbot-at-user id=\"" + user.getUser(qqh).get("user_id_qqbot") + "\" />";
                    } else {
                        // 其他类型保留原样或忽略
                        replacement = matcher.group(0);
                    }
                    matcher.appendReplacement(result, replacement);
                }
                matcher.appendTail(result);
                if (ms.contains("签到成功")){
                    if(!json.tqb(new JSONObject(user.getQunId(json.tql(GroupMsg, "group_id"))),"tq")){
                        result.append("\n身高次数+1");
                        if (qqh != 0) {
                            user.updateUserSgcs(qqh);
                        }
                    }
                    result.append("\n***\n[暂时先这样，这个篮字以后会有用](mqqapi:\\/\\/aio\\/inlinecmd?command=我是香香软软的小南梁&enter=true)");
                }
                String finalText = result.toString();
                if (!msgY.isEmpty()) {
                    msg.put("op", 0);
                    d.put("id", msgY.getJSONObject(msgY.length() - 1).getString("message_id_qqbot"));
                    msg.put("d", d);
                    qqcs qq = new qqcs(msg.toString());
                    if (n == null && WJ == null) {
                        x = api.hf("q", finalText, 2, qq, null);
                    } else if (WJ != null) {
                        x = api.hf("q", finalText, WJ, 1, qq);
                    } else {
                        x = api.hf("q", "", "https://s3.ffxl.top/ces/" + n, 3, qq);
                        executorService.submit(() -> {
                            try {
                                Thread.sleep(60000);
                                oss.del(n);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    }
                } else {
                    msg.put("d", d);
                    qqcs qq = new qqcs(msg.toString());
                    if (n == null && WJ == null) {
                        x = api.hfZd("q", finalText, 2, qq, null);
                    } else if (WJ != null) {
                        x = api.hfzd("q", finalText, WJ, 1, qq);
                    } else {
                        x = api.hfzd("q", "", "https://s3.ffxl.top/ces/" + n, 3, qq);
                        executorService.submit(() -> {
                            try {
                                Thread.sleep(60000);
                                oss.del(n);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    }
                }
                user.setxxb(sj.sjc(), json.tql(GroupMsg, "group_id"), finalText, json.tq(x, "id"));
                JSONObject message = new JSONObject();
                message.put("message_id", json.tql(user.getxxQ(json.tq(x, "id")), "message_id"));
                c.put("data", message);
                return c.toString();
            }
            case "send_private_msg": {
                ExecutorService executorService = Executors.newCachedThreadPool();
                JSONObject GroupMsg = json.tqo(a, "params");
                assert GroupMsg != null;
                JSONObject msg = new JSONObject();
                JSONObject d = new JSONObject();
                JSONObject author = new JSONObject();
                author.put("user_openid", user.getUserid(json.tql(GroupMsg, "user_id")));
                msg.put("t", "C2C_MESSAGE_CREATE");
                d.put("author", author);
                String ms = json.tq(GroupMsg, "message");
                JSONArray msgY = new JSONArray(user.getxxuList(json.tql(GroupMsg, "user_id"), sj.sjc()));
                Pattern pattern = Pattern.compile("\\[CQ:([^,]+),([^]]+)]");
                assert ms != null;
                Matcher matcher = pattern.matcher(ms);
                StringBuilder resultu = new StringBuilder();
                String jsonData = json.tq(json.tqo(ms, "data"), "file");
                String x;
                String n;
                String WJ = null;
                String FLX;
                if (jsonData != null) {
                    n = uuid.sc() + ".wav";
                    oss.putBytes(n, "audio/wav", silk.hq(jsonData));
                } else {
                    n = null;
                }
                while (matcher.find()) {
                    String type = matcher.group(1);      // "image" 或 "at"
                    String params = matcher.group(2);    // "file={\"file\":\"...\"}" 或 "qq=33"
                    String replacement;
                    if ("image".equals(type)) {
                        // 提取链接
                        String link = params.replaceAll(".*\"file\":\"(.*?)\".*", "$1");
                        executorService.submit(() -> {
                            try {
                                Thread.sleep(60000);
                                oss.del(link.substring(23));
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        });
                        img u = img.build(link);
                        FLX = u.getFormat();
                        if (!Objects.equals(FLX, "gif")) {
                            replacement = "![text #" + u.getWidth() + "px #" + u.getHeight() + "px](" + link + ")";// 示例
                        } else {
                            WJ = link;
                            replacement = "";
                        }
                    } else if ("at".equals(type)) {
                        long qq = Long.parseLong(params.replaceAll("qq=(.+)", "$1"));
                        replacement = "<qqbot-at-user id=\"" + user.getUser(qq).get("user_id_qqbot") + "\" />";
                    } else {
                        // 其他类型保留原样或忽略
                        replacement = matcher.group(0);
                    }
                    matcher.appendReplacement(resultu, replacement);
                }
                matcher.appendTail(resultu);
                String finalText = resultu.toString();
                if (!msgY.isEmpty()) {
                    msg.put("op", 0);
                    d.put("id", msgY.getJSONObject(msgY.length() - 1).getString("message_id_qqbot"));
                    msg.put("d", d);
                    qqcs qq = new qqcs(msg.toString());
                    if (n == null && WJ == null) {
                        x = api.hf("q", finalText, 2, qq, null);
                    } else if (WJ != null) {
                        x = api.hf("q", finalText, WJ, 1, qq);
                    } else {
                        x = api.hf("q", "", "https://s3.ffxl.top/ces/" + n, 3, qq);
                        executorService.submit(() -> {
                            try {
                                Thread.sleep(60000);
                                oss.del(n);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    }
                } else {
                    msg.put("d", d);
                    qqcs qq = new qqcs(msg.toString());
                    if (n == null && WJ == null) {
                        x = api.hfZd("q", finalText, 2, qq, null);
                    } else if (WJ != null) {
                        x = api.hfzd("q", finalText, WJ, 1, qq);
                    } else {
                        x = api.hfzd("q", "", "https://s3.ffxl.top/ces/" + n, 3, qq);
                        executorService.submit(() -> {
                            try {
                                Thread.sleep(60000);
                                oss.del(n);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    }
                }
                user.setxxub(sj.sjc(), finalText, json.tq(x, "id"));
                JSONObject messageu = new JSONObject();
                messageu.put("message_id", json.tql(user.getxxQ(json.tq(x, "id")), "message_id"));
                c.put("data", messageu);
                return c.toString();
            }
            case "get_msg": {
                JSONObject getmsg = new JSONObject(user.getXx(json.tql(Objects.requireNonNull(json.tqo(a, "params")), "message_id")));
                c.put("data", getmsg);
                return c.toString();
            }
            case "get_login_info": {
                JSONObject login = new JSONObject();
                login.put("user_id", 112435483);
                login.put("nickname", "雪灵");
                c.put("data", login);
                return c.toString();
            }
            case "get_status": {
                JSONObject status = new JSONObject();
                status.put("online", true);
                status.put("good", true);
                c.put("data", status);
                return c.toString();
            }
            case "get_stranger_info": {
                Map<String, Object> E = user.getUser(json.tql(Objects.requireNonNull(json.tqo(a, "params")), "user_id"));
                JSONObject stranger;
                try {
                    stranger = new JSONObject(E);
                    if (E != null) {
                        stranger.put("sex", "unknown");
                        stranger.put("age", 20);
                    }
                } catch (Exception e) {
                    stranger = new JSONObject();
                }
                c.put("data", stranger);
                return c.toString();
            }
            case "get_group_list": {
                JSONArray groups = new JSONArray(user.getGroupList());
                c.put("data", groups);
                return c.toString();
            }
            case "get_friend_list": {
                JSONArray friend = new JSONArray(user.getUserList());
                c.put("data", friend);
                return c.toString();
            }
            case "get_group_info": {
                c.put("data", new JSONObject(user.getQunId(json.tql(Objects.requireNonNull(json.tqo(a, "params")), "group_id"))));
                return c.toString();
            }
            case "can_send_image": {
                JSONObject image = new JSONObject();
                image.put("yes", true);
                c.put("data", image);
                return c.toString();
            }
            case "get_group_member_info": {
                c.put("data", new JSONObject(user.getGroupMemberInfo(json.tql(Objects.requireNonNull(json.tqo(a, "params")), "group_id"), json.tql(Objects.requireNonNull(json.tqo(a, "params")), "user_id"))));
                return c.toString();
            }
            case "get_group_member_list": {
                c.put("data", new JSONArray(user.getGroupMemberList(json.tql(Objects.requireNonNull(json.tqo(a, "params")), "group_id"))));
                return c.toString();
            }
            case "upload_image": {
                JSONObject img1 = new JSONObject();
                JSONObject img2 = json.tqo(a, "params");
                String url = json.tq(img2, "file");
                String URL = null;
                if (url != null) {
                    URL = url.replace("8080", "8081").replace("\\main\\data\\file\\", "");
                }
                img ima = img.build(URL);
                String gs = ima.getFormat();
                if (gs.equals("JPEG")){
                    gs = "jpg";
                }
                String name = uuid.sc() + "." + gs;
                oss.seturl(name, "image/" + gs, URL);
                img1.put("file", "https://s3.ffxl.top/ces/" + name);
                c.put("data", img1);
                return c.toString();
            }
        }
        return c.toString();
    }
}
