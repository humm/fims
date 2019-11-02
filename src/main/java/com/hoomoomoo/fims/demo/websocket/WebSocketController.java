package com.hoomoomoo.fims.demo.websocket;

import com.hoomoomoo.fims.app.util.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("index", DateUtils.yyyyMMddHHmmss());
        return "/demo/webSocket";
    }

}
