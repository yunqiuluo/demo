package top.ffxl.jqr;

import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import top.ffxl.jqr.gj.*;
import top.ffxl.jqr.onebotv11.sjk.UserMapper;
import top.ffxl.jqr.onebotv11.wsd;
import top.ffxl.jqr.sf.api;
import top.ffxl.jqr.sj.qqcs;
import top.ffxl.jqr.sjk.Sg;
import top.ffxl.jqr.sj.glj;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Component
public class e {
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final Sg sg;
    private final UserMapper user;

    public e(Sg sg, UserMapper user) {
        this.sg = sg;
        this.user = user;
    }

    public static void maina(String[] args) {
        JSONObject a = new JSONObject((Map<String, Objects>) null);
        System.out.println(a);
    }
    public static void main(String[] args) throws Exception {
//        api api = new api();
//        JSONObject d = new JSONObject();
//        JSONObject msg = new JSONObject();
//        msg.put("t","GROUP_MESSAGE_CREATE");
//        d.put("group_openid","8036E461A566C47837CACDBDBEDFDC03");
//        msg.put("d",d);
//        qqcs qqcs = new qqcs(msg.toString());
//        JSONObject a = new JSONObject();
//        JSONObject sender = new JSONObject();
//        sender.put("user_id", 33)
//                .put("nickname", "测试");
//        a.put("time", sj.sjc())
//                .put("self_id",112435483)
//                .put("post_type","message")
//                .put("message_type","group")
//                .put("sub_type","normal")
//                .put("message_id",1)
//                .put("group_id","1000006")
//                .put("user_id",112435486)
//                .put("anonymous",(JSONObject)null)
//                .put("message","2")
//                .put("raw_message","测试")
//                .put("sender",sender)
//                .put("echo","a");
//
//        wsd.ts(a.toString());




        http a = new http();
//        a.ks("https://multimedia.nt.qq.com.cn/download?appid=1407&fileid=EhTH78rseff0g-bE8T2YpilzxlStWhioyAQg_wootbGX4euelQMyBHByb2RQgL2jAVoQGWq2DxU9xG7msa3WntBQMXoCCT6CAQJneg&rkey=CAQSMALQBjsiws8ObglWgvDIVnL0yRxhTfdRL5-rXpTu8ZhF02485z4qeFdeJfWLZSM6sg%5Cu0026spec=0","GET");
//        a.RZ();
//        System.out.println(a.dqxy());
//        InputStream in = new URL("https://s3.ffxl.top/ces/019ef262-8ee4-73b5-9add-1702990b4eab.gif").openStream();
//        ImageInputStream iis = ImageIO.createImageInputStream(in);
//        Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
//        ImageReader reader = readers.next();
//        reader.setInput(iis, true);
//        System.out.println(reader.getWidth(0));
//        System.out.println(reader.getHeight(0));
//        System.out.println(reader.getFormatName());
//        http a = new http();
//        a.ks(glj.tydz+"/v2/groups/608FDC718A4E98FBF13D747343622CD5/messages","POST");
//        a.RZ();
//        JSONObject e =  new JSONObject();
//        JSONObject ja = new JSONObject();
//////        ja.put("content","测试");
//////        md.tp(1280,720, "https://s3.ffxl.top/ces/019e9eb3-fc65-772d-b40b-3a2d3b059705.png");
//////        md.fgx();
//////        md.dlln("请不要拉黑好友！");
//////        md.dl("剩余可查询次数：");
//////
//////        md.tp(300,300,"https://www.ffxl.top/wj/img/h.gif");
////        ja.put("content","#雪灵0.7 -> 1.0\n#(结束测试)\n***\n本次更新内容如下\n- 完成onebot大部分api适配\n- [头像表情包回归，点击查我触发词](http://client.dpifox.com:44338/plugin-api/qy-api/Avatar/help.php)\n隐藏表情包仅本群可用，查看隐藏触发词请输入“112435483”\n- 增加点歌功\n- 娱乐功能回归\n  1. 签到功能\n [点我签到](mqqapi:\\/\\/aio\\/inlinecmd?command=我是香香软软的小南梁&enter=true)\n  1. 银行系统\n  1.打劫功能\n  1. 农场功能\n  1. 坐骑功能\n  1. 卡牌系统\n- 新增未知数量的未知bug\n- 修复已知bug");
//        ja.put("content"," ");
////        e.put("msg_id","ROBOT1.0_TRzlARysthwBOR7t4sVFhwoaCQe1DV2gba49LnRjDQOFJ5dQ9NscDf2VvYgDAYJNe0tzuLt7qBNy0xB0F7kll99Jd2rmOUZRIvaDqFv.z4fVAZ8hyGx8lEpG-reXU4Pt");
////        e.put("msg_seq",2);
//        md.removo();
//        an.buttons_add("1","测试按钮签到","测试按钮签到",1,0,2,null,"mqqapi://aio/inlinecmd?command=我是香香软软的小南梁&enter=true",1);
//        an.rows_add();
//        e.put("msg_type", 2)
//                .put("markdown",ja);
//        JSONObject keyboardJson = new JSONObject();
//        JSONObject xx = new JSONObject();
//        xx.put("rows",an.fh());
//        keyboardJson.put("content",xx);
//        e.put("keyboard",keyboardJson);
//        a.qqti(e.toString());
//        System.out.println(a.dqxy());
        JSONObject msg = new JSONObject();
        JSONObject d = new JSONObject();
        msg.put("t", "GROUP_MESSAGE_CREATE");
        d.put("group_openid", "253530C81F84644F10E36C335DEDF9C7");
        msg.put("d", d);
        qqcs qqcs = new qqcs(msg.toString());
        api api = new api();
        System.out.println(api.hfzd("q", "", "https://bt.ffxl.top/down/6xi4CrkzVGo4.docx", 4, qqcs));
//////        System.out.println(an.fh());
//////        oss.set("a.gif","F:\\ze-an\\Desktop\\h.gif");
////        String fileUrl = "file:///F:/ze-an/Desktop/h.gif";
////        URL url = new URL(fileUrl);
////        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
////        conn.setRequestMethod("HEAD");   // 关键：设置请求方法为 HEAD
////        conn.connect();
////
////        long contentLength = conn.getContentLengthLong();  // 读取 Content-Length 头
////        String contentType = conn.getContentType();       // Content-Type
////        long lastModified = conn.getLastModified();       // Last-Modified
////
////        conn.disconnect();
////
////        System.out.println("大小: " + contentLength);      // 如果仍为 -1，说明服务器依旧不返回
////        System.out.println("类型: " + contentType);
//
//    }
//    @PostConstruct
//    public void a(){
//        System.out.println(sg.getnull("57696a0a-6d1d-43de-a983-f5f11c472fe1", "2E38B874FB6386171443A5CCB4C6BA52"));
//        oss.set("b.gif","F:\\ze-an\\Desktop\\h.gif");
//        System.out.println("https://s3.ffxl.top/ces/b.gif");
//        JSONArray obj = new JSONArray("[\n" +
//                "  {\n" +
//                "    \"op\": 0,\n" +
//                "    \"id\": \"GROUP_AT_MESSAGE_CREATE:sqqu9ltxvajzrbqqpmpqy6f5fg1wakdf8oriy72yofzxqkgxwpynhysl6q6ws849\",\n" +
//                "    \"d\": {\n" +
//                "      \"id\": \"ROBOT1.0_SQQU9ltxvaJZrBqQPmpQy6-YW-qV1A7MI8V1Rj0Gm8VvWVSyImaHsoip3JDO74q2bRlz1-g4P-nGtOmkEuSt6n8dDvt5Z.qr2Z7q4itSjnQ!\",\n" +
//                "      \"content\": \" 你好\",\n" +
//                "      \"timestamp\": \"2025-11-23T04:11:05+08:00\",\n" +
//                "      \"author\": {\n" +
//                "        \"id\": \"9A633C87BBBA0A69ADC05AA64EFA02D7\",\n" +
//                "        \"member_openid\": \"9A633C87BBBA0A69ADC05AA64EFA02D7\",\n" +
//                "        \"union_openid\": \"9A633C87BBBA0A69ADC05AA64EFA02D7\"\n" +
//                "      },\n" +
//                "      \"group_id\": \"E0612C46FBEE74AB9DF1D3A343C4CCD4\",\n" +
//                "      \"group_openid\": \"E0612C46FBEE74AB9DF1D3A343C4CCD4\",\n" +
//                "      \"message_scene\": {\n" +
//                "        \"source\": \"default\"\n" +
//                "      },\n" +
//                "      \"message_type\": 0\n" +
//                "    },\n" +
//                "    \"t\": \"GROUP_AT_MESSAGE_CREATE\"\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"op\": 0,\n" +
//                "    \"s\": 2,\n" +
//                "    \"t\": \"GROUP_MESSAGE_CREATE\",\n" +
//                "    \"id\": \"GROUP_MESSAGE_CREATE:qhocxn12sly4ntthsa6eigo4mbmpuaqudeewb0azvuv957wseidnfe0ixfc6s\",\n" +
//                "    \"d\": {\n" +
//                "      \"author\": {\n" +
//                "        \"bot\": false,\n" +
//                "        \"id\": \"24A4F6777C45AB5EFE8D29FC1CE36695\",\n" +
//                "        \"member_openid\": \"24A4F6777C45AB5EFE8D29FC1CE36695\",\n" +
//                "        \"union_openid\": \"\",\n" +
//                "        \"username\": \"洛\"\n" +
//                "      },\n" +
//                "      \"content\": \"。\",\n" +
//                "      \"group_id\": \"8036E461A566C47837CACDBDBEDFDC03\",\n" +
//                "      \"group_openid\": \"8036E461A566C47837CACDBDBEDFDC03\",\n" +
//                "      \"id\": \"ROBOT1.0_QhoCXN12SL-y4NT.THSA6SfsPzXGsbLUPsLeUUIBqj42wplpSJYhnzeLXaLj6eg6cq0w.Mk862niD9es-ZR1WlvYqeJmxLMJp2QtdIpxCeE!\",\n" +
//                "      \"message_scene\": {\n" +
//                "        \"ext\": [\n" +
//                "          \"msg_idx=REFIDX_FEc9g4vs+7UXFUuPW7Rp0Q==\"\n" +
//                "        ],\n" +
//                "        \"source\": \"default\"\n" +
//                "      },\n" +
//                "      \"message_type\": 0,\n" +
//                "      \"timestamp\": \"2026-05-28T00:05:55+08:00\"\n" +
//                "    }\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"op\": 0,\n" +
//                "    \"id\": \"INTERACTION_CREATE:0b5e76e4-38cc-4eec-b71c-de0ef590b9fa\",\n" +
//                "    \"d\": {\n" +
//                "      \"id\": \"0b5e76e4-38cc-4eec-b71c-de0ef590b9fa\",\n" +
//                "      \"application_id\": \"102815444\",\n" +
//                "      \"type\": 11,\n" +
//                "      \"data\": {\n" +
//                "        \"type\": 11,\n" +
//                "        \"resolved\": {\n" +
//                "          \"button_data\": \"回调测试\",\n" +
//                "          \"button_id\": \"1\"\n" +
//                "        }\n" +
//                "      },\n" +
//                "      \"version\": 1,\n" +
//                "      \"group_openid\": \"6AD974DB38B54D873F5A7E8D4B6BABFB\",\n" +
//                "      \"chat_type\": 1,\n" +
//                "      \"scene\": \"group\",\n" +
//                "      \"timestamp\": \"2026-05-09T08:57:00+08:00\",\n" +
//                "      \"group_member_openid\": \"9A633C87BBBA0A69ADC05AA64EFA02D7\"\n" +
//                "    },\n" +
//                "    \"t\": \"INTERACTION_CREATE\"\n" +
//                "  }\n" +
//                "]");
//        System.out.println(obj.length());


    }
//    @PostConstruct
//    public void init() {
//        scheduler.submit(this::a);
//    }
//    public void a() {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        JSONObject a = new JSONObject();
//        JSONObject sender = new JSONObject();
//        sender.put("user_id", 33)
//                .put("nickname", "测试");
//        a.put("time", sj.sjc())
//                .put("self_id",112435483)
//                .put("post_type","message")
//                .put("message_type","group")
//                .put("sub_type","normal")
//                .put("message_id",1)
//                .put("group_id","1000001")
//                .put("user_id",112435486)
//                .put("anonymous",(JSONObject)null)
//                .put("message","签到")
//                .put("raw_message","测试")
//                .put("sender",sender)
//                .put("echo","a");
//
//        wsd.ts(a.toString());
////        System.out.println(user.getQun("8036E461A566C47837CACDBDBEDFDC03").toString());
//    }
}
