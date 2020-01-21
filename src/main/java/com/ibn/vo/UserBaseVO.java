package com.ibn.vo;

import com.ibn.base.entity.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @version 1.0
 * @description:
 * @projectName：mylog-support
 * @see: com.ibn.vo
 * @author： RenBin
 * @createTime：2020/1/20 16:13
 */
@Data
public class UserBaseVO extends BaseVO {
    @NotEmpty(message = "用户名不能为空！")
    @Pattern(regexp = "(^1[3456789]\\d{9})|(^([A-Za-z0-9_\\-\\\\.\\u4e00-\\u9fa5])+@([A-Za-z0-9_\\-\\\\.])+\\." +
            "([A-Za-z]{2,8})$)",message = "用户名为电话号或邮箱")
    private String userName;
    @NotEmpty(message = "密码不能为空！")
    private String passWord;
    private String repassWord;
    @NotEmpty(message = "验证码不能为空！")
    private String validateCode;
}
