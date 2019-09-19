package com.hoomoomoo.fims.app.chat;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class WechatConf {

    // 获取accessToken的接口
    public static final String GET_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    // 发送消息的接口
    public static final String PUSH_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s";

    private String appId = "wxa0320c68000b4e55";

    private String appsecret = "b25ee77f5cd1cbffbcab3a1118c38fda";

    // 发送消息的接口的访问凭证
    private String accessToken;
}
