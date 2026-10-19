package top.ffxl.jqr;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import top.ffxl.jqr.gj.json;
import top.ffxl.jqr.sf.api;
import top.ffxl.jqr.sf.jy;
import top.ffxl.jqr.sj.qqcs;
import top.ffxl.jqr.plugin.zx;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.*;

@Slf4j
@RestController
public class wh {
    private final zx zx;
//    public static final ThreadLocal<String> de = new ThreadLocal<>();
    private final ConcurrentHashMap<String, Long> messageCache = new ConcurrentHashMap<>();
    private static final long CACHE_DURATION = 60000;

    public wh(zx zx) {
        this.zx = zx;
    }

    @RequestMapping("/")
    public Map<String, Object> ljcj(HttpServletResponse zt, @RequestBody(required = false) String a) throws Exception {
        Map<String, Object> aa = new HashMap<>();
        aa.put("op",12);
        aa.put("code",0);
        aa.put("msg","ok");
        qqcs qqcs = new qqcs(a);
        Map<String, Object> c = new HashMap<>();
        c.put("op",12);
        c.put("code",404);
        c.put("msg","不规范的请求！");
        if (a !=null) {
            log.debug(a);

            if (qqcs.op == 0 && isDuplicateMessage(json.tq(json.tqo(a,"d"),"id"))&& !Objects.equals(json.tq(json.tqo(a, "d"), "id"), "ROBOT1.0_SQQU9ltxvaJZrBqQPmpQy6-YW-qV1A7MI8V1Rj0Gm8VvWVSyImaHsoip3JDO74q2bRlz1-g4P-nGtOmkEuSt6n8dDvt5Z.qr2Z7q4itSjnQ!")) {
                return aa;
            }

            switch (qqcs.op) {
                case 13:
                    Map<String, Object> j = new HashMap<>();
                    j.put("plain_token", json.tq(json.tqo(a, "d"), "plain_token"));
                    j.put("signature",jy.js(json.tq(json.tqo(a, "d"), "plain_token"), json.tq(json.tqo(a, "d"), "event_ts")));
                    j.put("op",12);
                    j.put("code",0);
                    j.put("msg","ok");
                    return j;
                case 0:
                    messageCache.put(Objects.requireNonNull(json.tq(json.tqo(a, "d"), "id")), System.currentTimeMillis());
                    CompletableFuture.runAsync(() -> {
                        api ai = new api();
                        try {
                            ai.gj("e","该账户已停止服务\n有关功能已迁移至：sky光遇雪灵_群娱\n机器人账号：4012206610\n本账户将在六月中旬正式注销",0,qqcs,null);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
//                    if (de.get() != null) {
//                        aa.put("date",de.get());
//                        de.remove();
//                    }
                    return aa;
                default:
                    zt.setStatus(403);
                    return c;
            }
        }else {
            zt.setStatus(403);
            return c;
        }
    }
    private boolean isDuplicateMessage(String messageId) {
        Long processedTime = messageCache.get(messageId);
        if (processedTime == null) {
            return false;
        }
        if (System.currentTimeMillis() - processedTime > CACHE_DURATION) {
            // 过期了，移除并返回不重复
            messageCache.remove(messageId);
            return false;
        }

        return true;
    }
    @PostConstruct
    public void startCleanupTask() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            long currentTime = System.currentTimeMillis();
            messageCache.entrySet().removeIf(entry ->
                    currentTime - entry.getValue() > CACHE_DURATION
            );
        }, 1, 1, TimeUnit.MINUTES); // 每分钟清理一次
    }
}
