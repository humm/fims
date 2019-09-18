package com.hoomoomoo.fims.app.chat;

import lombok.Data;

@Data
public class Result {

    private Integer errcode;

    private String errmsg;

    private Long msgid;
}
