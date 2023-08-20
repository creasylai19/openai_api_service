package com.creasy.openai.dto;

import com.creasy.openai.common.ResponseCodeEnum;

public class ResponseUtil {

    public static ResponseDto buildSuccess(Object data){
        return new ResponseDto(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDesc(), data);
    }

}
