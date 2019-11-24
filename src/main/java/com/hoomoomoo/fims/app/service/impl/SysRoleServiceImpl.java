package com.hoomoomoo.fims.app.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hoomoomoo.fims.app.dao.SysRoleDao;
import com.hoomoomoo.fims.app.model.*;
import com.hoomoomoo.fims.app.model.common.FimsPage;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.model.common.ViewData;
import com.hoomoomoo.fims.app.service.SysMenuService;
import com.hoomoomoo.fims.app.service.SysRoleService;
import com.hoomoomoo.fims.app.service.SysSystemService;
import com.hoomoomoo.fims.app.util.SysLogUtils;
import com.hoomoomoo.fims.app.util.SystemUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.hoomoomoo.fims.app.consts.BusinessConst.*;
import static com.hoomoomoo.fims.app.consts.CueConst.*;
import static com.hoomoomoo.fims.app.consts.TipConst.*;

/**
 * @author humm23693
 * @description 角色信息服务实现类
 * @package com.hoomoomoo.fims.app.service.impl
 * @date 2019/09/27
 */

@Service
public class SysRoleServiceImpl implements SysRoleService {

    private static final Logger logger = LoggerFactory.getLogger(SysRoleServiceImpl.class);

    @Autowired
    private SysRoleDao sysRoleDao;

