package com.hoomoomoo.fims.app.chat;

import lombok.Data;

@Data
public class VoiceMessage extends BaseMessage{

    // 媒体ID
    private String MediaId;
    // 语音格式
    private String Format;

}
