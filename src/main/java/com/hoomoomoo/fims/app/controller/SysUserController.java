package com.hoomoomoo.fims.app.controller;

import com.hoomoomoo.fims.app.model.SysUserModel;
import com.hoomoomoo.fims.app.model.SysUserQueryModel;
import com.hoomoomoo.fims.app.model.common.FimsPage;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.model.common.SessionBean;
import com.hoomoomoo.fims.app.service.SysUserService;
import com.hoomoomoo.fims.app.util.LogUtils;
import com.hoomoomoo.fims.app.util.SystemSessionUtils;
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
import static com.hoomoomoo.fims.app.consts.TipConst.LOG_BUSINESS_TYPE_USER;

/**
 * @author humm23693
 * @description 用户信息控制类
 * @package com.hoomoomoo.fims.app.controller
 * @date 2019/09/21
 */

@Controller
@RequestMapping("/user")
public class SysUserController {

    private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private SysUserService sysUserService;

    /**
     * 跳转列表页面
     *
     * @return
     */
    @ApiOperation("跳转列表页面")
    @RequestMapping(value = "view/list", method = RequestMethod.GET)
    public String viewList(ModelMap modelMap) {
        SessionBean sessionBean = SystemSessionUtils.getSession();
        if(sessionBean != null){
            // todo 获取按钮权限
            modelMap.addAttribute(HAS_BUTTON, true);
        }
        return "user/list";
    }


    /**
     * 跳转详情页面
     *
     * @return
     */
    @ApiOperation("跳转详情页面")
    @RequestMapping(value = "view/detail", method = RequestMethod.GET)
    public String viewDetail() {
        return "user/detail";
    }

    /**
     * 跳转新增页面
     *
     * @return
     */
    @ApiOperation("跳转新增页面")
    @RequestMapping(value = "view/add", method = RequestMethod.GET)
    public String viewAdd() {
        return "user/add";
    }

    /**
     * 跳转修改页面
     *
     * @return
     */
    @ApiOperation("跳转修改页面")
    @RequestMapping(value = "view/update", method = RequestMethod.GET)
    public String viewUpdate() {
        return "user/update";
    }


    /**
     * 分页查询用户信息
     *
     * @param sysUserQueryModel
     * @return
     */
    @ApiOperation("分页查询用户信息")
    @RequestMapping(value = "selectPage", method = RequestMethod.GET)
    @ResponseBody
    public FimsPage<SysUserModel> selectPage(SysUserQueryModel sysUserQueryModel) {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_SELECT_PAGE);
        FimsPage<SysUserModel> page = sysUserService.selectPage(sysUserQueryModel);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_SELECT_PAGE);
        return page;
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
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_SELECT_INIT);
        ResultData resultData = sysUserService.selectInitData();
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_SELECT_INIT);
        return resultData;
    }

    /**
     * 删除用户信息
     *
     * @param userIds
     * @return
     */
    @ApiOperation("删除用户信息")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultData delete(
            @ApiParam(value = "用户信息ID", required = true)
            @RequestParam String userIds) {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_DELETE);
        ResultData resultData = sysUserService.delete(userIds);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_DELETE);
        return resultData;
    }


    /**
     * 查询用户信息
     *
     * @param userId
     * @return
     */
    @ApiOperation("查询用户信息")
    @RequestMapping(value = "selectOne", method = RequestMethod.GET)
    @ResponseBody
    public ResultData selectOne(
            @ApiParam(value = "用户信息ID", required = true)
            @RequestParam String userId,
            @ApiParam(value = "是否翻译", required = true)
            @RequestParam Boolean isTranslate) {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_SELECT);
        ResultData resultData = sysUserService.selectOne(userId, isTranslate);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_SELECT);
        return resultData;
    }

    /**
     * 保存用户信息
     *
     * @param sysUserModel
     * @return
     */
    @ApiOperation("保存用户信息")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public ResultData save(SysUserModel sysUserModel) {
        String operateType = sysUserModel.getUserId() == null ? LOG_OPERATE_TYPE_ADD : LOG_OPERATE_TYPE_UPDATE;
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_USER, operateType);
        ResultData resultData = sysUserService.save(sysUserModel);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_USER, operateType);
        return resultData;
    }

    /**
     * 校验用户信息
     *
     * @param sysUserQueryModel
     * @return
     */
    @ApiOperation("校验用户信息")
    @RequestMapping(value = "checkUserCode", method = RequestMethod.GET)
    @ResponseBody
    public ResultData checkUserCode(SysUserQueryModel sysUserQueryModel) {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_CHECK);
        ResultData resultData = sysUserService.checkUserCode(sysUserQueryModel);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_CHECK);
        return resultData;
    }
}