    @Autowired
    private SysSystemService sysSystemService;

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 查询角色信息
     *
     * @param sysRoleQueryModel
     * @return
     */
    @Override
    public List<SysRoleModel> selectSysRole(SysRoleQueryModel sysRoleQueryModel) {
        SysLogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_ROLE, LOG_OPERATE_TYPE_SELECT);
        SystemUtils.setSessionInfo(sysRoleQueryModel);
        SysLogUtils.parameter(logger, sysRoleQueryModel);
        List<SysRoleModel> sysRoleModelList = sysRoleDao.selectSysRole(sysRoleQueryModel);
        SysLogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_ROLE, LOG_OPERATE_TYPE_SELECT);
        return sysRoleModelList;
    }

    /**
     * 查询页面初始化相关数据
     *
     * @param disabled
     * @param roleId
     * @return
     */
    @Override
    public ResultData selectInitData(String disabled, String roleId) {
        SysLogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_ROLE, LOG_OPERATE_TYPE_SELECT_INIT);
        ViewData viewData = new ViewData();
        // 设置查询条件
        viewData.setViewType(BUSINESS_TYPE_ROLE);
        sysSystemService.setCondition(viewData);
        // 设置菜单信息
        viewData.setMenuList(sysMenuService.selectMenuTree(disabled, roleId));
        // 设置数据权限信息
        viewData.setDataAuthority(sysMenuService.selectDataAuthority(roleId));
        SysLogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_ROLE, LOG_OPERATE_TYPE_SELECT_INIT);
        return new ResultData(true, SELECT_SUCCESS, viewData);
    }

    /**
     * 分页查询角色信息
     *
     * @param sysRoleQueryModel
     * @return
     */
    @Override
    public FimsPage<SysRoleModel> selectPage(SysRoleQueryModel sysRoleQueryModel) {
        SysLogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_ROLE, LOG_OPERATE_TYPE_SELECT_PAGE);
        SysLogUtils.parameter(logger, sysRoleQueryModel);
        PageHelper.startPage(sysRoleQueryModel.getPage(), sysRoleQueryModel.getLimit());
        List<SysRoleModel> sysRoleModelList = sysRoleDao.selectPage(sysRoleQueryModel);
        // 创建PageInfo对象前 不能处理数据否则getTotal数据不正确
        PageInfo<SysRoleModel> pageInfo = new PageInfo<>(sysRoleModelList);
        SysLogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_ROLE, LOG_OPERATE_TYPE_SELECT_PAGE);
        return new FimsPage(pageInfo.getTotal(), sysSystemService.transferData(pageInfo.getList(), SysRoleModel.class));

    }

    /**
     * 删除角色信息
     *
     * @param roleIds
     * @return
     */
    @Override
    public ResultData delete(String roleIds) {
        SysLogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_ROLE, LOG_OPERATE_TYPE_DELETE);
        List<SysRoleModel> list = new ArrayList<>();
        if (StringUtils.isNotBlank(roleIds)) {
            String[] roleId = roleIds.split(COMMA);
            for (String ele : roleId) {
                SysRoleModel sysRoleModel = new SysRoleModel();
                sysRoleModel.setRoleId(ele);
                list.add(sysRoleModel);
            }
            sysRoleDao.delete(list);
        }
        SysLogUtils.parameter(logger, list);
        SysLogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_ROLE, LOG_OPERATE_TYPE_DELETE);
        return new ResultData(true, DELETE_SUCCESS, null);
    }

    /**
     * 查询角色信息
     *
     * @param roleId
     * @param isTranslate
     * @return
     */
    @Override
    public ResultData selectOne(String roleId, Boolean isTranslate) {
        SysLogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_ROLE, LOG_OPERATE_TYPE_SELECT);
        SysRoleQueryModel sysRoleQueryModel = new SysRoleQueryModel();
        sysRoleQueryModel.setRoleId(roleId);
        SysLogUtils.parameter(logger, sysRoleQueryModel);
        SysRoleModel sysRoleModel = sysRoleDao.selectOne(sysRoleQueryModel);
        if (isTranslate) {
            sysSystemService.transferData(sysRoleModel, SysRoleModel.class);
        }
        SysLogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_ROLE, LOG_OPERATE_TYPE_SELECT);
        return new ResultData(true, SELECT_SUCCESS, sysRoleModel);
    }

    /**
     * 保存角色信息
     *
     * @param sysRoleModel
     * @return
     */
    @Override
    public ResultData save(SysRoleModel sysRoleModel) {
        String operateType = sysRoleModel.getRoleId() == null ? LOG_OPERATE_TYPE_ADD : LOG_OPERATE_TYPE_UPDATE;
        String tipMsg = sysRoleModel.getRoleId() == null ? ADD_SUCCESS : UPDATE_SUCCESS;
        SysLogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_ROLE, operateType);
        SystemUtils.setCreateUserInfo(sysRoleModel);
        if (sysRoleModel.getRoleId() == null) {
            // 新增
            String roleId = sysSystemService.getBusinessSerialNo(BUSINESS_TYPE_ROLE);
            sysRoleModel.setRoleId(roleId);
        } else {
            // 修改
        }
        // 处理角色菜单信息
        SysRoleMenuModel sysRoleMenuModel = new SysRoleMenuModel();
        sysRoleMenuModel.setRoleId(sysRoleModel.getRoleId());
        sysRoleDao.deleteRoleMenu(sysRoleMenuModel);
        String menuIds = sysRoleModel.getMenuId();
        if(StringUtils.isNotBlank(menuIds)){
            for(String menuId : menuIds.split(COMMA)){
                sysRoleMenuModel.setMenuId(menuId);
                sysRoleMenuModel.setRoleMenuId(sysSystemService.getBusinessSerialNo(BUSINESS_TYPE_ROLE_MENU));
                sysRoleDao.saveRoleMenu(sysRoleMenuModel);
            }
        }
        // 处理数据权限信息
        if(SWITCH_ON.equals(sysRoleModel.getDataAuthority())){
            sysRoleMenuModel.setMenuId(DATA_AUTHORITY_ID);
            sysRoleMenuModel.setRoleMenuId(sysSystemService.getBusinessSerialNo(BUSINESS_TYPE_ROLE_MENU));
            sysRoleDao.saveRoleMenu(sysRoleMenuModel);
        }
        SysLogUtils.parameter(logger, sysRoleModel);
        sysRoleDao.save(sysRoleModel);
        // 加载字典项
        sysSystemService.loadSysDictionaryCondition();
        SysLogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_ROLE, operateType);
        return new ResultData(true, tipMsg, null);
    }

    /**
     * 校验roleCode是否存在
     *
     * @param sysRoleQueryModel
     * @return
     */
    @Override
    public ResultData checkRoleCode(SysRoleQueryModel sysRoleQueryModel) {
        SysLogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_ROLE, LOG_OPERATE_TYPE_CHECK);
        Boolean isExist = sysRoleDao.checkRoleCode(sysRoleQueryModel);
        SysLogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_ROLE, LOG_OPERATE_TYPE_CHECK);
        return new ResultData(true, SELECT_SUCCESS, isExist);
    }

}