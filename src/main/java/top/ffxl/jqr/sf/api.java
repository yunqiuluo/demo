package top.ffxl.jqr.sf;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import top.ffxl.jqr.sj.glj;
import top.ffxl.jqr.sj.qqcs;
import top.ffxl.jqr.gj.http;
import top.ffxl.jqr.gj.json;

import java.util.Objects;
@Slf4j
public class api {
    public static int msg_seq = 1;

    public String hf(String CH, String content, int msg_type, qqcs ss, JSONArray keyboard) throws Exception {
        gzk gz = new gzk();
        http qq = new http();
        String lj = ljfl(ss);
        qq.ks(glj.tydz + lj,"POST");
        qq.RZ();
        String f = gz.fl(content,msg_type,msg_seq,ss,keyboard);
        qq.qqti(f);
//        htrk.de.set(f);
        String a = qq.dqxy();
        log.debug(a);
        if(Objects.equals(CH, "D") || Objects.equals(CH, "d")){
            String id = json.tq(a,"id");
            qq.ks(glj.tydz + lj + "/" + id,"DELETE");
            qq.RZ();
            log.debug(qq.dqxy());
        }
        msg_seq += 1;
        log.info("回复了文本{}",content);
        return a;
    }
    public void hf(String CH,int djs, String content,int msg_type, qqcs ss, JSONArray keyboard) throws Exception {
        gzk gz = new gzk();
        http qq = new http();
        String lj = ljfl(ss);
        qq.ks(glj.tydz + lj,"POST");
        qq.RZ();
        String f = gz.fl(content,msg_type,msg_seq,ss,keyboard);
        qq.qqti(f);
        String a = qq.dqxy();
        log.debug(a);
//        htrk.de.set(f);
        if(Objects.equals(CH, "D") || Objects.equals(CH, "d")){
            String id = json.tq(a,"id");
            qq.ks(glj.tydz + lj + "/"  + id,"DELETE");
            qq.RZ();
            Thread.sleep(djs* 1000L);
            log.debug(qq.dqxy());
        }
        msg_seq += 1;
        log.info("回复了文本{}",content);
    }


    public String hf(String CH, String content,String url,int file_type,qqcs ss) throws Exception {
        gzk gz = new gzk();
        http qq = new http();
        String lj = ljfl(ss);
        qq.ks(glj.tydz + lj,"POST");
        qq.RZ();
        String f = gz.fl(content,url,file_type,msg_seq,ss);
        qq.qqti(f);
//        htrk.de.set(f);
        String a = qq.dqxy();
        log.debug(a);
        if(Objects.equals(CH, "D") || Objects.equals(CH, "d")){
            String id = json.tq(a,"id");
            qq.ks(glj.tydz + lj + "/"  + id,"DELETE");
            qq.RZ();
            log.debug(qq.dqxy());
        }
        msg_seq += 1;
        log.info("回复了资源{}，文本{}",url,content);
        return a;
    }

    public void hf(String CH,int djs, String content,String url,int file_type,qqcs ss) throws Exception {
        gzk gz = new gzk();
        http qq = new http();
        String lj = ljfl(ss);
        qq.ks(glj.tydz + lj,"POST");
        qq.RZ();
        String f = gz.fl(content,url,file_type,msg_seq,ss);
        qq.qqti(f);
        String a = qq.dqxy();
        log.debug(a);
//        htrk.de.set(f);
        if(Objects.equals(CH, "D") || Objects.equals(CH, "d")){
            String id = json.tq(a,"id");
            qq.ks(glj.tydz + lj + "/"  + id,"DELETE");
            qq.RZ();
            Thread.sleep(djs* 1000L);
            log.debug(qq.dqxy());
        }
        msg_seq += 1;
        log.info("回复了资源{}，文本{}",url,content);
    }
    public void gj(String CH, String content, int msg_type, qqcs ss, JSONArray keyboard) throws Exception {
        gzk gz = new gzk();
        http qq = new http();
        String lj = ljfl(ss);
        qq.ks(glj.tydz + lj,"POST");
        qq.GJ();
        String f = gz.fl(content,msg_type,msg_seq,ss,keyboard);
        qq.qqti(f);
//        htrk.de.set(f);
        String a = qq.dqxy();
        log.debug(a);
        if(Objects.equals(CH, "D") || Objects.equals(CH, "d")){
            String id = json.tq(a,"id");
            qq.ks(glj.tydz + lj + "/" + id,"DELETE");
            qq.GJ();
            log.debug(qq.dqxy());
        }
        msg_seq += 1;
        log.info("回复了文本{}",content);
    }
    public String hfZd(String CH, String content, int msg_type, qqcs ss, JSONArray keyboard) throws Exception {
        gzk gz = new gzk();
        http qq = new http();
        String lj = ljfl(ss);
        qq.ks(glj.tydz + lj,"POST");
        qq.RZ();
        String f = gz.gz(content,msg_type,keyboard);
        qq.qqti(f);
//        htrk.de.set(f);
        String a = qq.dqxy();
        log.debug(a);
        if(Objects.equals(CH, "D") || Objects.equals(CH, "d")){
            String id = json.tq(a,"id");
            qq.ks(glj.tydz + lj + "/" + id,"DELETE");
            qq.RZ();
            log.debug(qq.dqxy());
        }
        msg_seq += 1;
        log.info("发送了文本{}",content);
        return a;
    }
    public String hfzd(String CH, String content,String url,int file_type,qqcs ss) throws Exception {
        gzk gz = new gzk();
        http qq = new http();
        String lj = ljfl(ss);
        qq.ks(glj.tydz + lj,"POST");
        qq.RZ();
        String f = gz.gz(content,url,file_type,ss);
        qq.qqti(f);
//        htrk.de.set(f);
        String a = qq.dqxy();
        log.debug(a);
        if(Objects.equals(CH, "D") || Objects.equals(CH, "d")){
            String id = json.tq(a,"id");
            qq.ks(glj.tydz + lj + "/"  + id,"DELETE");
            qq.RZ();
            log.debug(qq.dqxy());
        }
        msg_seq += 1;
        log.info("发送了资源{}，文本{}",url,content);
        return a;
    }

    public String ljfl(qqcs ss){
        glj glj = new glj(ss);
        return switch (ss.t) {
            case "C2C_MESSAGE_CREATE", "GROUP_AT_MESSAGE_CREATE","GROUP_MESSAGE_CREATE" -> glj.fsv2;
            case "MESSAGE_CREATE", "AT_MESSAGE_CREATE", "DIRECT_MESSAGE_CREATE" -> glj.fs;
            default -> null;
        };
    }
}
