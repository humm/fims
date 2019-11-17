package com.hoomoomoo.fims.app.controller;

import com.hoomoomoo.fims.app.model.SysIncomeModel;
import com.hoomoomoo.fims.app.model.SysLoginLogQueryModel;
import com.hoomoomoo.fims.app.model.common.FimsPage;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.service.SysLoginLogService;
import com.hoomoomoo.fims.app.util.LogUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.hoomoomoo.fims.app.consts.TipConst.*;
import static com.hoomoomoo.fims.app.consts.TipConst.LOG_OPERATE_TYPE_SELECT_PAGE;


/**
 * @author humm23693
 * @description 登入日志控制类
 * @package com.hoomoomoo.fims.app.controller
 * @date 2019/10/26
 */

@Controller
@RequestMapping("/loginLog")
public class SysLoginLogController {

    private static final Logger logger = LoggerFactory.getLogger(SysLoginLogController.class);

    @Autowired
    private SysLoginLogService sysLoginLogService;

    /**
     * 跳转列表页面
     *
     * @return
     */
    @ApiOperation("跳转列表页面")
    @RequestMapping(value = "view/list", method = RequestMethod.GET)
    public String viewList() {
        return "loginLog/list";
    }

    /**
     * 跳转详情页面
     *
     * @return
     */
    @ApiOperation("跳转详情页面")
    @RequestMapping(value = "view/detail", method = RequestMethod.GET)
    public String viewDetail() {
        return "loginLog/detail";
    }


    /**
     * 查询页面初始化信息
     *
     * @return
     */
    @ApiOperation("查询页面初始化信息")
    @RequestMapping(value = "selectInitData", method = RequestMethod.GET)
    @ResponseBody
    public ResultData selectInitData() {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_LOGIN_LOG, LOG_OPERATE_TYPE_SELECT_INIT);
        ResultData resultData = sysLoginLogService.selectInitData();
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_LOGIN_LOG, LOG_OPERATE_TYPE_SELECT_INIT);
        return resultData;
    }

    /**
     * 分页查询登入日志信息
     *
     * @param sysLoginLogQueryModel
     * @return
     */
    @ApiOperation("分页查询登入日志信息")
    @RequestMapping(value = "selectPage", method = RequestMethod.GET)
    @ResponseBody
    public FimsPage<SysIncomeModel> selectPage(SysLoginLogQueryModel sysLoginLogQueryModel) {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_LOGIN_LOG, LOG_OPERATE_TYPE_SELECT_PAGE);
        FimsPage fimsPage = sysLoginLogService.selectPage(sysLoginLogQueryModel);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_LOGIN_LOG, LOG_OPERATE_TYPE_SELECT_PAGE);
        return fimsPage;
    }

    /**
     * 查询登入日志信息
     *
     * @param logId
     * @return
     */
    @ApiOperation("查询登入日志信息")
    @RequestMapping(value = "selectOne", method = RequestMethod.GET)
    @ResponseBody
    public ResultData selectOne(
            @ApiParam(value = "登入日志信息ID", required = true)
            @RequestParam String logId,
            @ApiParam(value = "是否翻译", required = true)
            @RequestParam Boolean isTranslate) {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_LOGIN_LOG, LOG_OPERATE_TYPE_SELECT);
        ResultData resultData = sysLoginLogService.selectOne(logId, isTranslate);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_LOGIN_LOG, LOG_OPERATE_TYPE_SELECT);
        return resultData;
    }
}
