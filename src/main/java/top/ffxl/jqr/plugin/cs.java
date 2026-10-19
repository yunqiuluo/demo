package top.ffxl.jqr.plugin;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import top.ffxl.jqr.gj.*;
import top.ffxl.jqr.onebotv11.sjk.UserMapper;
import top.ffxl.jqr.sf.api;
import top.ffxl.jqr.sj.qqcs;
import top.ffxl.jqr.sjk.Sg;

import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component
@Order(5)
public class cs implements rk {
    private final Sg sg;
    private final UserMapper user;

    public cs(Sg sg, UserMapper user) {
        this.sg = sg;
        this.user = user;
    }

    @Override
    public String hy(qqcs qq) throws Exception {
        sg.del(sj.sjc());
        if(Objects.equals(qq.t, "RESUMED"))return "t";
        if (Objects.equals( qq.t, "GROUP_MESSAGE_CREATE") || Objects.equals( qq.t, "GROUP_AT_MESSAGE_CREATE") || Objects.equals(qq.t, "C2C_MESSAGE_CREATE") || Objects.equals(qq.t, "MESSAGE_CREATE") || Objects.equals(qq.t, "AT_MESSAGE_CREATE") || Objects.equals(qq.t, "DIRECT_MESSAGE_CREATE")) {
            String lx = switch (qq.t) {
                case "GROUP_AT_MESSAGE_CREATE","GROUP_MESSAGE_CREATE" -> "群聊";
                case "C2C_MESSAGE_CREATE" -> "私聊";
                case "MESSAGE_CREATE", "AT_MESSAGE_CREATE" -> "频道";
                case "DIRECT_MESSAGE_CREATE" -> "频道私信";
                default -> "";
            };
            api api = new api();
            log.info("收到了{}消息:{}", lx, qq.content);
            http s = new http();
            s.ks("https://ovoav.com/api/cygj/tj?key=NakyldcmvfgTe&typs=users", "GET");
            if (qq.content.length() > 4) {
                String trim = qq.content.trim().substring(4).trim();
                if (qq.content.startsWith("身高查询")) {
                    Map<String, Object> u = sg.usersj(trim, qq.openid);
                    if (u != null || Pattern.matches("^\\w{4}-\\w{4}-\\w{4}$", trim) || Pattern.matches("^\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}$", trim)) {
                        if ((json.tqb(new JSONObject(user.getQun(qq.group_openid)),"tq") || json.tqi(new JSONObject(user.getUserQqbot(qq.openid)),"sgcs") > 0) ) {
                            if (u != null) {
                                sg(qq, u.get("uid").toString(), api);
                            } else {
                                sg(qq, trim, api);
                            }
                        } else {
                            api.hf("q", "请求次数已耗尽",0, qq,null);
                        }
                    } else {
                        api.hf("q", "你输入的不是被记录的昵称、长id，也不是好友码",0, qq,null);
                    }
                    qq.content = "";
                    return "A";
                }
                if(qq.content.startsWith("绑定QQ") || qq.content.startsWith("绑定qq")){
                    user.updateUserQqid(trim,qq.openid);
                    api.hf("q", "绑定成功",2, qq,null);
                }
                if (qq.content.startsWith("礼包查询")) {
                    Map<String, Object> u = sg.usersj(trim, qq.openid);
                    if (u != null || Pattern.matches("^\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}$", trim)) {
                        if (u != null) {
                            lb(qq, api, u.get("uid").toString());
                        } else {
                            lb(qq, api, trim);
                            if (sg.get(trim, qq.openid) == null) {
                                sg.set(trim, qq.openid, sj.sjc());
                                api.hf("q", "检测到数据库中没有你的数据，你可以在三十分钟内为本账号设置昵称\n指令：" + new JSONObject(sg.get(trim, qq.openid)).getInt("id") + "(id).{昵称}\n例：" + new JSONObject(sg.get(trim, qq.openid)).getInt("id") + ".大号\n如不绑定请删除好友",0, qq,null);
                            }
                        }
                    } else if (Pattern.matches("^\\w{4}-\\w{4}-\\w{4}$", trim)) {
                        api.hf("Q", "礼包查询暂不支持好友码查询，请使用长id",0, qq,null);
                    } else {
                        api.hf("q", "你输入的不是好友码，也不是长id",0, qq,null);
                    }
                    qq.content = "";
                    return "A";
                }
                if (qq.content.startsWith("解除绑定")) {
                    if (sg.usersj(trim, qq.openid) != null) {
                        sg.deluser(qq.openid, trim);
                        api.hf("q", "解绑成功",0, qq,null);
                    } else {
                        api.hf("q", "你绑定的账户中不存在这个昵称",0, qq,null);
                    }
                    qq.content = "";
                    return "A";
                }
                if (qq.content.startsWith("设置默认")) {
                    if (sg.usersj(trim, qq.openid) != null) {
                        sg.update0Mr(qq.openid);
                        sg.update1Mr(trim, qq.openid);
                        api.hf("q", "设置成功",0, qq,null);
                    } else {
                        api.hf("q", "你绑定的账户中不存在这个昵称", 0,qq,null);
                    }
                    qq.content = "";
                    return "A";
                }
            }
                Matcher y = Pattern.compile("^(\\d+)\\.(.+)$").matcher(qq.content);
                if (y.matches()) {
                    if (sg.geti(y.group(1), qq.openid) != null) {
                        if (sg.usersj(y.group(2), qq.openid) == null) {
                            sg.update(y.group(1), y.group(2).trim(),qq.openid);
                            api.hf("q", "设置成功\n后续可用设置的指令修改昵称，如果不记得id可以发\"我的账户\"查询",0, qq,null);
                        } else {
                            api.hf("q", "你绑定的账户中已存在这个昵称",0, qq,null);
                        }
                    }
                    qq.content = "";
                    return "A";
            }
            try {
                switch (qq.content) {

                    case "身高查询":
                        if (sg.getMr(qq.openid) == null) {
                            api.hf("p", "请在后面接上你的{好友码}或者设置默认查询账户\n好友码示例：身高查询xxxx-xxxx-xxxx", 0,qq,null);
                        } else {
                            sg(qq, sg.getMr(qq.openid).get("uid").toString(), api);
                        }
                        qq.content = "";
                        return "A";
                    case "测试1":
                        an.buttons_add("1","点击前","点击后",1,1,2,null,"回调测试",0);
                        an.buttons_add("2","第一行","第二列",1,1,2,null,"回调测试",0);
                        an.rows_add();
                        an.buttons_add("3","第二行","第一列",1,1,0, new String[]{qq.openid},"回调测试",0);
                        an.rows_add();
                        api.hf("p","<qqbot-at-user id=\"8C91A771D0FE28DFB34ECFE7D7611A42\" />",2,qq,an.fh());
                        qq.content = "";
                        return "A";
                    case "a":
                        zf.fs();
                        qq.content = "";
                        return "A";
                    case "菜单":
                        api.hf("p", "菜单\n━━━━━━━━━━━━━━━\n今日任务\n今日大蜡\n今日季蜡\n天气预报\n活动货币\n礼包查询\n礼包查询{昵称/长id}\n身高菜单\n娱乐菜单",0, qq,null);
                        qq.content = "";
                        return "A";
                    case "身高菜单":
                        api.hf("q", "身高菜单\n━━━━━━━━━━━━━━━\n我的账户\n解除绑定{昵称}\n设置默认{昵称}\n身高查询{昵称}\n身高查询{好友码}\n身高查询", 0,qq,null);
                        qq.content = "";
                        return "A";
                    case "今日任务":
                        api.hf("p", " ", "https://ovoav.com/api/sky/rwtp/rwt?key=NakyldcmvfgTe", 1, qq);
                        qq.content = "";
                        return "A";
                    case "今日大蜡":
                        api.hf("p", " ", "https://ovoav.com/api/sky/dlzwz/dl?key=NakyldcmvfgTe", 1, qq);
                        qq.content = "";
                        return "A";
                    case "今日季蜡":
                        api.hf("p", " ", "https://ovoav.com/api/sky/jlwz/jl?key=NakyldcmvfgTe", 1, qq);
                        qq.content = "";
                        return "A";
                    case "天气预报":
                        api.hf("p", " ", "https://ovoav.com/api/sky/hstp/hs?key=NakyldcmvfgTe", 1, qq);
                        qq.content = "";
                        return "A";
                    case "活动货币":
                        api.hf("p", " ", "https://ovoav.com/api/sky/hbtp/hb?key=NakyldcmvfgTe", 1, qq);
                        qq.content = "";
                        return "A";
                    case "礼包查询":
                        if (sg.getMr(qq.openid) == null) {
                            api.hf("p", "请在后面接上你的{长id}或者设置默认查询账户\n例：礼包查询xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx",0,qq,null);
                        } else {
                            lb(qq, api, sg.getMr(qq.openid).get("uid").toString());
                        }
                        qq.content = "";
                        return "A";
                    case "我的账户":{
                        JSONArray x = new JSONArray(sg.arr(qq.openid));
                        if (!x.isEmpty()) {
                            StringBuilder zz = new StringBuilder();
                            for (int i = 0; i < x.length(); i++) {
                                zz.append("\n").append(json.tqi(x, i, "id")).append("、").append(json.tq(x, i, "name"));
                                if (json.tqb(x, i, "mr")) {
                                    zz.append("(默认)");
                                }
                            }
                            api.hf("q", "你绑定的账户如下" + zz, 0,qq,null);
                        } else {
                            api.hf("q", "你还没有绑定任何账户哦！\n请先用好友码查询吧！",0,qq,null);
                        }
                        qq.content = "";
                        return "A";
                        }
                }
            } catch (Exception e) {
                log.error(e.getMessage(),e);
                api.hf("p", "接口异常",0,qq,null);
                qq.content = "";
                return "A";
            }
        }
        return "A";
    }

