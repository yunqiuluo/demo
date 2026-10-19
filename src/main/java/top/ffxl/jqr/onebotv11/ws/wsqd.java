package top.ffxl.jqr.onebotv11.ws;

import jakarta.annotation.PostConstruct;
import jakarta.websocket.ClientEndpointConfig;
import jakarta.websocket.ContainerProvider;
import jakarta.websocket.WebSocketContainer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import top.ffxl.jqr.onebotv11.wsd;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
@Slf4j
@Component
public class wsqd {
    private final wsd client;
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public wsqd(wsd client) {
        this.client = client;
    }

    @PostConstruct
    public void init(){
        if (true) {
            scheduler.submit(this::ks);
        }
    }
    @EventListener
    public void handleConnectionClosed(ConnectionClosedEvent event) {
        if (event.getSource() != this.client) return;
        log.info("收到连接关闭事件，准备重连...");
        init();
    }
    public void ks(){
        try {
            ClientEndpointConfig config = ClientEndpointConfig.Builder.create()
                    .configurator(new ClientEndpointConfig.Configurator() {
                        @Override
                        public void beforeRequest(Map<String, List<String>> headers) {
                            headers.put("X-Self-ID", List.of("112435483"));
                            headers.put("X-Client-Role", List.of("Universal"));
                        }
                    })
                    .build();

            // 2. 获取容器并连接
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(client,config,URI.create("ws://win.ffxl.top:8080"));
        } catch (Exception e) {
            scheduler.schedule(this::ks, 5, TimeUnit.SECONDS);
        }
    }
}
