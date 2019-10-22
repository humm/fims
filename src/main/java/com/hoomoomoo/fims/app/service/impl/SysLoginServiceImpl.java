package com.hoomoomoo.fims.app.service.impl;

import com.hoomoomoo.fims.app.dao.SysUserDao;
import com.hoomoomoo.fims.app.model.SysLoginLogModel;
import com.hoomoomoo.fims.app.model.SysUserModel;
import com.hoomoomoo.fims.app.model.SysUserQueryModel;
import com.hoomoomoo.fims.app.model.common.ResultData;
import com.hoomoomoo.fims.app.model.common.SessionBean;
import com.hoomoomoo.fims.app.service.SysLoginLogService;
import com.hoomoomoo.fims.app.service.SysLoginService;
import com.hoomoomoo.fims.app.service.SysMenuService;
import com.hoomoomoo.fims.app.service.SysSystemService;
import com.hoomoomoo.fims.app.util.LogUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

import static com.hoomoomoo.fims.app.consts.BusinessConst.*;
import static com.hoomoomoo.fims.app.consts.CueConst.*;
import static com.hoomoomoo.fims.app.consts.DictionaryConst.D002;
import static com.hoomoomoo.fims.app.consts.TipConst.*;

/**
 * @author humm23693
 * @description 用户登录服务实现类
 * @package com.hoomoomoo.fims.app.service.impl
 * @date 2019/10/14
 */

@Service
@Transactional
public class SysLoginServiceImpl implements SysLoginService {

    private static final Logger logger = LoggerFactory.getLogger(SysLoginServiceImpl.class);

    @Autowired
    private SysUserDao SysUserDao;

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysSystemService sysSystemService;

    @Autowired
    private SysLoginLogService sysLoginLogService;

    /**
     * 用户登录
     *
     * @param sysUserModel
     * @return
     */
    @Override
    public ResultData login(HttpServletRequest request, SysUserModel sysUserModel) {
        ResultData resultData = null;
        LogUtils.serviceStart(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_SELECT);
        LogUtils.parameter(logger, sysUserModel);
        SysUserQueryModel sysUserQueryModel = new SysUserQueryModel();
        SysLoginLogModel sysLoginLogModel= new SysLoginLogModel();
        sysLoginLogModel.setLogId(sysSystemService.getBusinessSerialNo(BUSINESS_TYPE_LOGIN_LOG));
        sysLoginLogModel.setLoginDate(new Date());
        sysUserQueryModel.setUserCode(sysUserModel.getUserCode());
        List<SysUserModel> sysUserModelList = SysUserDao.selectSysUser(sysUserQueryModel);
        if (CollectionUtils.isEmpty(sysUserModelList)) {
            // 用户不存在
            resultData = new ResultData(false, USER_LOGON_ACCOUNT_NOT_EXIST, USER_LOGON_ACCOUNT_NOT_EXIST);
            sysLoginLogModel.setUserId(sysUserModel.getUserCode());
            sysLoginLogModel.setLoginStatus(new StringBuffer(D002).append(MINUS).append(STR_2).toString());
            sysLoginLogModel.setLoginMessage(USER_LOGON_ACCOUNT_NOT_EXIST);
        } else {
            SysUserModel sysUser = sysUserModelList.get(0);
            sysLoginLogModel.setUserId(sysUser.getUserId());
            boolean flag = true;
            // 用户已冻结
            if (USER_STATUS_FREEZE.equals(sysUser.getUserStatus())) {
                flag = false;
                resultData = new ResultData(false, USER_LOGON_ACCOUNT_FREEZE, USER_LOGON_ACCOUNT_FREEZE);
                sysLoginLogModel.setLoginStatus(new StringBuffer(D002).append(MINUS).append(STR_2).toString());
                sysLoginLogModel.setLoginMessage(USER_LOGON_ACCOUNT_FREEZE);
            }
            String inputPassword = sysUserModel.getUserPassword();
            String savePassword = new StringBuffer(sysUser.getUserPassword()).reverse().toString();
            if (flag && inputPassword.equals(savePassword)) {
                // 登录成功
                HttpSession session = request.getSession();
                session.setAttribute(SESSION_BEAN, setSessionBeanInfo(sysUser));
                resultData = new ResultData(true, USER_LOGON_SUCCESS, USER_LOGON_SUCCESS);
                sysLoginLogModel.setLoginStatus(new StringBuffer(D002).append(MINUS).append(STR_1).toString());
                sysLoginLogModel.setLoginMessage(USER_LOGON_SUCCESS);
            } else if (flag) {
                // 密码错误
                resultData = new ResultData(false, USER_LOGON_PASSWORD_ERROR, USER_LOGON_PASSWORD_ERROR);
                sysLoginLogModel.setLoginStatus(new StringBuffer(D002).append(MINUS).append(STR_2).toString());
                sysLoginLogModel.setLoginMessage(USER_LOGON_PASSWORD_ERROR);
            }
        }
        sysLoginLogService.save(sysLoginLogModel);
        LogUtils.serviceEnd(logger, LOG_BUSINESS_TYPE_USER, LOG_OPERATE_TYPE_SELECT);
        return resultData;
    }

    /**
     * 登出
     *
     * @param request
     * @param sessionStatus
     * @param sysUserModel
     * @return
     */
    @Override
    public ResultData logout(HttpServletRequest request, SessionStatus sessionStatus, SysUserModel sysUserModel) {
        ResultData resultData = null;
        SysUserQueryModel sysUserQueryModel = new SysUserQueryModel();
        sysUserQueryModel.setUserCode(sysUserModel.getUserCode());
        List<SysUserModel> sysUserModelList = SysUserDao.selectSysUser(sysUserQueryModel);
        if (CollectionUtils.isEmpty(sysUserModelList)) {
            // 用户不存在
            resultData = new ResultData(false, USER_LOGON_ACCOUNT_NOT_EXIST, USER_LOGON_ACCOUNT_NOT_EXIST);
        } else {
            // 更新登录日志
            SysUserModel sysUser = sysUserModelList.get(0);
            SysLoginLogModel sysLoginLogModel= new SysLoginLogModel();
            sysLoginLogModel.setUserId(sysUser.getUserId());
            sysLoginLogModel.setLogoutDate(new Date());
            sysLoginLogService.update(sysLoginLogModel);

            // 清除session
            sessionStatus.setComplete();
            request.getSession().removeAttribute(SESSION_BEAN);
            resultData = new ResultData(true, USER_LOGOUT_SUCCESS, USER_LOGOUT_SUCCESS);
        }
        return resultData;
    }

    /**
     * 设置sessionBean信息
     *
     * @param sysUserModel
     * @return
     */
    private SessionBean setSessionBeanInfo(SysUserModel sysUserModel) {
        SessionBean sessionBean = new SessionBean();
        sessionBean.setUserId(sysUserModel.getUserId());
        sessionBean.setUserCode(sysUserModel.getUserCode());
        sessionBean.setUserName(sysUserModel.getUserName());
        sessionBean.setUserStatus(sysUserModel.getUserStatus());
        if (ADMIN_CODE.equals(sysUserModel.getUserCode())) {
            sessionBean.setIsAdminData(true);
        } else {
            sessionBean.setIsAdminData(sysMenuService.selectDataAuthorityByUserId(sysUserModel.getUserId()));
        }
        return sessionBean;
    }
}
