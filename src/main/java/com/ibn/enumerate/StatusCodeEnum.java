package com.ibn.enumerate;

/**
 * @version 1.0
 * @description:
 * @projectName：mylog-support
 * @see: com.ibn.enumerate
 * @author： RenBin
 * @createTime：2020/1/20 15:26
 */
public enum StatusCodeEnum {

    OK(200, "请求成功"),
    ERROR(500, "服务端错误");

    private Integer code;
    private String desc;

    StatusCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getCode() {
        return code;
    }
}
