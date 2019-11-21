package com.hoomoomoo.fims.app.controller;

import com.hoomoomoo.fims.app.model.SysGiftModel;
import com.hoomoomoo.fims.app.model.SysGiftQueryModel;
import com.hoomoomoo.fims.app.model.common.FimsPage;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.service.SysGiftService;
import com.hoomoomoo.fims.app.service.SysSystemService;
import com.hoomoomoo.fims.app.util.SysLogUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.hoomoomoo.fims.app.consts.BusinessConst.HAS_BUTTON;
import static com.hoomoomoo.fims.app.consts.TipConst.*;

/**
 * @author humm23693
 * @description 随礼信息控制类
 * @package com.hoomoomoo.fims.app.controller
 * @date 2019/09/07
 */

@Controller
@RequestMapping("/gift")
public class SysGiftController {

    private static final Logger logger = LoggerFactory.getLogger(SysGiftController.class);

    @Autowired
    private SysGiftService sysGiftService;

    @Autowired
    private SysSystemService sysSystemService;

    /**
     * 跳转列表页面
     *
     * @return
     */
    @ApiOperation("跳转列表页面")
    @RequestMapping(value = "view/list", method = RequestMethod.GET)
    public String viewList(ModelMap modelMap,
                           @ApiParam(value = "菜单ID", required = true)
                           @RequestParam String menuId) {
        modelMap.addAttribute(HAS_BUTTON, sysSystemService.selectButtonAuthority(menuId));
        return "gift/list";
    }


    /**
     * 跳转详情页面
     *
     * @return
     */
    @ApiOperation("跳转详情页面")
    @RequestMapping(value = "view/detail", method = RequestMethod.GET)
    public String viewDetail() {
        return "gift/detail";
    }

    /**
     * 跳转新增页面
     *
     * @return
     */
    @ApiOperation("跳转新增页面")
    @RequestMapping(value = "view/add", method = RequestMethod.GET)
    public String viewAdd() {
        return "gift/add";
    }

    /**
     * 跳转修改页面
     *
     * @return
     */
    @ApiOperation("跳转修改页面")
    @RequestMapping(value = "view/update", method = RequestMethod.GET)
    public String viewUpdate() {
        return "gift/update";
    }

    /**
     * 分页查询随礼信息
     *
     * @param sysGiftQueryModel
     * @return
     */
    @ApiOperation("分页查询随礼信息")
    @RequestMapping(value = "selectPage", method = RequestMethod.GET)
    @ResponseBody
    public FimsPage<SysGiftModel> selectPage(SysGiftQueryModel sysGiftQueryModel) {
        SysLogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_GIFT, LOG_OPERATE_TYPE_SELECT_PAGE);
        FimsPage<SysGiftModel> sysGiftModelFimsPage = sysGiftService.selectPage(sysGiftQueryModel);
        SysLogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_GIFT, LOG_OPERATE_TYPE_SELECT_PAGE);
        return sysGiftModelFimsPage;
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
        SysLogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_GIFT, LOG_OPERATE_TYPE_SELECT_INIT);
        ResultData resultData = sysGiftService.selectInitData();
        SysLogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_GIFT, LOG_OPERATE_TYPE_SELECT_INIT);
        return resultData;
    }

    /**
     * 删除随礼信息
     *
     * @param giftIds
     * @return
     */
    @ApiOperation("删除随礼信息")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultData delete(
            @ApiParam(value = "随礼信息ID", required = true)
            @RequestParam String giftIds) {
        SysLogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_GIFT, LOG_OPERATE_TYPE_DELETE);
        ResultData resultData = sysGiftService.delete(giftIds);
        SysLogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_GIFT, LOG_OPERATE_TYPE_DELETE);
        return resultData;
    }

    /**
     * 查询随礼信息
     *
     * @param giftId
     * @return
     */
    @ApiOperation("查询随礼信息")
    @RequestMapping(value = "selectOne", method = RequestMethod.GET)
    @ResponseBody
    public ResultData selectOne(
            @ApiParam(value = "随礼信息ID", required = true)
            @RequestParam String giftId,
            @ApiParam(value = "是否翻译", required = true)
            @RequestParam Boolean isTranslate) {
        SysLogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_GIFT, LOG_OPERATE_TYPE_SELECT);
        ResultData resultData = sysGiftService.selectOne(giftId, isTranslate);
        SysLogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_GIFT, LOG_OPERATE_TYPE_SELECT);
        return resultData;
    }

    /**
     * 保存随礼信息
     *
     * @param sysIncomeModel
     * @return
     */
    @ApiOperation("保存随礼信息")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public ResultData save(SysGiftModel sysIncomeModel) {
        String operateType = sysIncomeModel.getGiftId() == null ? LOG_OPERATE_TYPE_ADD : LOG_OPERATE_TYPE_UPDATE;
        SysLogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_INCOME, operateType);
        ResultData resultData = sysGiftService.save(sysIncomeModel);
        SysLogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_INCOME, operateType);
        return resultData;
    }
}
