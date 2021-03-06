package com.hoomoomoo.fims.test;

import com.hoomoomoo.fims.app.model.SysGiftModel;
import com.hoomoomoo.fims.app.model.SysGiftQueryModel;
import com.hoomoomoo.fims.app.model.SysMenuTreeModel;
import com.hoomoomoo.fims.app.model.common.SessionBean;
import com.hoomoomoo.fims.app.service.SysMenuService;
import com.hoomoomoo.fims.app.service.SysSqlService;
import com.hoomoomoo.fims.app.util.SysSessionUtils;
import com.hoomoomoo.fims.app.util.SysCommonUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.hoomoomoo.fims.app.config.RunDataConfig.CONFIG_SQL;

/**
 * @author hoomoomoo
 * @description 测试控制类
 * @package com.hoomoomoo.fims.test.controller
 * @date 2019/08/08
 */

@RequestMapping("/test/")
@RestController
public class TestController {

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysSqlService sysSqlService;

    @ApiOperation("Session信息")
    @RequestMapping(value = "sessionBean", method = RequestMethod.POST)
    public SessionBean testSessionBean() {
        return SysSessionUtils.getSession();
    }

    @ApiOperation("菜单信息")
    @RequestMapping(value = "menu", method = RequestMethod.GET)
    public List<SysMenuTreeModel> selectMenuTree(String disabled, String roleId){
        return sysMenuService.selectMenuTree(disabled, roleId);
    }

    @ApiOperation("配置sql查询")
    @RequestMapping(value = "selectPage", method = RequestMethod.GET)
    public List selectPage(SysGiftQueryModel sysGiftQueryModel){
        List<SysGiftModel> list = sysSqlService.execute(CONFIG_SQL.get("sysGift-selectPage"), sysGiftQueryModel);
        return list;
    }

    @ApiOperation("配置sql删除")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public void delete(){
        List<SysGiftModel> list = new ArrayList<>();
        SysGiftModel sysGiftModel = new SysGiftModel();
        sysGiftModel.setGiftId("156");
        list.add(sysGiftModel);
        sysSqlService.execute(CONFIG_SQL.get("sysGift-delete"), list);
    }

    @ApiOperation("配置sql新增")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public void add(SysGiftModel sysGiftModel){
        SysCommonUtils.setCreateUserInfo(sysGiftModel);
        sysSqlService.execute(CONFIG_SQL.get("sysGift-add"), sysGiftModel);
    }

    @ApiOperation("配置sql修改")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void update(SysGiftModel sysGiftModel){
        SysCommonUtils.setCreateUserInfo(sysGiftModel);
        sysSqlService.execute(CONFIG_SQL.get("sysGift-update"), sysGiftModel);
    }
}
