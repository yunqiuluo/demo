package top.ffxl.jqr.sj;

public class glj {
    String qqlx;
    String openid;
    public static String tydz = "https://api.sgroup.qq.com";
    public String fsv2;
    public String tu;
    public String fs;
    public glj(qqcs qqcs) {
        switch (qqcs.t){
            case "C2C_MESSAGE_CREATE":
                qqlx = "users";
                openid = qqcs.openid;
                break;
            case "GROUP_AT_MESSAGE_CREATE":
            case "GROUP_MESSAGE_CREATE":
                qqlx = "groups";
                openid = qqcs.group_openid;
                break;
            case "MESSAGE_CREATE":
            case "AT_MESSAGE_CREATE":
                qqlx = "channels";
                openid = qqcs.channel_id;
                break;
            case "DIRECT_MESSAGE_CREATE":
                qqlx = "dms";
                openid = qqcs.guild_id;
        }
        this.fsv2 = String.format("/v2/%s/%s/messages", qqlx, openid);
        this.fs = String.format("/%s/%s/messages", qqlx, openid);
        this.tu = String.format("/v2/%s/%s", qqlx, openid);
    }
}
