package top.ffxl.jqr.gj;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Objects;

public class an {
    private static  JSONArray keyboard = new JSONArray();
    private static JSONArray buttons = new JSONArray();
    private static JSONObject rows = new JSONObject();
    public static JSONArray fh(){
        if (!Objects.equals(keyboard.toString(), "[]")) {
            return keyboard;
        }
        return null;
    }
    public static void removo(){
        keyboard = new JSONArray();
    }
    public static void rows_add(){
        rows.put("buttons",buttons);
        keyboard.put(rows);
        buttons = new JSONArray();
        rows = new JSONObject();
    }
    public static void buttons_add(String id,String label,String visited_label,int style,int type,int permission_type,String[] specify_user_ids,String data,int anchor){
        JSONObject button = new JSONObject();
        button.put("id",id);
        JSONObject render_data = new JSONObject();
        render_data.put("label",label);
        render_data.put("visited_label",visited_label);
        render_data.put("style",style);
        button.put("render_data",render_data);
        JSONObject action = new JSONObject();
        action.put("type",type);
        JSONObject permission = new JSONObject();
        permission.put("type",permission_type);
        permission.put("specify_user_ids",specify_user_ids);
        action.put("permission",permission);
        action.put("data",data);
        action.put("anchor",anchor);
        action.put("unsupport_tips","你的版本暂不支持本操作");
        button.put("action",action);
        buttons.put(button);
    }

}
