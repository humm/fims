package com.hoomoomoo.fims.app.controller;

import com.hoomoomoo.fims.app.model.SysIncomeModel;
import com.hoomoomoo.fims.app.model.SysIncomeQueryModel;
import com.hoomoomoo.fims.app.model.common.FimsPage;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.service.SysIncomeService;
import com.hoomoomoo.fims.app.util.LogUtils;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
     * 跳转列表查询页面
     *
     * @return
     */
    @RequestMapping(value = "view/list", method = RequestMethod.GET)
    public String viewList() {
        return "income/list";
    }


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
    @RequestMapping(value = "selectPage", method = RequestMethod.GET)
    @ResponseBody
    public FimsPage<SysIncomeModel> selectPage(
            @ApiParam(name = "收入信息实体类", required = true)
                    SysIncomeQueryModel sysIncomeQueryModel) {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_SELECT_PAGE);
        FimsPage<SysIncomeModel> page = sysIncomeService.selectPage(sysIncomeQueryModel);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_SELECT_PAGE);
        return page;
    }

    /**
     * 删除收入信息
     *
     * @param sysIncomeQueryModelList
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultData delete(
            @ApiParam(name = "收入信息实体类", required = true)
            @RequestBody List<SysIncomeQueryModel> sysIncomeQueryModelList) {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_DELETE);
        ResultData resultData = sysIncomeService.delete(sysIncomeQueryModelList);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_DELETE);
        return resultData;
    }
}
