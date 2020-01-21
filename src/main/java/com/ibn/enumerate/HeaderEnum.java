package com.ibn.enumerate;

/**
 * @version 1.0
 * @description:
 * @projectName：mylog-support
 * @see: com.ibn.enumerate
 * @author： RenBin
 * @createTime：2020/1/20 15:45
 */
public enum HeaderEnum {
    /**
     * @description: 用来验证验证码的token
     * @author：RenBin
     * @createTime：2020/1/21 9:26
     */
    IMG_TOKEN("图片验证码token", "img-token"),
    /**
     * @description: 用户验证通过后获得的token
     * @author：RenBin
     * @createTime：2020/1/21 9:27
     */
    AUTHORIZATION("存放token", "Authorization");
    /**
     * @description: 枚举的描述
     * @author：RenBin
     * @createTime：2020/1/20 15:46
     */
    private String desc;
    /**
     * @description: 枚举值
     * @author：RenBin
     * @createTime：2020/1/20 15:46
     */
    private String values;

    HeaderEnum(String desc, String values) {
        this.desc = desc;
        this.values = values;
    }

    public String getDesc() {
        return desc;
    }

    public String getValues() {
        return values;
    }
}
