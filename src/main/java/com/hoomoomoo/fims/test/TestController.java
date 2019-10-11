package com.hoomoomoo.fims.test;

import com.hoomoomoo.fims.app.model.SysMenuTreeModel;
import com.hoomoomoo.fims.app.model.common.SessionBean;
import com.hoomoomoo.fims.app.service.SysMenuService;
import com.hoomoomoo.fims.app.util.SystemSessionUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author humm23693
 * @description 测试控制类
 * @package com.hoomoomoo.fims.test.controller
 * @date 2019/08/08
 */

@RequestMapping("/test/")
@RestController
public class TestController {

    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation("Session信息")
    @RequestMapping(value = "sessionBean", method = RequestMethod.POST)
    public SessionBean testSessionBean() {
        return SystemSessionUtils.getSession();
    }

    @ApiOperation("菜单信息")
    @RequestMapping(value = "menu", method = RequestMethod.GET)
    public List<SysMenuTreeModel> selectMenuTree(String disabled, String roleId){
        return sysMenuService.selectMenuTree(disabled, roleId);
    }
}
