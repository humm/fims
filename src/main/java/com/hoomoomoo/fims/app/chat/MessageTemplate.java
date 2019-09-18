package com.hoomoomoo.fims.app.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class MessageTemplate {

    @JsonProperty("touser")
    private String toUser;

    @JsonProperty("template_id")
    private String templateId;

    private String url;

    private Map<String,String> miniprogram;

    private Map<String, Map<String, String>> data = new HashMap<>();

    public static Map<String, String> initData(String value, String color) {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("value", value);
        data.put("color", color);
        return data;
    }

}
