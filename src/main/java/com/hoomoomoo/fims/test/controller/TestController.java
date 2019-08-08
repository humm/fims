package com.hoomoomoo.fims.test.controller;

import com.hoomoomoo.fims.app.dto.SessionBean;
import com.hoomoomoo.fims.app.util.SystemSessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author humm23693
 * @description 测试控制类
 * @package com.hoomoomoo.fims.test.controller
 * @date 2019/08/08
 */

@Controller
@ResponseBody
@RequestMapping("/test")
public class TestController {

    @RequestMapping("sessionBean")
    public SessionBean testSessionBean(){
        return SystemSessionUtils.getSession();
    }
}
