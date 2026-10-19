package top.ffxl.jqr.gj;

import top.ffxl.jqr.sf.tokenjs;
import top.ffxl.jqr.sj.qqtk;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class http {
    public URL url;
    public HttpURLConnection con;
    public void ks(String url, String qqfs) throws Exception {
        this.url = new URL(url);
        con = (HttpURLConnection) this.url.openConnection();
        con.setRequestMethod(qqfs);
        con.setRequestProperty("Content-Type", qqtk.json);
    }
    public void RZ() throws Exception {
        tokenjs tokenjs = new tokenjs();
        con.setRequestProperty("Authorization",String.format("QQBot %s", tokenjs.token()));
    }

    public void qqto(String j,String z) {
        con.setRequestProperty(j,z);
    }

    public void qqti(String qqfs) throws Exception {
        con.setDoOutput(true);
        try (OutputStream os = con.getOutputStream()) {
            os.write(qqfs.getBytes(StandardCharsets.UTF_8));
        }
    }

    public String dqxy() throws IOException {
        int code = con.getResponseCode();
        try {
            InputStream xyt;
            if (code < 400) {
                xyt = con.getInputStream();
            }else {
                xyt = con.getErrorStream();
            }
            if (xyt == null) {
                return "null";
            }
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(xyt, StandardCharsets.UTF_8)
            );
            StringBuilder wzsj = new StringBuilder();
            String dqz;
            while ((dqz = br.readLine()) != null) {
                wzsj.append(dqz).append("\n");
            }
            br.close();
            return wzsj.toString();
        }catch (Exception e) {
            return e.getMessage();
        }
    }

    public void GJ() throws Exception {
        tokenjs tokenjs = new tokenjs();
        con.setRequestProperty("Authorization",String.format("QQBot %s", tokenjs.tokengj()));
    }
}
