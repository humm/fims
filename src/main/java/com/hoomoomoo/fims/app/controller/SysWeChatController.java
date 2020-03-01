package com.hoomoomoo.fims.app.controller;

import com.hoomoomoo.fims.app.service.SysWeChatService;
import com.hoomoomoo.fims.app.util.SysLogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

import static com.hoomoomoo.fims.app.consts.CueConst.*;

/**
 * @author humm23693
 * @description 微信消息控制类
 * @package com.hoomoomoo.fims.app.controller
 * @date 2020/02/27
 */

@RestController
@RequestMapping("/wechat")
public class SysWeChatController {

    private static final Logger logger = LoggerFactory.getLogger(SysWeChatController.class);

    @Autowired
    private SysWeChatService sysWeChatService;

    /**
     * 微信消息处理
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/message")
    public String message(HttpServletRequest request, HttpServletResponse response){
        SysLogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_WECHAT, LOG_OPERATE_TYPE_HANDLE);
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            SysLogUtils.exception(logger, LOG_BUSINESS_TYPE_WECHAT, e);
        }
        SysLogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_WECHAT, LOG_OPERATE_TYPE_HANDLE);
        return sysWeChatService.message(request);
    }

}
