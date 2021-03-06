package com.hoomoomoo.fims.app.dao;

import com.hoomoomoo.fims.app.model.MailConfigModel;
import com.hoomoomoo.fims.app.model.SysParameterModel;
import com.hoomoomoo.fims.app.model.SysParameterQueryModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author hoomoomoo
 * @description 参数新dao
 * @package com.hoomoomoo.fims.app.dao
 * @date 2019/10/20
 */

@Mapper
public interface SysParameterDao {

    /**
     * 查询参数信息
     *
     * @param sysParameterQueryModel
     * @return
     */
    List<SysParameterModel> selectList(SysParameterQueryModel sysParameterQueryModel);

    /**
     * 保存参数信息
     *
     * @param sysParameterModel
     */
    void save(SysParameterModel sysParameterModel);

    /**
     * 修改dmp备份路径
     *
     * @param sysParameterModel
     */
    void updateBackupDir(SysParameterModel sysParameterModel);

    /**
     * 查询系统参数
     *
     * @param sysParameterQueryModel
     * @return
     */
    SysParameterModel selectSysParameter(SysParameterQueryModel sysParameterQueryModel);

    /**
     * 获取邮件配置参数
     *
     * @return
     */
    List<SysParameterModel> selectMailConfig();
}
