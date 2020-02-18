package com.ibn.base.entity;

import com.ibn.enumerate.StatusCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @version 1.0
 * @description:
 * @projectName：mylog-support
 * @see: com.ibn.base.entity
 * @author： RenBin
 * @createTime：2020/1/20 15:24
 */
@Data
public class ResultInfo<T> implements Serializable {
    private static final long serialVersionUID = 6793350277616007958L;

    private Integer status;
    private String message;
    private T data;

    public ResultInfo success(String message) {
        this.status = StatusCodeEnum.OK.getCode();
        this.message = message;
        return this;
    }

    public ResultInfo<T> response(T response) {
        this.status = StatusCodeEnum.OK.getCode();
        this.message = StatusCodeEnum.OK.getDesc();
        this.data = response;
        return this;
    }

    public ResultInfo error(String message) {
        this.status = StatusCodeEnum.ERROR.getCode();
        this.message = message;
        return this;
    }
}
