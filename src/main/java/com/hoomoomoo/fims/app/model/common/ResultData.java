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
     * 状态码：请求返回码 0正常返回 1异常返回
     */
    private String code;

    /**
     * 业务处理是否正常
     */
    private Boolean bizResult;

    /**
     * 提示消息
     */
    private String msg;

    /**
     * 结果集
     */
    private T data;

    /**
     * 请求正常 业务处理成功
     */
    public ResultData() {
        this.bizResult = true;
        this.code = STATUS_SUCCESS;
        this.msg = OPERATE_SUCCESS;
    }

    /**
     * 请求正常 业务处理成功
     *
     * @param msg
     */
    public ResultData(String msg) {
        this.bizResult = true;
        this.code = STATUS_SUCCESS;
        this.msg = msg;
    }

    /**
     * 请求 业务处理 入参：请求正常则业务处理成功 请求异常则业务处理失败
     *
     * @param code
     * @param msg
     */
    public ResultData(String code, String msg) {
        this.bizResult = STATUS_SUCCESS.equals(code);
        this.code = code;
        this.msg = msg;

    }

    /**
     * 请求正常 业务处理 入参
     *
     * @param bizResult
     * @param msg
     */
    public ResultData(Boolean bizResult, String msg) {
        this.code = STATUS_SUCCESS;
        this.bizResult = bizResult;
        this.msg = msg;
    }

    /**
     * 请求正常 业务处理 入参
     *
     * @param bizResult
     * @param msg
     * @param data
     */
    public ResultData(Boolean bizResult, String msg, T data) {
        this.code = STATUS_SUCCESS;
        this.bizResult = bizResult;
        this.msg = msg;
        this.data = data;
    }
}
