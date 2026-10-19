package top.ffxl.jqr.onebotv11;

import jakarta.websocket.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import top.ffxl.jqr.onebotv11.api.ai;
import top.ffxl.jqr.onebotv11.ws.ConnectionClosedEvent;
import top.ffxl.jqr.gj.json;
import top.ffxl.jqr.onebotv11.sj.ysj;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Slf4j
@ClientEndpoint
@Component
public class wsd extends Endpoint {
    private final ai ai;
    private static volatile Session session;
    private final ApplicationEventPublisher eventPublisher;
    private ScheduledExecutorService scheduler;
    private ExecutorService msgExecutor;

    public wsd(ai api, ApplicationEventPublisher eventPublisher) {
        this.ai = api;
        this.eventPublisher = eventPublisher;
    }

    @SneakyThrows
    @Override
    public void onOpen(Session session, EndpointConfig config) {
        wsd.session = session;
        log.info("连接建立{}", session.getId());
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
        this.msgExecutor = Executors.newCachedThreadPool();

        ts(ysj.smzq());
        log.debug(ysj.smzq());
        scheduler.scheduleAtFixedRate(() -> ts(ysj.xt()), 5, 5, TimeUnit.SECONDS);



        session.addMessageHandler(new MessageHandler.Whole<byte[]>() {
            @Override
            public void onMessage(byte[] data) {
                msgExecutor.submit(() -> {
                    String message = new String(data, java.nio.charset.StandardCharsets.UTF_8);
                    if (!Objects.equals(json.tq(message,"action"),"get_status") && !Objects.equals(json.tq(message,"action"),"get_login_info") && !(Objects.equals(json.tq(message,"action"),"get_stranger_info") && json.tqi(Objects.requireNonNull(json.tqo(message, "params")),"user_id") == 112435483)) {
                        log.debug(message);
                    }
                    try {
                        String aiDy = ai.dy(message);
                        if (aiDy != null) {
                            log.debug(aiDy);
                            ts(aiDy);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        });
    }

    @Override
    public void onClose(Session session, CloseReason reason) {
        log.error("{}连接已关闭，原因: {}", session.getId(), reason.getReasonPhrase());
        scheduler.shutdownNow();
        msgExecutor.shutdownNow();
        eventPublisher.publishEvent(new ConnectionClosedEvent(this));
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
    }
}
