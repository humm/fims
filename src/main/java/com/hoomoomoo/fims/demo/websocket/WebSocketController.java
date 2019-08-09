package com.hoomoomoo.fims.demo.websocket;

import com.hoomoomoo.fims.app.util.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @author humm23693
 * @description WebSocket测试控制类
 * @package com.hoomoomoo.fims.test.controller
 * @date 2019/08/08
 */

@Controller
@RequestMapping("/webSocket/")
public class WebSocketController {

    @RequestMapping("sendMessage")
    @ResponseBody
    public String sendMessage(String sid){

        try {
            WebSocketServer.sendInfo(DateUtils.yyyyMMddHHmmss() + " 系统主动推送消息", sid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "消息推送成功";
    }
}
