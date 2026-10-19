package top.ffxl.jqr.sf;

import top.ffxl.jqr.sj.qqtk;
import top.ffxl.jqr.gj.http;
import top.ffxl.jqr.gj.json;

public class tokenjs {
    public String token() throws Exception {
        http h = new http();
        h.ks("https://bots.qq.com/app/getAppAccessToken","POST");
        h.qqti(qqtk.kensf);
        return json.tq(h.dqxy(),"access_token");
    }

    public String tokengj() throws Exception {
        http h = new http();
        h.ks("https://bots.qq.com/app/getAppAccessToken","POST");
        h.qqti(qqtk.kensfGJ);
        return json.tq(h.dqxy(),"access_token");
    }
}
