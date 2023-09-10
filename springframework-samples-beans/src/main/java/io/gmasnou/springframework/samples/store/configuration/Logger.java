package io.gmasnou.springframework.samples.store.configuration;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.LayoutBase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger extends LayoutBase<ILoggingEvent> {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.mmm'Z'");

    public Logger() {

    }

    @Override
    public String doLayout(ILoggingEvent event) {

        ObjectNode objectNode = this.objectMapper.createObjectNode();
        objectNode.put("level", event.getLevel().toString());
        objectNode.put("date", this.dateFormat.format(new Date(event.getTimeStamp())));
        objectNode.put("thread", event.getThreadName());
        objectNode.put("logger", event.getLoggerName());
        objectNode.put("message", event.getMessage());
        return objectNode.toString() + CoreConstants.LINE_SEPARATOR;
    }
}
