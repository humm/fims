package com.hoomoomoo.fims.app.controller;

import com.hoomoomoo.fims.app.config.bean.SystemConfigBean;
import com.hoomoomoo.fims.app.model.SysNoticeModel;
import com.hoomoomoo.fims.app.model.SysNoticeQueryModel;
import com.hoomoomoo.fims.app.model.common.FimsPage;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.service.SysNoticeService;
import com.hoomoomoo.fims.app.util.SysLogUtils;
import com.hoomoomoo.fims.app.util.SysCommonUtils;
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

import javax.servlet.http.HttpServletRequest;

import static com.hoomoomoo.fims.app.consts.BusinessConst.REQUEST_URL;
import static com.hoomoomoo.fims.app.consts.CueConst.*;

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

    @Autowired
    private SystemConfigBean systemConfigBean;

    /**
     * 跳转列表页面
     *
     * @return
     */
    @ApiOperation("跳转列表页面")
    @RequestMapping(value = "view/list", method = RequestMethod.GET)
    public String viewList(ModelMap modelMap, HttpServletRequest httpServletRequest) {
        modelMap.addAttribute(REQUEST_URL, SysCommonUtils.getConnectUrl(httpServletRequest, systemConfigBean.getAppName()));
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
        SysLogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_SELECT_INIT);
        ResultData resultData = sysNoticeService.selectInitData();
        SysLogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_SELECT_INIT);
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
        SysLogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_SELECT_PAGE);
        FimsPage fimsPage = sysNoticeService.selectPage(sysNoticeQueryModel);
        SysLogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_SELECT_PAGE);
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
        SysLogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_SELECT);
        ResultData resultData = sysNoticeService.selectOne(noticeId, isTranslate);
        SysLogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_SELECT);
        return resultData;
    }

    /**
     * 修改消息通知信息
     *
     * @param isAll
     * @param noticeIds
     * @return
     */
    @ApiOperation("修改消息通知信息")
    @RequestMapping(value = "updateReadStatus", method = RequestMethod.POST)
    @ResponseBody
    public ResultData selectOne(@ApiParam(value = "是否全部已读", required = false)String isAll,
                                @ApiParam(value = "通知消息ID", required = false)String noticeIds){
        SysLogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_UPDATE);
        ResultData resultData = sysNoticeService.updateReadStatus(isAll, noticeIds);
        SysLogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_NOTICE, LOG_OPERATE_TYPE_UPDATE);
        return resultData;
    }
}
