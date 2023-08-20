package com.creasy.openai.common;

import lombok.Getter;

@Getter
public enum ModelEnum {

    GPT_3_5_TURBO("gpt-3.5-turbo","gpt-3.5-turbo");

    private String code;
    private String desc;

    ModelEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }


}
