package com.hoomoomoo.fims.app.controller;

import com.hoomoomoo.fims.app.model.SysIncomeModel;
import com.hoomoomoo.fims.app.model.SysIncomeQueryModel;
import com.hoomoomoo.fims.app.model.common.Page;
import com.hoomoomoo.fims.app.service.SysIncomeService;
import com.hoomoomoo.fims.app.util.LogUtils;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * 分页查询
     *
     * @param sysIncomeQueryModel
     * @return
     */
    @RequestMapping(value = "selectPage", method = RequestMethod.GET)
    @ResponseBody
    public Page<SysIncomeModel> selectPage(
            @ApiParam(name = "收入信息查询实体类", required = true) SysIncomeQueryModel sysIncomeQueryModel) {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_SELECT_PAGE);
        Page<SysIncomeModel> page = sysIncomeService.selectPage(sysIncomeQueryModel);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_INCOME, LOG_OPERATE_TYPE_SELECT_PAGE);
        return page;
    }
}
