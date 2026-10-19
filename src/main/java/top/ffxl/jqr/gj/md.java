package top.ffxl.jqr.gj;

import org.json.JSONArray;
import org.json.JSONObject;

public class md {
    private static  StringBuilder md = new StringBuilder();
    public static StringBuilder fh(){
        return md;
    }
    public static void removo(){
        md = new StringBuilder();
    }
    public static void bt(String s){
        md.append("#").append(s).append("\n");
    }
    public static void dl(String s){
        md.append(s);
    }
    public static void dlln(String s){
        md.append(s).append("\n");
    }
    public static void dl(int s){
        md.append(s);
    }
    public static void dlln(int s){
        md.append(s).append("\n");
    }
    public static void ln(){
        md.append("\n");
    }
    public static void xt (String s){
        md.append("*").append(s).append("*");
    }
    public static void ct (String s){
        md.append("**").append(s).append("**");
    }
    public static void cxt(String s){
        md.append("***").append(s).append("***");
    }
    public static void scx(String s){
        md.append("~~").append(s).append("~~");
    }
    public static void fgx(){
        md.append("***").append("\n");
    }
    public static void wx(String s){
        md.append("- ").append(s).append("\n");
    }
    public static void yx(String s){
        md.append("1. ").append(s).append("\n");
    }
    public static void qt(){
        md.append("    ");
    }
    public static void tp(int k,int g,String url){
        md.append("![text #").append(k).append("px #").append(g).append("px](").append(url).append(")\n");
    }
}
