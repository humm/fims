package com.hoomoomoo.fims.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author humm23693
 * @description WebSocket服务端
 * @package com.hoomoomoo.fims.app.config
 * @date 2019/08/09
 */
@Component
@ServerEndpoint("/websocket/{sid}")
public class WebSocketServerConfig {

    private static final Logger log = LoggerFactory.getLogger(WebSocketServerConfig.class);

    /**
     * WebSocket对象
     */
    private static CopyOnWriteArraySet<WebSocketServerConfig> webSocketSet = new CopyOnWriteArraySet<>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * 接收sid
     */
    private String sid;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        webSocketSet.add(this);
        this.session = session;
        this.sid = sid;
        try {
            sendMessage(String.format("websocket连接成功: %s", sid));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info(String.format("客户端 %s: %s", sid, message));
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    /**
     * 群发自定义消息
     */
    public static void sendMessageInfo(@PathParam("sid") String sid, String message) {
        for (WebSocketServerConfig item : webSocketSet) {
            try {
                if (item.sid.equals(sid)) {
                    log.info(String.format("%s 推送消息: %s", sid, message));
                    item.sendMessage(message);
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
