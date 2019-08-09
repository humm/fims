package com.hoomoomoo.fims.demo.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;


/**
 * @author humm23693
 * @description WebSocket配置类
 * @package com.hoomoomoo.fims.test.webSocket
 * @date 2019/08/09
 */

@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
