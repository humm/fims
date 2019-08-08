package com.hoomoomoo.fims.app.dto;

import lombok.Data;

import static com.hoomoomoo.fims.app.consts.CueConst.OPERATE_SUCCESS;
import static com.hoomoomoo.fims.app.consts.BusinessConst.STATUS_SUCCESS;

/**
 * @author humm23693
 * @description 返回结果集
 * @package com.hoomoomoo.fims.app.dto.common
 * @date 2019/08/05
 */

@Data
public class ResponseData<T> {

    /**
     * 状态码
     */
    private String code;

    /**
     * 结果状态
     */
    private Boolean result;

    /**
     * 提示消息
     */
    private String messag;

    /**
     * 结果集
     */
    private T data;

    public ResponseData() {
        this.code = STATUS_SUCCESS;
        this.result = true;
        this.messag = OPERATE_SUCCESS;
    }

    public ResponseData(String messag) {
        this.messag = messag;
        this.code = STATUS_SUCCESS;
        this.result = true;
    }

    public ResponseData(String code, String messag) {
        this.code = code;
        this.messag = messag;
        this.result = STATUS_SUCCESS.equals(code);
    }

    public ResponseData(String code, String messag, T data) {
        this.code = code;
        this.messag = messag;
        this.data = data;
        this.result = STATUS_SUCCESS.equals(code);
    }
}
