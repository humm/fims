package com.hoomoomoo.fims.app.controller;

import com.hoomoomoo.fims.app.model.SysRoleModel;
import com.hoomoomoo.fims.app.model.SysRoleQueryModel;
import com.hoomoomoo.fims.app.model.common.FimsPage;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.model.common.SessionBean;
import com.hoomoomoo.fims.app.service.SysRoleService;
import com.hoomoomoo.fims.app.service.SysSystemService;
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

/**
 * @author humm23693
 * @description 角色信息
 * @package com.hoomoomoo.fims.app.controller
 * @date 2019/09/27
 */

@Controller
@RequestMapping("/role")
public class SysRoleController {

    private static final Logger logger = LoggerFactory.getLogger(SysRoleController.class);

    @Autowired
    private SysRoleService sysRoleService;

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
        return "role/list";
    }


    /**
     * 跳转详情页面
     *
     * @return
     */
    @ApiOperation("跳转详情页面")
    @RequestMapping(value = "view/detail", method = RequestMethod.GET)
    public String viewDetail() {
        return "role/detail";
    }

    /**
     * 跳转新增页面
     *
     * @return
     */
    @ApiOperation("跳转新增页面")
    @RequestMapping(value = "view/add", method = RequestMethod.GET)
    public String viewAdd() {
        return "role/add";
    }

    /**
     * 跳转修改页面
     *
     * @return
     */
    @ApiOperation("跳转修改页面")
    @RequestMapping(value = "view/update", method = RequestMethod.GET)
    public String viewUpdate() {
        return "role/update";
    }


    /**
     * 分页查询角色信息
     *
     * @param sysRoleQueryModel
     * @return
     */
    @ApiOperation("分页查询角色信息")
    @RequestMapping(value = "selectPage", method = RequestMethod.GET)
    @ResponseBody
    public FimsPage<SysRoleModel> selectPage(SysRoleQueryModel sysRoleQueryModel) {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_ROLE, LOG_OPERATE_TYPE_SELECT_PAGE);
        FimsPage<SysRoleModel> page = sysRoleService.selectPage(sysRoleQueryModel);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_ROLE, LOG_OPERATE_TYPE_SELECT_PAGE);
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
    public ResultData selectInitData(@ApiParam(value = "是否禁用", required = false)
                                     @RequestParam(required = false) String disabled,
                                     @ApiParam(value = "角色信息ID", required = false)
                                     @RequestParam(required = false) String roleId) {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_ROLE, LOG_OPERATE_TYPE_SELECT_INIT);
        ResultData resultData = sysRoleService.selectInitData(disabled, roleId);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_ROLE, LOG_OPERATE_TYPE_SELECT_INIT);
        return resultData;
    }

    /**
     * 删除角色信息
     *
     * @param roleIds
     * @return
     */
    @ApiOperation("删除角色信息")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultData delete(
            @ApiParam(value = "角色信息ID", required = true)
            @RequestParam String roleIds) {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_ROLE, LOG_OPERATE_TYPE_DELETE);
        ResultData resultData = sysRoleService.delete(roleIds);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_ROLE, LOG_OPERATE_TYPE_DELETE);
        return resultData;
    }


    /**
     * 查询角色信息
     *
     * @param roleId
     * @return
     */
    @ApiOperation("查询角色信息")
    @RequestMapping(value = "selectOne", method = RequestMethod.GET)
    @ResponseBody
    public ResultData selectOne(
            @ApiParam(value = "角色信息ID", required = true)
            @RequestParam String roleId,
            @ApiParam(value = "是否翻译", required = true)
            @RequestParam Boolean isTranslate) {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_ROLE, LOG_OPERATE_TYPE_SELECT);
        ResultData resultData = sysRoleService.selectOne(roleId, isTranslate);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_ROLE, LOG_OPERATE_TYPE_SELECT);
        return resultData;
    }

    /**
     * 保存角色信息
     *
     * @param sysRoleModel
     * @return
     */
    @ApiOperation("保存角色信息")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public ResultData save(SysRoleModel sysRoleModel) {
        String operateType = sysRoleModel.getRoleId() == null ? LOG_OPERATE_TYPE_ADD : LOG_OPERATE_TYPE_UPDATE;
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_ROLE, operateType);
        ResultData resultData = sysRoleService.save(sysRoleModel);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_ROLE, operateType);
        return resultData;
    }

    /**
     * 校验角色信息
     *
     * @param sysRoleQueryModel
     * @return
     */
    @ApiOperation("校验角色信息")
    @RequestMapping(value = "checkRoleCode", method = RequestMethod.GET)
    @ResponseBody
    public ResultData checkRoleCode(SysRoleQueryModel sysRoleQueryModel) {
        LogUtils.controllerStart(logger, LOG_BUSINESS_TYPE_ROLE, LOG_OPERATE_TYPE_CHECK);
        ResultData resultData = sysRoleService.checkRoleCode(sysRoleQueryModel);
        LogUtils.controllerEnd(logger, LOG_BUSINESS_TYPE_ROLE, LOG_OPERATE_TYPE_CHECK);
        return resultData;
    }
}
