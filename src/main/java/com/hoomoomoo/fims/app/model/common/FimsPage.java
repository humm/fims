package com.hoomoomoo.fims.app.model.common;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import static com.hoomoomoo.fims.app.consts.BusinessConst.PAGE_CODE_SUCCESS;
import static com.hoomoomoo.fims.app.consts.CueConst.*;

/**
 * @author humm23693
 * @description 分页信息
 * @package com.hoomoomoo.fims.app.model.common
 * @date 2019/08/10
 */

public class FimsPage<T> {

    @ApiModelProperty(value="状态码", required = false)
    private String code;

    @ApiModelProperty(value="提示信息", required = false)
    private String msg;

    @ApiModelProperty(value="当前页码", required = true)
    private Integer page;

    @ApiModelProperty(value="每页显示记录数", required = true)
    private Integer limit;

    @ApiModelProperty(value="总记录数", required = false)
    private Long count;

    @ApiModelProperty(value="分页数据", required = false)
    private List<T> data;

    public FimsPage() {
    }

    public FimsPage(Integer page, Integer limit) {
        this.page = page;
        this.limit = limit;
    }

    public FimsPage(Long count, List<T> data) {
        this.code = PAGE_CODE_SUCCESS;
        this.msg = PAGE_MSG_SUCCESS;
        this.count = count;
        this.data = data;
    }

    public FimsPage(String code, String msg, Long count, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
