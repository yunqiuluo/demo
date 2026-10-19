package top.ffxl.jqr.plugin;

import org.springframework.stereotype.Component;
import top.ffxl.jqr.gj.an;
import top.ffxl.jqr.gj.md;
import top.ffxl.jqr.sf.api;
import top.ffxl.jqr.sj.qqcs;

import java.util.List;
import java.util.Objects;

@Component
public class zx {

    private final List<rk> plugins;

    public zx(List<rk> plugins) {
        this.plugins = plugins;
    }

    public void executeAll(qqcs qqcs) throws Exception {
            // Spring 会自动按 @Order 排序，直接执行即可
            for (rk plugin : plugins) {
                String a = plugin.hy(qqcs);
                if (Objects.equals(a, "T") || Objects.equals(a, "t")){
                    break;
                }
            }
        an.removo();
        md.removo();
        api.msg_seq = 1;
        }
}
