package com.ibn.entity;

import lombok.Data;

/**
 * @version 1.0
 * @description:
 * @projectName：mylog-support
 * @see: com.ibn
 * @author： RenBin
 * @createTime：2020/1/20 16:30
 */
@Data
public class UserBaseDO {
    private Long id;
    private String userName;
    private String passWord;
}
