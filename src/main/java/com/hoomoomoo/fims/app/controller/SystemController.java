package com.hoomoomoo.fims.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author humm23693
 * @description 系统控制类
 * @package com.hoomoomoo.fims.app.controller
 * @date 2019/08/09
 */

@Controller
@RequestMapping("/")
public class SystemController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "home/console", method = RequestMethod.GET)
    public String console() {
        return "home/console";
    }

    @RequestMapping(value = "home/homepage1", method = RequestMethod.GET)
    public String homepage1() {
        return "home/homepage1";
    }

    @RequestMapping(value = "home/homepage2", method = RequestMethod.GET)
    public String homepage2() {
        return "home/homepage2";
    }


}
