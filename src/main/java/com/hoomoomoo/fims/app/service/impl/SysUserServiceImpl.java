package com.hoomoomoo.fims.app.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hoomoomoo.fims.app.dao.SysDictionaryDao;
import com.hoomoomoo.fims.app.dao.SysRoleDao;
import com.hoomoomoo.fims.app.dao.SysUserDao;
import com.hoomoomoo.fims.app.model.*;
import com.hoomoomoo.fims.app.model.common.FimsPage;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.model.common.ViewData;
import com.hoomoomoo.fims.app.service.SysNoticeService;
import com.hoomoomoo.fims.app.service.SysUserService;
import com.hoomoomoo.fims.app.service.SystemService;
import com.hoomoomoo.fims.app.util.LogUtils;
import com.hoomoomoo.fims.app.util.SystemUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.hoomoomoo.fims.app.consts.BusinessConst.*;
import static com.hoomoomoo.fims.app.consts.CueConst.*;
import static com.hoomoomoo.fims.app.consts.DictionaryConst.D009;
import static com.hoomoomoo.fims.app.consts.TipConst.*;

/**
 * @author humm23693
 * @description 用户信息服务实现类
 * @package com.hoomoomoo.fims.app.service.impl
 * @date 2019/08/11
 */

@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {

    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SystemService systemService;

    @Autowired
    private SysDictionaryDao sysDictionaryDao;

    @Autowired
    private SysRoleDao sysRoleDao;

    /**
     * 查询用户信息
     *
     * @param sysUserQueryModel
     * @return
     */
    @Override
    public List<SysUserModel> selectSysUser(SysUserQueryModel sysUserQueryModel) {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_SELECT);
        SystemUtils.setSessionInfo(sysUserQueryModel);
        LogUtils.parameter(logger, sysUserQueryModel);
        List<SysUserModel> sysUserList = sysUserDao.selectSysUser(sysUserQueryModel);
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_SELECT);
        return sysUserList;
    }

    /**
     * 查询页面初始化相关数据
     *
     * @return
     */
    @Override
    public ResultData selectInitData() {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_SELECT_INIT);
        ViewData viewData = new ViewData();
        // 设置查询条件
        viewData.setViewType(BUSINESS_TYPE_USER);
        systemService.setCondition(viewData);
        // 获取角色信息
        List<SysRoleModel> roleModelList = sysRoleDao.selectSysRole(null);
        viewData.setRoleList(roleModelList);
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_SELECT_INIT);
        return new ResultData(true, SELECT_SUCCESS, viewData);
    }

    /**
     * 分页查询用户信息
     *
     * @param sysUserQueryModel
     * @return
     */
    @Override
    public FimsPage<SysUserModel> selectPage(SysUserQueryModel sysUserQueryModel) {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_SELECT_PAGE);
        SystemUtils.setSessionInfo(sysUserQueryModel);
        LogUtils.parameter(logger, sysUserQueryModel);
        PageHelper.startPage(sysUserQueryModel.getPage(), sysUserQueryModel.getLimit());
        List<SysUserModel> sysUserModelList = sysUserDao.selectPage(sysUserQueryModel);
        // 创建PageInfo对象前 不能处理数据否则getTotal数据不正确
        PageInfo<SysUserModel> pageInfo = new PageInfo<>(sysUserModelList);
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_SELECT_PAGE);
        return new FimsPage(pageInfo.getTotal(), systemService.transferData(pageInfo.getList(), SysUserModel.class));
    }

    /**
     * 删除用户信息
     *
     * @param userIds
     * @return
     */
    @Override
    public ResultData delete(String userIds) {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_DELETE);
        List<SysUserModel> list = new ArrayList<>();
        if (StringUtils.isNotBlank(userIds)) {
            String[] userId = userIds.split(COMMA);
            for (String ele : userId) {
                SysUserModel sysUserModel = new SysUserModel();
                sysUserModel.setUserId(ele);
                list.add(sysUserModel);
                // 删除字典项
                SysDictionaryModel sysDictionaryModel = new SysDictionaryModel();
                sysDictionaryModel.setDictionaryCode(D009);
                sysDictionaryModel.setDictionaryItem(ele);
                sysDictionaryDao.delete(sysDictionaryModel);
            }
            sysUserDao.delete(list);
        }
        // 加载字典项
        systemService.loadSysDictionaryCondition();
        LogUtils.parameter(logger, list);
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_DELETE);
        return new ResultData(true, LOG_BUSINESS_TYPE_USER, null);

    }

    /**
     * 查询用户信息
     *
     * @param userId
     * @param isTranslate
     * @return
     */
    @Override
    public ResultData selectOne(String userId, Boolean isTranslate) {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_SELECT);
        SysUserQueryModel sysUserQueryModel = new SysUserQueryModel();
        sysUserQueryModel.setUserId(userId);
        LogUtils.parameter(logger, sysUserQueryModel);
        SysUserModel sysUserModel = sysUserDao.selectOne(sysUserQueryModel);
        if (isTranslate) {
            systemService.transferData(sysUserModel, SysUserModel.class);
        }
        // 查询用户角色信息
        List<SysUserRoleModel> sysUserRoleModelList = sysUserDao.selectUserRole(sysUserQueryModel);
        String[] roles = new String[sysUserRoleModelList.size()];
        for(int i=0; i<sysUserRoleModelList.size(); i++){
            roles[i] = sysUserRoleModelList.get(i).getRoleId();
        }
        sysUserModel.setRoleId(StringUtils.join(roles, COMMA));
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_SELECT);
        return new ResultData(true, SELECT_SUCCESS, sysUserModel);
    }

    /**
     * 保存用户信息
     *
     * @param sysUserModel
     * @return
     */
    @Override
    public ResultData save(SysUserModel sysUserModel) {
        String operateType = sysUserModel.getUserId() == null ? LOG_OPERATE_TYPE_ADD : LOG_OPERATE_TYPE_UPDATE;
        String tipMsg = sysUserModel.getUserId() == null ? ADD_SUCCESS : UPDATE_SUCCESS;
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_USER, operateType);
        SystemUtils.setCreateUserInfo(sysUserModel);
        SysDictionaryModel sysDictionaryModel = new SysDictionaryModel();
        sysDictionaryModel.setDictionaryCode(D009);
        sysDictionaryModel.setDictionaryCaption(sysUserModel.getUserName());
        if (sysUserModel.getUserId() == null) {
            // 新增
            String userId = systemService.getBusinessSerialNo(BUSINESS_TYPE_USER);
            sysUserModel.setUserId(userId);
            // todo 设置配置默认密码 加密存储
            sysUserModel.setUserPassword("123456");
            // 新增字典项
            sysDictionaryModel.setDictionaryItem(userId);
            sysDictionaryModel.setUserId(userId);
            sysDictionaryDao.save(sysDictionaryModel);
        } else {
            // 修改字典项
            sysDictionaryModel.setUserId(sysUserModel.getUserId());
            sysDictionaryModel.setDictionaryItem(sysUserModel.getUserId());
            sysDictionaryDao.update(sysDictionaryModel);
        }
        LogUtils.parameter(logger, sysUserModel);
        sysUserDao.save(sysUserModel);
        // 加载字典项
        systemService.loadSysDictionaryCondition();
        // 角色信息处理
        sysUserDao.deleteUserRole(sysUserModel);
        if(StringUtils.isNotBlank(sysUserModel.getRoleId())){
            String[] roleId = sysUserModel.getRoleId().split(COMMA);
            for(String ele : roleId){
                SysUserRoleModel sysUserRoleModel = new SysUserRoleModel();
                String userRoleId = systemService.getBusinessSerialNo(BUSINESS_TYPE_USER_ROLE);
                sysUserRoleModel.setUserRoleId(userRoleId);
                sysUserRoleModel.setUserId(sysUserModel.getUserId());
                sysUserRoleModel.setRoleId(ele);
                sysUserDao.saveUserRole(sysUserRoleModel);
            }
        }
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_USER, operateType);
        return new ResultData(true, tipMsg, null);
    }

    /**
     * 校验userCode是否存在
     *
     * @param sysUserQueryModel
     * @return
     */
    @Override
    public ResultData checkUserCode(SysUserQueryModel sysUserQueryModel) {
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_CHECK);
        Boolean isExist = sysUserDao.checkUserCode(sysUserQueryModel);
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_CHECK);
        return new ResultData(true, SELECT_SUCCESS, isExist);
    }

}
