package top.ffxl.jqr.plugin;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import top.ffxl.jqr.gj.TS;
import top.ffxl.jqr.gj.json;
import top.ffxl.jqr.jqrpzxx.jcsj;
import top.ffxl.jqr.onebotv11.sjk.UserMapper;
import top.ffxl.jqr.onebotv11.wsd;
import top.ffxl.jqr.sf.api;
import top.ffxl.jqr.sj.qqcs;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component
@Order(99)
public class onebotb implements rk{
    private final UserMapper user;

    public onebotb(UserMapper user) {
        this.user = user;
    }

    @Override
    public String hy(qqcs qqcs) throws Exception {
        JSONObject qun = new JSONObject(user.getQun(qqcs.group_openid));
        api api = new api();
        String[] g = {"摸","rua","摸摸","摸摸头","扔","丢","丟","kiss","亲","亲亲","贴","贴贴","撕","我撕","爬","踢","踹","吞","顶","拍","馋","砍","追","跳","跳一个","精神支柱","拜","膜拜","滚","吃","啃","转","loading","加载中","police","出警","舔","舔屏","搓","完美","爱你","永远爱你","这像话吗","这像画吗","哈哈镜","打拳","打","捣","震惊","左对称","右对称","上对称","下对称","群青","垃圾","辣鸡","垃圾桶","垃圾就该呆在垃圾桶里","敲","为什么@我","为什么艾特我","艾特我干嘛","吸","紧贴","贴紧","紧紧贴着","锤","砸","啾啾","蹭我","蹭我腿","捂脸","墙纸","退","退退退","抛","听音乐","阿尼亚喜欢","画","画家","小画家","字符","字符画","坏人","防诱拐","怪叔叔","怪蜀黍","远离","结婚","结婚申请","采访","求经","玩游戏","来玩游戏","激动","高血压","手枪","树叶","树叶雕刻","fire","烧","击剑","恍惚","波纹","风车转","抱紧","扯","敲木鱼","木鱼","功德","踢球","挠头","拍头","怎么说话的","怎么说话呢你","嘲笑","乐","打屁股","一起笑他","一起笑她","离婚","科目三","一直","万花筒","毒瘾","一样","鼓掌","揍","累了","为了你","蜘蛛","蜘蛛爬","怒撕","催眠","app","催眠"};
        String[] S = {"草","艹","操","撅","千年杀","送马","送你一个马","看看你的","狂草","狂艹","狂操","狂撅","拉屎","屙屎","飞机杯","震","震动","遥控","干"};
        for (String s : g) {
            if (qqcs.content.startsWith(s)){
                JSONObject us = new JSONObject(user.getUserQqbot(qqcs.openid));
                if (json.tqi(us, "qqid") != 0){
                    JSONObject xx = new JSONObject(user.getxxQ(qqcs.msg_id));
                    if (qqcs.url == null){
                        String co = qqcs.content;
                        Matcher at = Pattern.compile("^"+s+"\\s*<@(.{32})\\s*>$").matcher(co);
                        kk(qqcs, qun, api, s, us, xx, co, at);
                    }else {
                        StringBuilder ms = new StringBuilder();
                        ms.append(s);
                        for (String string : qqcs.url) {
                            ms.append(" [CQ:image,file=").append(string).append("]");
                        }
                        wsd.ts(TS.group(json.tql(qun,"group_id"),json.tql(us,"qqid"),json.tql(xx,"message_id"),ms.toString(),json.tq(us,"nickname")));
                    }
                }else {
                    api.hf("q", "本功能需要用到QQ号，由于平台限制请使用\"绑定QQ\"手动绑定QQ号", 2, qqcs, null);
                }
                return "t";
            }
        }
        if (json.tqb(qun,"tq")) {
            for (String s : S) {
                if (qqcs.content.startsWith(s)){
                    JSONObject us = new JSONObject(user.getUserQqbot(qqcs.openid));
                    if (json.tqi(us, "qqid") != 0){
                        JSONObject xx = new JSONObject(user.getxxQ(qqcs.msg_id));
                        if (qqcs.url == null){
                            String co = qqcs.content;
                            Matcher at = Pattern.compile("^"+s+"\\s*<@(.{32})>\\s*$").matcher(co);
                            kk(qqcs, qun, api, s, us, xx, co, at);
                        }else {
                            StringBuilder ms = new StringBuilder();
                            ms.append(s);
                            for (String string : qqcs.url) {
                                ms.append(" [CQ:image,file=").append(string).append("]");
                            }
                            wsd.ts(TS.group(json.tql(qun,"group_id"),json.tql(us,"qqid"),json.tql(xx,"message_id"),ms.toString(),json.tq(us,"nickname")));
                        }
                    }else {
                        api.hf("q", "本功能需要用到QQ号，由于平台限制请手动绑定QQ号", 2, qqcs, null);
                    }
                    return "t";
                }
            }
        }
        return "d";
    }

    private void kk(qqcs qqcs, JSONObject qun, api api, String s, JSONObject us, JSONObject xx, String co, Matcher at) throws Exception {
        Matcher id = Pattern.compile("^"+s+"\\s*(\\d+)\\s*$").matcher(co);
        if (at.matches()){
            String openid = at.group(1);
            JSONObject US = new JSONObject(user.getUserQqbot(openid));
            if (!json.tqb(US, "tx") || json.tqb(us,"tx") || s.equals("树叶")){
                wsd.ts(TS.group(json.tql(qun,"group_id"),json.tql(us,"qqid"),json.tql(xx,"message_id"),s + " [CQ:image,file=https://xiaodi.ykxbl.top/Api/qqtx.php?appid="+ jcsj.AppID +"&openid=" + openid + "]",json.tq(us,"nickname")));
            }else {
                api.hf("q", "滚!", 2, qqcs, null);
                wsd.ts(TS.group(json.tql(qun,"group_id"),4012206610L,json.tql(xx,"message_id"),"丢"+json.tql(us,"qqid"),json.tq(us,"nickname")));
            }
        }
        if (id.matches()){
            String openid = id.group(1);
            if (!Objects.equals(openid, "422529150") || json.tqb(us,"tx") || s.equals("树叶")){
                wsd.ts(TS.group(json.tql(qun,"group_id"),json.tql(us,"qqid"),json.tql(xx,"message_id"),s + openid,json.tq(us,"nickname")));
            }else {
                api.hf("q", "滚!", 2, qqcs, null);
                wsd.ts(TS.group(json.tql(qun,"group_id"),4012206610L,json.tql(xx,"message_id"),"丢"+json.tql(us,"qqid"),json.tq(us,"nickname")));
            }
        }
    }
}
