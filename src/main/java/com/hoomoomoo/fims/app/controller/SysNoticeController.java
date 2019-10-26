package com.hoomoomoo.fims.app.controller;

import com.hoomoomoo.fims.app.model.SysNoticeModel;
import com.hoomoomoo.fims.app.model.SysNoticeQueryModel;
import com.hoomoomoo.fims.app.model.common.FimsPage;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.service.SysNoticeService;
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
 * @description 消息通知控制类
 * @package com.hoomoomoo.fims.app.controller
 * @date 2019/10/26
 */

@Controller
@RequestMapping("/notice")
public class SysNoticeController {

    private static final Logger logger = LoggerFactory.getLogger(SysNoticeController.class);
    
    @Autowired
    private SysNoticeService sysNoticeService;

    /**
     * 跳转列表页面
     *
     * @return
     */
    @ApiOperation("跳转列表页面")
    @RequestMapping(value = "view/list", method = RequestMethod.GET)
    public String viewList(@ApiParam(value = "菜单ID", required = true)
                           @RequestParam String menuId) {
        return "notice/list";
    }

    /**
     * 跳转详情页面
     *
     * @return
     */
    @ApiOperation("跳转详情页面")
    @RequestMapping(value = "view/detail", method = RequestMethod.GET)
    public String viewDetail() {
        return "notice/detail";
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
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_SELECT_INIT);
        ResultData resultData = sysNoticeService.selectInitData();
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_SELECT_INIT);
        return resultData;
    }

    /**
     * 分页查询消息通知信息
     *
     * @param sysNoticeQueryModel
     * @return
     */
    @ApiOperation("分页查询消息通知信息")
    @RequestMapping(value = "selectPage", method = RequestMethod.GET)
    @ResponseBody
    public FimsPage<SysNoticeModel> selectPage(SysNoticeQueryModel sysNoticeQueryModel) {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_SELECT_PAGE);
        FimsPage fimsPage = sysNoticeService.selectPage(sysNoticeQueryModel);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_SELECT_PAGE);
        return fimsPage;
    }

    /**
     * 查询消息通知信息
     *
     * @param noticeId
     * @return
     */
    @ApiOperation("查询消息通知信息")
    @RequestMapping(value = "selectOne", method = RequestMethod.GET)
    @ResponseBody
    public ResultData selectOne(
            @ApiParam(value = "消息通知信息ID", required = true)
            @RequestParam String noticeId,
            @ApiParam(value = "是否翻译", required = true)
            @RequestParam Boolean isTranslate) {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_SELECT);
        ResultData resultData = sysNoticeService.selectOne(noticeId, isTranslate);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_SELECT);
        return resultData;
    }
}
