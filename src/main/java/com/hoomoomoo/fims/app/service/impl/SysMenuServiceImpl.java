package com.hoomoomoo.fims.app.service.impl;

import com.hoomoomoo.fims.app.dao.SysMenuDao;
import com.hoomoomoo.fims.app.model.SysMenuTreeModel;
import com.hoomoomoo.fims.app.model.SysMenuTreeQueryModel;
import com.hoomoomoo.fims.app.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hoomoomoo.fims.app.consts.BusinessConst.WELL;

/**
 * @author humm23693
 * @description 菜单信息服务实现类
 * @package com.hoomoomoo.fims.app.service.impl
 * @date 2019/09/29
 */

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuDao sysMenuDao;

    /**
     * 查询菜单树
     *
     * @param roleId
     * @param disabled
     * @return
     */
    @Override
    public List<SysMenuTreeModel> selectMenuTree(String disabled, String roleId) {
        SysMenuTreeQueryModel sysMenuTreeQueryModel = new SysMenuTreeQueryModel();
        sysMenuTreeQueryModel.setIsParentId(true);
        sysMenuTreeQueryModel.setDisabled(disabled);
        sysMenuTreeQueryModel.setRoleId(roleId);
        // 获取父级菜单
        List<SysMenuTreeModel> sysMenuTreeModelList = sysMenuDao.selectMenuTree(sysMenuTreeQueryModel);
        // 获取子级菜单
        for(SysMenuTreeModel sysMenuTreeModel : sysMenuTreeModelList){
            getChildMenuTree(sysMenuTreeModel, sysMenuTreeQueryModel);
        }
        return sysMenuTreeModelList;
    }

    /**
     * 查询数据权限
     *
     * @param roleId
     * @return
     */
    @Override
    public String selectDataAuthority(String roleId) {
        SysMenuTreeQueryModel sysMenuTreeQueryModel = new SysMenuTreeQueryModel();
        sysMenuTreeQueryModel.setRoleId(roleId);
        return sysMenuDao.selectDataAuthority(sysMenuTreeQueryModel);
    }

    /**
     * 查询子菜单树
     *
     * @param sysMenuTreeModel
     * @param sysMenuTreeQueryModel
     */
    private void getChildMenuTree(SysMenuTreeModel sysMenuTreeModel, SysMenuTreeQueryModel sysMenuTreeQueryModel){
        sysMenuTreeQueryModel.setIsParentId(false);
        sysMenuTreeQueryModel.setParentId(sysMenuTreeModel.getId());
        List<SysMenuTreeModel> sysMenuTreeModelList = sysMenuDao.selectMenuTree(sysMenuTreeQueryModel);
        sysMenuTreeModel.setChildren(sysMenuTreeModelList);
        for(SysMenuTreeModel subSysMenuTreeModel: sysMenuTreeModelList){
            if(WELL.equals(subSysMenuTreeModel.getHref())){
                getChildMenuTree(subSysMenuTreeModel, sysMenuTreeQueryModel);
            }
        }
    }

}