    public void sg(qqcs qq, String id, api api) throws Exception {
        Object a = "∞";
        http h = new http();
        h.ks(String.format("https://ovoav.com/api/sky/sgtp/gf/mt?key=NakyldcmvfgTe&id=%s&pick=-1", id), "GET");
        String FF = h.dqxy();
        if (json.tqi(FF, "code") == 200) {
            if (sg.get(json.tq(FF, "uuid"), qq.openid) == null) {
                sg.set(json.tq(FF, "uuid"), qq.openid, sj.sjc());
//                    Thread.sleep(5000);
            }
            if (sg.getnull(json.tq(FF, "uuid"), qq.openid) == null) {
                an.buttons_add("1","设置昵称","请输入昵称",1,2,0,new String[]{qq.openid},new JSONObject(sg.get(json.tq(FF, "uuid"), qq.openid)).getInt("id") + ".",0);
                an.rows_add();
            }
            img image = img.build(json.tq(FF, "image_url"));
            String A = uuid.sc() + "." + image.getFormat();
            if (sg.getnull(json.tq(FF, "uuid"), qq.openid) != null) {
                String img;
                try {
                    img = new JSONObject(sg.getnull(json.tq(FF, "uuid"), qq.openid)).getString("img");
                } catch (JSONException e) {
                    img = null;
                }
                if (img != null) {
                    oss.del(new JSONObject(sg.getnull(json.tq(FF, "uuid"), qq.openid)).getString("img"));
                }
                sg.updateImg(A,json.tq(FF, "uuid"), qq.openid);
            }
            oss.seturl(A,"image/" + image.getFormat(),json.tq(FF, "image_url"));
            md.tp(image.getWidth(),image.getHeight(),"https://s3.ffxl.top/ces/"+ A);
            md.fgx();
            md.dlln("请不要拉黑好友！");
            md.dl("剩余可查询次数：");
            if (!json.tqb(new JSONObject(user.getQun(qq.group_openid)),"tq")) {
                a = json.tqi(new JSONObject(user.getUserQqbot(qq.openid)),"sgcs") - 1;
            }
            if (a instanceof String) {
                md.dl((String) a);
            }
//            Thread.sleep(1500);
            api.hf("p",md.fh().toString(),2,qq,an.fh());
            if (sg.getnull(json.tq(FF, "uuid"), qq.openid) == null){
                Thread.sleep(10000);
                oss.del(A);
            }
        } else if (json.tqi(FF, "code") == 210) {
            api.hf("p", "请删除之前查询的好友后再用好友码查询\n或者使用长id查询",0,qq,null);
        } else if (json.tqi(FF, "code") == 206) {
            api.hf("p", "首次查询请使用好友码查询\n后需可用长id或者昵称查询", 0,qq,null);
        }else if (json.tqi(FF, "code") == 207) {
            api.hf("q","当前检测机器账号异常，请重新创建好友码\n使用绑定功能建议保留任何一个检测好友",0,qq,null);
        } else if(json.tqi(FF, "code") == 500){
            http e = new http();
            e.ks(String.format("https://ovoav.com/api/sky/sgwz/sgv1?key=NakyldcmvfgTe&id=%s", id), "GET");
            String by = e.dqxy();
            if(!json.tqb(new JSONObject(user.getQun(qq.group_openid)),"tq")) {
                a = json.tqi(new JSONObject(user.getUserQqbot(qq.openid)),"sgcs") - 1;
            }
            api.hf("q","接口异常，已替换为备用接口\n━━━━━━━━━━━━━━━\n" + by.replaceAll("(?m)^可复制uid进行查询: \\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}\\R?","").trim() + "\n━━━━━━━━━━━━━━━\n请不要拉黑好友！\n剩余可查询次数：" + a,0,qq,null);
        } else {
            api.hf("p", FF, 0,qq,null);
        }
        try {
            if (a instanceof Integer && !json.tqb(new JSONObject(user.getQun(qq.group_openid)), "tq") && (Integer) a > 0) {
                user.updateUserSgcsDec(qq.openid);
            }
        } catch (Exception ignored) {

        }
    }

    public void lb(qqcs qq, api api, String id) throws Exception {
        http l = new http();
        l.ks("https://ovoav.com/api/sky/lbcx/gflb?key=NakyldcmvfgTe&id=" + id, "GET");
        String e = l.dqxy();
        int ss = json.tqi(e, "totalCount");
        int mm = json.tqi(e, "totalPrice");
        JSONArray U = json.tqa(e, "purchasedList");
        StringBuilder zz = new StringBuilder();
        if (U != null) {
            for (int i = 0; i < U.length(); i++) {
                zz.append("\n").append(i + 1).append("、").append(json.tq(U, i, "name")).append("-¥").append(json.tqi(U, i, "price"));
            }
            api.hf("q", "总数量：" + ss + "\n总价值：¥" + mm + "\n━━━━━━━━━━━━━━━" + zz, 0,qq,null);
        } else {
            api.hf("q", e.trim(), 0,qq,null);
        }
    }
}
