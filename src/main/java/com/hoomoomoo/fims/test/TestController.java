package com.hoomoomoo.fims.test;

import com.hoomoomoo.fims.app.model.common.SessionBean;
import com.hoomoomoo.fims.app.util.SystemSessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author humm23693
 * @description 测试控制类
 * @package com.hoomoomoo.fims.test.controller
 * @date 2019/08/08
 */

@Controller
@RequestMapping("/test/")
public class TestController {

    @RequestMapping(value = "sessionBean", method = RequestMethod.POST)
    @ResponseBody
    public SessionBean testSessionBean() {
        return SystemSessionUtils.getSession();
    }
}
