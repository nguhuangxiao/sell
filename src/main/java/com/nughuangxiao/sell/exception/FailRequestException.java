package com.nughuangxiao.sell.exception;

import com.nughuangxiao.sell.enums.ResultEnum;
import lombok.Getter;

@Getter
public class FailRequestException extends RuntimeException{

    private Integer code;

    public FailRequestException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public FailRequestException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
