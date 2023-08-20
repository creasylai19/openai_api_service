package com.creasy.openai.common;

import lombok.Getter;

@Getter
public enum ResponseCodeEnum {

    SUCCESS("000000", "Success!"),
    UNKNOWN_ERROR("999999", "Unknown error!");

    private String code;
    private String desc;

    ResponseCodeEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

}
