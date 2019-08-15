package com.hoomoomoo.fims.app.model.common;

import lombok.Data;

import static com.hoomoomoo.fims.app.consts.CueConst.OPERATE_SUCCESS;
import static com.hoomoomoo.fims.app.consts.BusinessConst.STATUS_SUCCESS;

/**
 * @author humm23693
 * @description 返回结果集
 * @package com.hoomoomoo.fims.app.model.common
 * @date 2019/08/05
 */

@Data
public class ResultData<T> {

    /**
     * 状态码
     */
    private String code;

    /**
     * 提示消息
     */
    private String msg;

    /**
     * 结果集
     */
    private T data;

    public ResultData() {
        this.code = STATUS_SUCCESS;
        this.msg = OPERATE_SUCCESS;
    }

    public ResultData(String msg) {
        this.msg = msg;
        this.code = STATUS_SUCCESS;
    }

    public ResultData(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultData(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
