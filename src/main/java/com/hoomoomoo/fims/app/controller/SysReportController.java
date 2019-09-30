package com.hoomoomoo.fims.app.controller;

import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.service.SysReportService;
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

/**
 * @author humm23693
 * @description 报表控制类
 * @package com.hoomoomoo.fims.app.controller
 * @date 2019/09/08
 */

@Controller
@RequestMapping("/report")
public class SysReportController {

    private static final Logger logger = LoggerFactory.getLogger(SysReportController.class);

    @Autowired
    private SysReportService sysReportService;

    /**
     * 跳转收入信息报表页面
     *
     * @return
     */
    @ApiOperation("跳转收入信息报表页面")
    @RequestMapping(value = "view/income", method = RequestMethod.GET)
    public String incomeReport() {
        return "report/incomeReport";
    }

    /**
     * 跳转送礼信息报表页面
     *
     * @return
     */
    @ApiOperation("跳转送礼信息报表页面")
    @RequestMapping(value = "view/giftSend", method = RequestMethod.GET)
    public String giftSendReport() {
        return "report/giftSendReport";
    }

    /**
     * 跳转收礼信息报表页面
     *
     * @return
     */
    @ApiOperation("跳转收礼信息报表页面")
    @RequestMapping(value = "view/giftReceive", method = RequestMethod.GET)
    public String giftReceiveReport() {
        return "report/giftReceiveReport";
    }

    /**
     * 查询报表数据
     *
     * @return
     */
    @ApiOperation("查询报表数据")
    @RequestMapping(value = "initData", method = RequestMethod.GET)
    @ResponseBody
    public ResultData initData(
            @ApiParam(value = "报表模式", required = true)
            @RequestParam String reportMode,
            @ApiParam(value = "报表类型", required = true)
            @RequestParam String reportType,
            @ApiParam(value = "报表子类型", required = true)
            @RequestParam String reportSubType,
            @ApiParam(value = "报表选值", required = false)
            @RequestParam(required = false) String reportValue) {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_REPORT_INCOME, LOG_OPERATE_TYPE_SELECT);
        ResultData resultData = sysReportService.initData(reportMode, reportType, reportSubType, reportValue);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_REPORT_INCOME, LOG_OPERATE_TYPE_SELECT);
        return resultData;
    }
}
