package com.hoomoomoo.fims.app.controller;

import com.hoomoomoo.fims.app.model.SysIncomeModel;
import com.hoomoomoo.fims.app.model.SysIncomeQueryModel;
import com.hoomoomoo.fims.app.model.common.FimsPage;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.service.SysIncomeService;
import com.hoomoomoo.fims.app.util.LogUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import static com.hoomoomoo.fims.app.consts.TipConst.*;

/**
 * @author humm23693
 * @description 收入信息控制类
 * @package com.hoomoomoo.fims.app.controller
 * @date 2019/08/10
 */

@Controller
@RequestMapping("/income")
public class SysIncomeController {

    private static final Logger logger = LoggerFactory.getLogger(SysIncomeController.class);

    @Autowired
    private SysIncomeService sysIncomeService;

    /**
     * 跳转列表页面
     *
     * @return
     */
    @ApiOperation("跳转列表页面")
    @RequestMapping(value = "view/list", method = RequestMethod.GET)
    public String viewList() {
        return "income/list";
    }


    /**
     * 跳转详情页面
     *
     * @return
     */
    @ApiOperation("跳转详情页面")
    @RequestMapping(value = "view/detail", method = RequestMethod.GET)
    public String viewDetail() {
        return "income/detail";
    }


    /**
     * 分页查询收入信息
     *
     * @param sysIncomeQueryModel
     * @return
     */
    @ApiOperation("分页查询收入信息")
    @RequestMapping(value = "selectPage", method = RequestMethod.GET)
    @ResponseBody
    public FimsPage<SysIncomeModel> selectPage(
                    SysIncomeQueryModel sysIncomeQueryModel) {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_SELECT_PAGE);
        FimsPage<SysIncomeModel> page = sysIncomeService.selectPage(sysIncomeQueryModel);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_SELECT_PAGE);
        return page;
    }

    /**
     * 查询列表页面初始化信息
     *
     * @return
     */
    @ApiOperation("查询列表页面初始化信息")
    @RequestMapping(value = "selectListInitData", method = RequestMethod.GET)
    @ResponseBody
    public ResultData selectListInitData() {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_SELECT_INIT);
        ResultData resultData = sysIncomeService.selectListInitData();
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_SELECT_INIT);
        return resultData;
    }

    /**
     * 删除收入信息
     *
     * @param incomeIds
     * @return
     */
    @ApiOperation("删除收入信息")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultData delete(
            @ApiParam(value = "收入信息ID", required = true)
            @RequestParam String incomeIds) {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_DELETE);
        ResultData resultData = sysIncomeService.delete(incomeIds);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_DELETE);
        return resultData;
    }


    /**
     * 查询收入信息
     *
     * @param incomeId
     * @return
     */
    @ApiOperation("查询收入信息")
    @RequestMapping(value = "selectOne", method = RequestMethod.GET)
    @ResponseBody
    public ResultData selectOne(
            @ApiParam(value = "收入信息ID", required = true)
            @RequestParam String incomeId) {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_SELECT);
        ResultData resultData = sysIncomeService.selectOne(incomeId);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_SELECT);
        return resultData;
    }

}
