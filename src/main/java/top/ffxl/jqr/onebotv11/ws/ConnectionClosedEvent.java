package top.ffxl.jqr.onebotv11.ws;

import org.springframework.context.ApplicationEvent;

public class ConnectionClosedEvent extends ApplicationEvent {
    public ConnectionClosedEvent(Object source) {
        super(source);
    }
}
