package com.hoomoomoo.fims.app.controller;

import com.hoomoomoo.fims.app.dto.common.Page;
import com.hoomoomoo.fims.app.dto.common.ResultData;
import com.hoomoomoo.fims.app.dto.SysSalaryQueryDto;
import com.hoomoomoo.fims.app.service.SysSalaryService;
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
@RequestMapping("/salary")
public class SysSalaryController {

    private static final Logger logger = LoggerFactory.getLogger(SysSalaryController.class);

    @Autowired
    private SysSalaryService sysSalaryService;

    /**
     * 跳转列表查询页面
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String viewList() {
        return "salary/list";
    }

    /**
     * 分页查询
     *
     * @param sysSalaryQueryDto
     * @return
     */
    @RequestMapping(value = "selectPage", method = RequestMethod.GET)
    @ResponseBody
    public Page<SysSalaryQueryDto> selectPage(
            @ApiParam(name = "收入信息查询实体类", required = true)
            SysSalaryQueryDto sysSalaryQueryDto) {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_SALARY, LOG_OPERATE_TYPE_SELECT_PAGE);
        Page<SysSalaryQueryDto> page = sysSalaryService.selectPage(sysSalaryQueryDto);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_SALARY, LOG_OPERATE_TYPE_SELECT_PAGE);
        return page;
    }
}
