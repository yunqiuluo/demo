package top.ffxl.jqr.gj;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class json {
    public static String tq(String xytjg, String cs) {
        try {
            JSONObject obj = new JSONObject(xytjg);
            return obj.getString(cs);
        } catch (Exception e) {
            return null;
        }
    }

    public static String tq(Map<String,Object> xytjg, String cs) {
        try {
            JSONObject obj = new JSONObject(xytjg);
            return obj.getString(cs);
        } catch (Exception e) {
            return null;
        }
    }

    public static int tqi(String xytjg, String cs) {
        try {
            JSONObject obj = new JSONObject(xytjg);
            return obj.getInt(cs);
        } catch (Exception e) {
            return -1;
        }
    }

    public static JSONObject tqo(String xytjg, String cs) {
        try {
            JSONObject obj = new JSONObject(xytjg);
            return obj.getJSONObject(cs);
        } catch (Exception e) {
            return null;
        }
    }
    public static JSONObject tqo(JSONObject xytjg, String cs) {
        try {
            return xytjg.getJSONObject(cs);
        } catch (Exception e) {
            return null;
        }
    }

    public static String tq(JSONObject obj, String cs) {
        try {
            return obj.getString(cs);
        } catch (Exception e) {
            try {
                return obj.getJSONObject(cs).toString();
            } catch (Exception ex) {
               return null;
            }
        }
    }

    public static String tq(String xytjg,int s,String cs) {
        try {
            JSONArray obj = new JSONArray(xytjg);
            return obj.getJSONObject(s).getString(cs);
        } catch (JSONException e) {
            return null;
        }
    }
    public static int tqi(String xytjg,int s,String cs) {
        try {
            JSONArray obj = new JSONArray(xytjg);
            return obj.getJSONObject(s).getInt(cs);
        } catch (JSONException e) {
            return -1;
        }
    }

    public static int tqi(JSONObject obj,String cs) {
        try {
            return obj.getInt(cs);
        }catch (JSONException e) {
            return -1;
        }
    }
    public static JSONArray tqa(String xytjg, String cs) {
        try {
            JSONObject obj = new JSONObject(xytjg);
            return obj.getJSONArray(cs);
        } catch (Exception e) {
            return null;
        }
    }
    public static String tq(JSONArray obj,int s,String cs) {
        try {
            return obj.getJSONObject(s).getString(cs);
        } catch (JSONException e) {
            return null;
        }
    }
    public static int tqi(JSONArray obj,int s,String cs) {
        try {
            return obj.getJSONObject(s).getInt(cs);
        } catch (JSONException e) {
            return -1;
        }
    }

    public static Object tpr(String xytjg, String cs) {
        try {
            JSONObject obj = new JSONObject(xytjg);
            return obj.opt(cs);
        } catch (JSONException e) {
            return null;
        }
    }

    public static boolean tqb(JSONArray obj,int s, String cs) {
        return obj.getJSONObject(s).optBoolean(cs);
    }
    public static boolean tqb(JSONObject obj, String cs) {
        return obj.optBoolean(cs);
    }

    public static long tql(JSONObject obj, String cs) {
        try {
            return obj.getLong(cs);
        }catch (JSONException e) {
            return -1;
        }
    }
    public static long tql(Map<String,Object> x, String cs) {
        try {
            JSONObject obj = new JSONObject(x);
            return obj.getLong(cs);
        }catch (JSONException e) {
            return -1;
        }
    }
}
