package top.ffxl.jqr.ws;

import jakarta.websocket.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import top.ffxl.jqr.gj.http;
import top.ffxl.jqr.gj.json;
import top.ffxl.jqr.onebotv11.sjk.UserMapper;
import top.ffxl.jqr.onebotv11.ws.ConnectionClosedEvent;
import top.ffxl.jqr.plugin.zx;
import top.ffxl.jqr.sf.tokenjs;
import top.ffxl.jqr.sj.glj;
import top.ffxl.jqr.sj.qqcs;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Slf4j
@Component
public class jqrwsd extends Endpoint {
    private final UserMapper user;
    public static final ThreadLocal<qqcs> de = new ThreadLocal<>();
    private final zx zx;
    private ScheduledExecutorService scheduler;
    private ExecutorService msgExecutor;
    private int heartbeat_interval;
    private static int s;
    private static volatile Session session;
    private final ApplicationEventPublisher eventPublisher;
    private static String session_id = null;
    static tokenjs tokenjs = new tokenjs();
    public jqrwsd(zx zx, UserMapper user, ApplicationEventPublisher eventPublisher) {
        this.zx = zx;
        this.user = user;
        this.eventPublisher = eventPublisher;

    }
    @SneakyThrows
    @Override
    public void onOpen(Session session, EndpointConfig config) {
        jqrwsd.session = session;
        log.info("连接建立{}", session.getId());
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
        this.msgExecutor = Executors.newCachedThreadPool();

        session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String message) {
                    msgExecutor.submit(() -> {
                        switch (json.tqi(message,"op")) {
                            case 10:
                                heartbeat_interval = json.tqi(Objects.requireNonNull(json.tqo(message, "d")),"heartbeat_interval");
                                if(session_id != null){
                                    JSONObject payload = new JSONObject();
                                    payload.put("op",6);
                                    JSONObject d = new JSONObject();
                                    try {
                                        d.put("token",String.format("QQBot %s",tokenjs.token()));
                                        d.put("session_id",session_id);
                                        d.put("seq",s);
                                        payload.put("d",d);
                                        ts(payload.toString());
                                    } catch (Exception e) {
                                        throw new RuntimeException(e);
                                    }
                                    scheduler.scheduleAtFixedRate(() -> ts(String.format("{\"op\": 1,\"d\": %s}",s)), 0, heartbeat_interval, TimeUnit.MILLISECONDS);
                                    return;
                                }
                                JSONObject payload = new JSONObject();
                                payload.put("op",2);
                                JSONObject d = getD();
                                payload.put("d",d);
                                ts(payload.toString());
                                return;
                            case 0:
                                de.set(new qqcs(message));
                                if (json.tqi(message,"s") != -1){
                                    s = json.tqi(message,"s");
                                }
                                if ((json.tqb(new JSONObject(user.getQun(de.get().group_openid)),"ts") || new JSONObject(user.getQun(de.get().group_openid)).isEmpty()) && !json.tqb(new JSONObject(user.getUserQqbot(de.get().openid)),"hei")) {
                                    log.debug(message);
                                    if (Objects.equals(json.tq(message, "t"), "READY")) {
                                        scheduler.scheduleAtFixedRate(() -> ts(String.format("{\"op\": 1,\"d\": %s}",s)), 0, heartbeat_interval, TimeUnit.MILLISECONDS);
                                        session_id = json.tq(json.tqo(message, "d"), "session_id");
                                        return;
                                    }
                                    if (Objects.equals(json.tq(message, "t"), "INTERACTION_CREATE")) {
                                        http a = new http();
                                        try {
                                            a.ks(glj.tydz + "/interactions/" + json.tq(Objects.requireNonNull(json.tqo(message, "d")),"id") ,"PUT");
                                            a.RZ();
                                            JSONObject E = new JSONObject();
                                            E.put("code",0);
                                            a.qqti(E.toString());
                                            a.dqxy();
                                        } catch (Exception e) {
                                            throw new RuntimeException(e);
                                        }
                                    }
                                    try {
                                        zx.executeAll(de.get());
                                    } catch (Exception e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                                return;
                            case 7:
                                log.debug("收到服务端 Reconnect 请求，准备重连");
                                return;
                        }
                    });

            }
        });
    }

    private static JSONObject getD() {
        JSONObject d = new JSONObject();
        tokenjs tokenjs = new tokenjs();
        try {
            d.put("token",String.format("QQBot %s", tokenjs.token()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        d.put("intents", 1 | 1 << 1 | 1 << 9 | 1 << 10 | 1 << 12 | 1 << 18 | 1 << 19 | 1 << 21 | 1 << 22 | 1 << 24 | 1 << 25 | 1 << 26 | 1 << 27 | 1 << 28 | 1 << 29 | 1 << 30);
        d.put("properties", "{}");
        return d;
    }

    @Override
    public void onClose(Session session, CloseReason reason) {
        if (!Objects.equals(reason.getReasonPhrase(), "Session timed out")) {
            log.error("{}连接已关闭，原因: {}", session.getId(), reason.getReasonPhrase());
        }
        scheduler.shutdownNow();
        msgExecutor.shutdownNow();
        eventPublisher.publishEvent(new ConnectionClosedEvent(jqrwsd.this));
    }
    @Override
    public void onError(Session session, Throwable error) {
        String message = error.getMessage();
        log.warn("ws错误{}",message);
    }

    public static void ts(String message) {
        if (session != null && session.isOpen()) {
            session.getAsyncRemote().sendText(message
//                    , result -> {
//                if (!result.isOK()) {
//                    log.warn("发送失败: " + result.getException());
//                } else {
//                    log.info("消息已同步至虚拟机");
//                }
//            }
            );
        }
        if (json.tqi(message,"op") != 2 && json.tqi(message,"op") != 6) {
            log.debug(message);
        }
    }
}
